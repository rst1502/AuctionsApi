package com.auctions.controller;

import com.auctions.model.Products;
import com.auctions.model.Users;
import com.auctions.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tsamuriwo on 7/10/17.
 */
@RestController
@RequestMapping(value = "/api")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Products>> allUsers(){
        return new ResponseEntity<>(productsService.allProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Products> createProduct(@RequestBody Products products){
        return new ResponseEntity<>(productsService.createProducts(products),HttpStatus.OK);
    }
    @RequestMapping(value = "/products", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Products> updateProduct(@RequestBody Products products){
        return new ResponseEntity<>(productsService.updateProducts(products),HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{category}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Products>> productsByCategory(@PathVariable String category){
        return new ResponseEntity<>(productsService.productsByCategory(category),HttpStatus.OK);
    }
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Products> product(@PathVariable Long id){
        return new ResponseEntity<>(productsService.getProduct(id),HttpStatus.OK);
    }
}
