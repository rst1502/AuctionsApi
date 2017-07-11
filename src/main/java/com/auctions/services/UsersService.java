package com.auctions.services;

import com.auctions.model.Users;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by tsamuriwo on 7/10/17.
 */
@Service
public interface UsersService {
    Users createUser(Users users);
    Users updateUser(Users users);
    Users login(String email, String password);
    Users getUser(Long id);
    List<Users> allUsers();
}
