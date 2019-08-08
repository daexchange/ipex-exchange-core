package ai.turbochain.ipex.service;


import ai.turbochain.ipex.dao.ExchangeCoinRepository;
import ai.turbochain.ipex.entity.ExchangeCoin;
import ai.turbochain.ipex.pagination.Criteria;
import com.querydsl.core.types.Predicate;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ExchangeCoinService {
    @Autowired
    private ExchangeCoinRepository coinRepository;

    public List<ExchangeCoin> findAllEnabled() {
        Specification<ExchangeCoin> spec = (root, criteriaQuery, criteriaBuilder) -> {
            Path<String> enable = root.get("enable");
            criteriaQuery.where(criteriaBuilder.equal(enable, 1));
            return null;
        };
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "sort");
        Sort sort = new Sort(order);
        return coinRepository.findAll(spec, sort);
    }


    public List<ExchangeCoin> findAllEnabled(String coinSymbol, String basecion) {
    	if (StringUtils.isBlank(coinSymbol) && StringUtils.isBlank(basecion)) {
    	  return null;
    	}
    	
    	Specification<ExchangeCoin> specification = (root, criteriaQuery, criteriaBuilder) -> {
        
    		Path<String> enable = root.get("enable");
    		Path<String> coinSymbolPath = root.get("coinSymbol");
    		Path<String> baseSymbolPath = root.get("baseSymbol");
          
    		javax.persistence.criteria.Predicate predicate1 = criteriaBuilder.equal(enable, Integer.valueOf(1));
    		javax.persistence.criteria.Predicate predicate2 = criteriaBuilder.like(coinSymbolPath, "%" + coinSymbol + "%");
    		javax.persistence.criteria.Predicate predicate3 = criteriaBuilder.equal(baseSymbolPath, basecion);
            
    		if (StringUtils.isNotBlank(coinSymbol) && StringUtils.isNotBlank(basecion)) {
    			return criteriaBuilder.and(new javax.persistence.criteria.Predicate[] { predicate1, predicate2, predicate3 }); 
    		} else {
    			return criteriaBuilder.and(predicate1, predicate3);
    		}  
        };
      
      Sort.Order order = new Sort.Order(Sort.Direction.ASC, "sort");
      Sort sort = new Sort(new Sort.Order[] { order });
      
      return this.coinRepository.findAll(specification, sort);
    }
    
    
    public List<ExchangeCoin> findAllByFlag(int flag) {
        Specification<ExchangeCoin> spec = (root, criteriaQuery, criteriaBuilder) -> {
            Path<String> enable = root.get("enable");
            Path<Integer> flagPath = root.get("flag");
            criteriaQuery.where(criteriaBuilder.equal(enable, 1));
            criteriaQuery.where(criteriaBuilder.equal(flagPath, flag));
            return null;
        };
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "sort");
        Sort sort = new Sort(order);
        return coinRepository.findAll(spec, sort);
    }

    public ExchangeCoin findOne(String id) {
        return coinRepository.findOne(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deletes(String[] ids) {
        for (String id : ids) {
            coinRepository.delete(id);
        }
    }

    public ExchangeCoin save(ExchangeCoin exchangeCoin) {
        return coinRepository.save(exchangeCoin);
    }

    public Page<ExchangeCoin> pageQuery(int pageNo, Integer pageSize) {
        Sort orders = Criteria.sortStatic("sort");
        PageRequest pageRequest = new PageRequest(pageNo - 1, pageSize, orders);
        return coinRepository.findAll(pageRequest);
    }

    public ExchangeCoin findBySymbol(String symbol) {
        return coinRepository.findBySymbol(symbol);
    }

    public List<ExchangeCoin> findAll() {
        return coinRepository.findAll();
    }

    public boolean isSupported(String symbol) {
        return findBySymbol(symbol) != null;
    }

    public Page<ExchangeCoin> findAll(Predicate predicate, Pageable pageable) {
        return coinRepository.findAll(predicate, pageable);
    }

    public List<String> getBaseSymbol() {
        return coinRepository.findBaseSymbol();
    }

    public List<String> getCoinSymbol(String baseSymbol) {
        return coinRepository.findCoinSymbol(baseSymbol);
    }

    public List<String> getAllCoin(){
        return coinRepository.findAllCoinSymbol();
    }

}
