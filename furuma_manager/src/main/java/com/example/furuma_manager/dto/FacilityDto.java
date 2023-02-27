package com.example.furuma_manager.dto;

import com.example.furuma_manager.model.FacilityType;
import com.example.furuma_manager.model.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {
    private int id;
    @Pattern(regexp = "^[A-Z][a-z]*[0-9]+(\\s[A-Z][a-z]*[0-9]+)+$", message = "Tên phải được viết hoa chữ cái đầu")
    private String name;

    @Min(value = 1, message = "Diện tích phải lớn hơn 0")
    private int area;

    @Min(value = 1, message = "Giá phải lớn hơn 0")
    private double cost;
    @Min(value = 1, message = "số người tối đa phải là số nguyên dương")
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Min(value = 0, message = "diện tích phaải lớn hơn 0")
    private double poolArea;
    @Min(value = 0, message = "số tầng phải lớn hon 0")
    private int numberOfFloors;

    private String facilityFree;

    private RentType rentType;
    private FacilityType facilityType;

    public FacilityDto(int id, String name, int area, double cost, int maxPeople, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloors, String facilityFree, RentType rentType, FacilityType facilityType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public FacilityDto(int id, String name, int area, double cost, int maxPeople, String standardRoom,
                       String descriptionOtherConvenience, double poolArea, int numberOfFloors, String facilityFree, RentType rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
    }


    public FacilityDto() {
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        if (!checkInteger(facilityDto.maxPeople, facilityDto.maxPeople)) {
            errors.rejectValue("maxPeople", "maxPeople", "Số người phải là sô nguyên dương");
        }
        if(!checkInteger(facilityDto.numberOfFloors,facilityDto.numberOfFloors)){
            errors.rejectValue("numberOfFloors","numberOfFloors","số tầng phải là số nguyên dương");
        }
    }

    public boolean checkInteger(double number, int number2) {
        return number - number2 == 0;

    }
}
