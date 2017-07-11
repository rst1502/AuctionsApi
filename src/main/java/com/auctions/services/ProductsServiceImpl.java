package com.auctions.services;

import com.auctions.dao.ProductsRepository;
import com.auctions.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by tsamuriwo on 7/10/17.
 */
@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public Products createProducts(Products products) {
        products = productsRepository.save(products);
        return products;
    }

    @Override
    public Products updateProducts(Products products) {
        products = productsRepository.save(products);
        return products;
    }

    @Override
    public List<Products> productsByCategory(String category) {
        List<Products> products = productsRepository.findByCategory(category);
        return products;
    }

    public Products getProduct(Long Id){
        Products product = productsRepository.findOne(Id);
        return  product;
    }

    @Override
    public List<Products> allProducts() {
        return (List<Products>) productsRepository.findAll();
    }
}
