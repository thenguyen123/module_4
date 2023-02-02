package com.example.email.repository.impl;

import com.example.email.model.Email;
import com.example.email.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailRepository implements IEmailRepository {
    private static List<Email> list=new ArrayList<>();
    static {
        list.add(new Email(1,"English", 100,true,"The"));
        list.add(new Email(2,"Vietnamese", 25,false,"Quan"));
        list.add(new Email(3,"Japanese", 10,false,"Ehg"));
        list.add(new Email(4,"Chinese", 50,true,"thong"));
    }

    @Override
    public boolean update(Email email) {
        if(email!=null){
            Email e= findById(email.getId());
            e.setLanguages(email.getLanguages());
            e.setSignature(email.getSignature());
            e.setSize(email.getSize());
            e.setSpamsFilter(email.isSpamsFilter());
            return true;
        }return false;

    }

    @Override
    public Email findById(int id) {
        Email email = null;
        for (Email e: list) {
            if(e.getId()==id){
                email=e;
            }

        }
        return email;
    }

    @Override
    public List<Email> findAll() {
        return list;
    }
}
