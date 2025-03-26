package com.mecronald.MecManager.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "vehicle_model")
    private String vehicleModel;

    @Column(name = "production_year")
    private int productionYear;

    @Column(name = "color")
    private String color;

    public Car() {
    }

    public Car(Long id, String licensePlate, String vehicleModel, int productionYear, String color) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.vehicleModel = vehicleModel;
        this.productionYear = productionYear;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}