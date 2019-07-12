package ai.turbochain.ipex.service;

import ai.turbochain.ipex.dao.ExchangeOrderDetailRepository;
import ai.turbochain.ipex.dao.ExchangeOrderRepository;
import ai.turbochain.ipex.dao.OrderDetailAggregationRepository;
import ai.turbochain.ipex.entity.ExchangeOrderDetail;
import ai.turbochain.ipex.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ExchangeOrderDetailService {
    @Autowired
    private ExchangeOrderDetailRepository orderDetailRepository;

    @Autowired
    private ExchangeOrderRepository exchangeOrderRepository ;

    @Autowired
    private MemberService memberService ;

    @Autowired
    private OrderDetailAggregationRepository orderDetailAggregationRepository;


    /**
     * 查询某订单的成交详情
     * @param orderId
     * @return
     */
    public List<ExchangeOrderDetail> findAllByOrderId(String orderId){
        return orderDetailRepository.findAllByOrderId(orderId);
    }

    public ExchangeOrderDetail save(ExchangeOrderDetail detail){
       return orderDetailRepository.save(detail);
    }
}
