package com.auctions.dao;

import com.auctions.model.Bids;
import com.auctions.model.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tsamuriwo on 7/10/17.
 */
public interface BidsRepository extends CrudRepository<Bids, Long> {
    List<Bids> findByProducts(Products products);
}
