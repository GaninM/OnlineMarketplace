package marketplace.service.impl;

import marketplace.model.Bid;
import marketplace.repository.BidRepository;
import marketplace.service.BidService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;

    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public void saveBid(Bid bid) {
        bidRepository.save(bid);
    }

    public Optional<Bid> findById(Long id) {
        return bidRepository.findById(id);
    }
}
