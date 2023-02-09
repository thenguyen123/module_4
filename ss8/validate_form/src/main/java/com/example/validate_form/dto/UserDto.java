package com.example.validate_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto  {
    @Size(min = 5, max = 45,message = "tên phải có độ dài tối thiểu bằng 5 và tối đa bằng 45")
    private String firstName;
    @Size(min = 5, max = 45 ,message = "tên phải có độ dài tối thiểu bằng 5 và tối đa bằng 45")
    private String lastName;
    @Pattern(regexp ="^0([0-9]{10}|[0-9]{9})$",message = "số điện thoại phải bắt đầu bằng 0 và có 10 đến 11 chữa số ")
    private String phoneNumber;
    @Min(value = 18,message = "tuổi phải lớn hơn 18")
    private int age;
    @Email(message = "email chưa đúng định dạng")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
