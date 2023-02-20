package com.example.furuma_manager.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(225) not null")
    private String name;
    @Column(columnDefinition = "varchar(225) not null")

    private String dateOfBirth;
    @Column(columnDefinition = "varchar(225) unique ")
    private String idCard;

    @Column(columnDefinition = "varchar(225) not null")
    private double salary;
    @Column(columnDefinition = "varchar(225) unique")
    private String phoneNumber;
    @Column(columnDefinition = "varchar(225) unique")
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    private Division division;
    @ManyToOne
    @JoinColumn(name = "education_degree_id",referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "position")
    private Position position;
    @OneToMany(mappedBy = "employee")
    private Set<Contract> contractSet;
    @ManyToOne
    @JoinColumn(name = "username",referencedColumnName = "username")
    private User user;
    private boolean isDelete;


    public Employee(int id, String name, String dateOfBirth, String idCard, double salary, String phoneNumber, String email, String address, Division division,
                    EducationDegree educationDegree, Position position, Set<Contract> contractSet, User user, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.division = division;
        this.educationDegree = educationDegree;
        this.position = position;
        this.contractSet = contractSet;
        this.user = user;
        this.isDelete = isDelete;
    }

    public Employee() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
