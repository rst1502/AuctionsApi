package com.auctions.services;

import com.auctions.dao.BidsRepository;
import com.auctions.model.Bids;
import com.auctions.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by tsamuriwo on 7/10/17.
 */

@Service
public class BidsServiceImpl implements BidsService {

    @Autowired
    BidsRepository bidsRepository;

    @Override
    public Bids makeOffer(Bids offer) {
        bidsRepository.save(offer);
        return offer;
    }

    @Override
    public List<Bids> getBids(Products products) {
        List<Bids> allBids = bidsRepository.findByProducts(products);
        return allBids;
    }

    @Override
    public Bids getBid(Long id){
        Bids bids = bidsRepository.findOne(id);
        return bids;
    }

    @Override
    public Bids updateBids(Bids bids) {
        bidsRepository.save(bids);
        return bids;
    }
}
