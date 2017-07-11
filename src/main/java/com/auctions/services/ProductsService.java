package com.auctions.services;

import com.auctions.model.Products;

import java.util.List;

/**
 * Created by tsamuriwo on 7/10/17.
 */
public interface ProductsService {
    List<Products> allProducts();
    Products createProducts(Products products);
    Products updateProducts(Products products);
    List<Products> productsByCategory(String category);
    Products getProduct(Long id);
}
