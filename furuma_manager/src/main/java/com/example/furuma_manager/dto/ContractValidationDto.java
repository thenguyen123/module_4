package com.example.furuma_manager.dto;

import com.example.furuma_manager.model.ContractDetail;
import com.example.furuma_manager.model.Customer;
import com.example.furuma_manager.model.Employee;
import com.example.furuma_manager.model.Facility;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class ContractValidationDto {
    private int id;
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/\\d{4}$",message = "bạn cần nhập đúng định dạng DD/MM/YYYY")
    private String startDate;

    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[012])\\/\\d{4}$",message = "bạn cần nhập đúng định dạng DD/MM/YYYY")
    private String endDate;
    @Min(value = 0,message = "tiền cọt không thể là sô âm")
    private double deposit;
    private Employee employee;
    private Facility facility;
    private Customer customer;

    public ContractValidationDto(int id, String startDate, String endDate, double deposit, Employee employee, Facility facility, Customer customer) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.facility = facility;
        this.customer = customer;
    }

    public ContractValidationDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
