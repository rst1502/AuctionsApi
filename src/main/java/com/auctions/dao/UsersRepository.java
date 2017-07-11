package com.auctions.dao;

import com.auctions.model.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tsamuriwo on 7/10/17.
 */
public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findByEmailAndPassword(String email,String password);
}
