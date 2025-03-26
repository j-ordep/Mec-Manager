package com.mecronald.MecManager.dto;

import com.mecronald.MecManager.entities.Car;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class CarDTO {

    private long id;
    private String licensePlate;
    private String vehicleModel;
    private int productionYear;
    private String color;

    public CarDTO() {
    }

    public CarDTO(Car entity) {
        this.id = entity.getId();
        this.licensePlate = entity.getLicensePlate();
        this.vehicleModel = entity.getVehicleModel();
        this.productionYear = entity.getProductionYear();
        this.color = entity.getColor();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
