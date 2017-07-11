package com.auctions.services;

import com.auctions.model.Bids;
import com.auctions.model.Products;

import java.util.List;

/**
 * Created by tsamuriwo on 7/10/17.
 */
public interface BidsService {
    Bids makeOffer (Bids offer);
    List<Bids> getBids(Products products);
    Bids updateBids(Bids bids);
    Bids getBid(Long id);
}
