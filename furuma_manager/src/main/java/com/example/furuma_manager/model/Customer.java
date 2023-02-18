package com.example.furuma_manager.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dayOfBrith;
    private int gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name="customer_type",referencedColumnName = "id")
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer")
    private Set<Contract> contractSet;
    private boolean isDelete;

    public Customer(int id, String name, String dayOfBrith, int gender, String idCard, String phoneNumber,
                    String email, String address, CustomerType customerType, Set<Contract> contractSet, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.dayOfBrith = dayOfBrith;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contractSet = contractSet;
        this.isDelete = isDelete;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }


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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Customer() {
    }
}
