package com.auctions.model;

import com.auctions.utils.DomainKeyGenerator;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Version;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by tsamuriwo on 7/10/17.
 */
@Entity(name="users")
public class Users {

    private String firstname;
    private String surname;
    private String mobileNumber;
    private String password;
    private String email;
    @Id
    private Long id;
    @Version
    private Long version;
    private Date createdDate;
    private Date updtedDate;

    @PrePersist
    protected void init() {
        createdDate = new Date();
        if(id == null || id == 0l) {
            id = DomainKeyGenerator.getKey();
        }
    }

    public Users(String firstname,String email, String surname, String mobileNumber, String password, Long id, Long version, Date createdDate, Date updtedDate) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.updtedDate = updtedDate;
    }

    public Users(){};

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "Users{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", id=" + id +
                ", version=" + version +
                ", createdDate=" + createdDate +
                ", updtedDate=" + updtedDate +
                '}';
    }
}
