package com.auctions.controller;

import com.auctions.model.Bids;
import com.auctions.model.Products;
import com.auctions.services.BidsService;
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
@RequestMapping(value = "/api" )
public class BidsConroller {
    @Autowired
    BidsService bidsService;


    @RequestMapping(value = "/offers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Bids>> allBids(@RequestBody Products products){
        return new ResponseEntity<>(bidsService.getBids(products), HttpStatus.OK);
    }
    @RequestMapping(value = "/offers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bids> createBids(@RequestBody Bids bids){
        return new ResponseEntity<>(bidsService.makeOffer(bids),HttpStatus.OK);
    }
    @RequestMapping(value= "/offers", method = RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bids> updateBids(@RequestBody Bids bids){
        return new ResponseEntity<Bids>(bidsService.updateBids(bids),HttpStatus.OK);
    }
    @RequestMapping(value= "/offers/{id}", method = RequestMethod.GET, consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bids> getBid(@PathVariable Long id ){
        return new ResponseEntity<Bids>(bidsService.getBid(id),HttpStatus.OK);
    }
}
