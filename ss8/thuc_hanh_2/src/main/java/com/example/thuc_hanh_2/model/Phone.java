package com.example.thuc_hanh_2.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone  implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  String number;

    public Phone(int id, String phone) {
        this.id = id;
        this.number = phone;
    }

    public Phone(int id) {
        this.id = id;
    }

    public Phone() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
Phone phone1= (Phone) target;
String number=phone1.getNumber();
        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");
        if(number.length()>11||number.length()<10){
            errors.rejectValue("number", "number.length");
        } if (!number.startsWith("0")){
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches");
        }
    }
}
