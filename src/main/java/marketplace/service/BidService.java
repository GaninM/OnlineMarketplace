package marketplace.service;

import marketplace.model.Bid;

import java.util.Optional;

public interface BidService {

    void saveBid(Bid bid);

    Optional<Bid> findById(Long id);

    void deleteByProductId(Long id);

}
