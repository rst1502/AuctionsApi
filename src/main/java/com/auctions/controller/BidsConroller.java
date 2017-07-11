package com.auctions.controller;

import com.auctions.model.Bids;
import com.auctions.model.Products;
import com.auctions.services.BidsService;
import com.auctions.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by tsamuriwo on 7/10/17.
 */
@RestController
@RequestMapping(value = "/api/products" )
public class BidsConroller {

    @Autowired
    BidsService bidsService;

    @Autowired
    ProductsService productsService;

    @RequestMapping(value = "/{productId}/offers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Bids>> allBids(@PathVariable Long id){
        Products products = productsService.getProduct(id);
        List<Bids> offers = bidsService.getBids(products);
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }
    @RequestMapping(value = "{productId}/offers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bids> createBids(@PathVariable Long id,@RequestBody Bids offer){
        Products products = productsService.getProduct(id);
        offer.setProducts(products);
        bidsService.makeOffer(offer);
        return new ResponseEntity<>(offer,HttpStatus.OK);
    }
    @RequestMapping(value= "/offers", method = RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bids> updateBids(@RequestBody Bids offer){
        bidsService.updateBids(offer);
        return new ResponseEntity<>(offer,HttpStatus.OK);
    }
    @RequestMapping(value= "offers/{id}", method = RequestMethod.GET, consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bids> getBid(@PathVariable Long id ){
        return new ResponseEntity<>(bidsService.getBid(id),HttpStatus.OK);
    }
}
