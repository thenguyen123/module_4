package com.example.furuma_manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double cost;
    private String unit;
    private String status;

    @JsonBackReference
    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> conTractDetails;

    public AttachFacility(int id, String name, double cost, String unit, String status, Set<ContractDetail> conTractDetails) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.conTractDetails = conTractDetails;
    }

    public AttachFacility() {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ContractDetail> getConTractDetails() {
        return conTractDetails;
    }

    public void setConTractDetails(Set<ContractDetail> conTractDetails) {
        this.conTractDetails = conTractDetails;
    }
}
