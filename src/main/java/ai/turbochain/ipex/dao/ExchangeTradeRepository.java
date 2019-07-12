package ai.turbochain.ipex.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import ai.turbochain.ipex.entity.ExchangeOrderDetail;
import ai.turbochain.ipex.entity.ExchangeTrade;

public interface ExchangeTradeRepository extends MongoRepository<ExchangeTrade,String> {
}
