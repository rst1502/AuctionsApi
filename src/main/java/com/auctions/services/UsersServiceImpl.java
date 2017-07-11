package com.auctions.services;

import com.auctions.dao.UsersRepository;
import com.auctions.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsamuriwo on 7/10/17.
 */
@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    UsersRepository usersRepository;

    public Users createUser(Users users){
        usersRepository.save(users);
        return users;
    }

    @Override
    public Users updateUser(Users users) {
        usersRepository.save(users);
        return users;
    }

    public Users getUser(Long id){
        Users users = usersRepository.findOne(id);
        return users;
    }

    public List<Users> allUsers(){
        List<Users> allUsers = (List<Users>) usersRepository.findAll();
        return allUsers;
    }

    public Users login(String email, String password){
       Users users = usersRepository.findByEmailAndPassword(email, password);
        return users;
    }
}
