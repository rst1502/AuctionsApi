package com.auctions.model;

import com.auctions.utils.DomainKeyGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by tsamuriwo on 7/10/17.
 */
@Entity(name="products")
public class Products {
    @Id
    private Long id;
    @Version
    private Long version;
    private Date createdDate;
    private Date updtedDate;
    private String productName;
    private Double expectedProductprice;
    @ManyToOne()
    @JoinColumn(name="users_id",referencedColumnName="id")
    private Users users;
    private String discription;
    private Date closingTime;
    private String category;


    @PrePersist
    protected void init() {
        createdDate = new Date();
        if(id == null || id == 0l) {
            id = DomainKeyGenerator.getKey();
        }
    }

    public Products(){};

    public Products(Long id, Long version, Date createdDate, Date updtedDate, String productName, Double expectedProductprice, Users users, String discription, Date closingTime, String category) {
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.updtedDate = updtedDate;
        this.productName = productName;
        this.expectedProductprice = expectedProductprice;
        this.users = users;
        this.discription = discription;
        this.closingTime = closingTime;
        this.category = category;
    }

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getExpectedProductprice() {
        return expectedProductprice;
    }

    public void setExpectedProductprice(Double expectedProductprice) {
        this.expectedProductprice = expectedProductprice;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", version=" + version +
                ", createdDate=" + createdDate +
                ", updtedDate=" + updtedDate +
                ", productName='" + productName + '\'' +
                ", expectedProductprice=" + expectedProductprice +
                ", users='" + users + '\'' +
                ", discription='" + discription + '\'' +
                ", closingTime=" + closingTime +
                ", category='" + category + '\'' +
                '}';
    }
}
