package com.mecmanager.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_car")
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_plate", nullable = false)
    private String licensePlate;

    @Column(name = "vehicle_model", nullable = false)
    private String vehicleModel;

    @Column(name = "production_year", nullable = false)
    private int productionYear;

    @Column(name = "color")
    private String color;

    @OneToMany(mappedBy = "car")
    private List<WorkOrder> workOrders = new ArrayList<>(); // evita nullPointerException

    public Car(Long id, String licensePlate, String vehicleModel, int productionYear, String color, List<WorkOrder> workOrders) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.vehicleModel = vehicleModel;
        this.productionYear = productionYear;
        this.color = color;
        this.workOrders = workOrders;
    }

    @Override
    public String toString() {
        return "Car{id=" + id + ", licensePlate='" + licensePlate + "', model='" + vehicleModel + "'}";
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

