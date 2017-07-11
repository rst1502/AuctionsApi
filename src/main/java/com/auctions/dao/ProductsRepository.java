package com.auctions.dao;

import com.auctions.model.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tsamuriwo on 7/10/17.
 */
public interface ProductsRepository extends CrudRepository<Products, Long> {

    List<Products> findByCategory(String category);

}
