package com.auctions.model;


import com.auctions.utils.DomainKeyGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by tsamuriwo on 7/10/17.
 */
@Entity(name="bids")
public class Bids {
    @Id
    private Long id;
    @Version
    private Long version;
    private Date createdDate;
    private Date updtedDate;
    @ManyToOne
    @JoinColumn(name="Users_id",referencedColumnName="id")
    private Users users;
    @ManyToOne
    @JoinColumn(name="Products_id",referencedColumnName="id")
    private Products products;

    private Double offer;

    @PrePersist
    protected void init() {
        createdDate = new Date();
        if(id == null || id == 0l) {
            id = DomainKeyGenerator.getKey();
        }
    }

    public Bids(Long id, Long version, Date createdDate, Date updtedDate, Double offer) {
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.updtedDate = updtedDate;
        this.offer = offer;
    }

    public Bids(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdtedDate() {
        return updtedDate;
    }

    public void setUpdtedDate(Date updtedDate) {
        this.updtedDate = updtedDate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Double getOffer() {
        return offer;
    }

    public void setOffer(Double offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return "Bids{" +
                "id=" + id +
                ", version=" + version +
                ", createdDate=" + createdDate +
                ", updtedDate=" + updtedDate +
                ", userId=" +users +
                ", productId=" + products +
                ", offer=" + offer +
                '}';
    }
}
