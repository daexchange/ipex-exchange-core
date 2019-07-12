package ai.turbochain.ipex.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.turbochain.ipex.dao.ExchangeCoinSettlementRepository;
import ai.turbochain.ipex.entity.ExchangeCoinSettlement;
import ai.turbochain.ipex.service.Base.BaseService;

@Service
public class ExchangeCoinSettlementService extends BaseService<ExchangeCoinSettlement> {
    @Autowired
    private ExchangeCoinSettlementRepository exchangeCoinSettlementRepository;

    public Set<String> findSymbols() {
        return exchangeCoinSettlementRepository.findSymbols();
    }
}
