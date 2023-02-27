package com.example.furuma_manager.dto;

import com.example.furuma_manager.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.Period;

public class CustomerDto implements Validator {
    private int id;
    @Pattern(regexp = "^([\\p{L}\\s])+$", message = "Tên phải đúng định dạng.")
    private String name;
    @Email(message = "nhập sai định dạng")
    private String email;

    private String address;
    @Pattern(regexp = "^(090\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}|\\(84\\)\\+90\\d{7})$",
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx.")
    private String phoneNumber;
    @Pattern(regexp = "^[0-9]{9}|[0-9]{11}$", message = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9) ")
    private String idCard;
    private String dayOfBrith;
    private int gender;
    private CustomerType customerType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDayOfBrith() {
        return dayOfBrith;
    }

    public void setDayOfBrith(String dayOfBrith) {
        this.dayOfBrith = dayOfBrith;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String email, String address, String phoneNumber, String idCard, String dayOfBrith, int gender, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.idCard = idCard;
        this.dayOfBrith = dayOfBrith;
        this.gender = gender;
        this.customerType = customerType;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        LocalDate localDate = LocalDate.parse(customerDto.getDayOfBrith());
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(localDate, currentDate).getYears();
        if (age < 18) {
            errors.rejectValue("dayOfBrith", "dayOfBrith", "Bạn chưa 18+");
        }
    }
}