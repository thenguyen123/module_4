package com.example.thuc_hanh_2.repository;

import com.example.thuc_hanh_2.model.Login;
import com.example.thuc_hanh_2.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
 private static final  List<User> users=new ArrayList<>();
    static {
        users.add(new User("john","123456","John","john@codegym.vn",10));
        users.add(new User("bill","123456","Bill","bill@codegym.vn",15));
        users.add(new User("mike","123456","Mike","mike@codegym.vn",16));
    }
    @Override
    public User check(Login login) {
        for (User u:users) {
            if(u.getAccount().equals(login.getAccount())&& u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
