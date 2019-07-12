package ai.turbochain.ipex.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import ai.turbochain.ipex.entity.ExchangeCoinSettlement;

public interface ExchangeCoinSettlementRepository extends JpaRepository<ExchangeCoinSettlement, Long>, JpaSpecificationExecutor<ExchangeCoinSettlement>, QueryDslPredicateExecutor<ExchangeCoinSettlement> {

    @Query("select a.symbol from  ExchangeCoinSettlement a where a.enable = 1 order by a.sort")
    Set<String> findSymbols();
}
