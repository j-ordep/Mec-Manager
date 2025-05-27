package com.mecmanager.mapper;

import com.mecmanager.controller.request.CarRequest;
import com.mecmanager.controller.response.CarResponse;
import com.mecmanager.entity.Car;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.Optional;

@UtilityClass
public class CarMapper {

    public Car toEntity(CarRequest request) {
        return Car
                .builder()
                .licensePlate(request.licensePlate())
                .vehicleModel(request.vehicleModel())
                .productionYear(request.productionYear())
                .color(request.color())
                .build();
    }

    public CarResponse toResponse(Car car) {
        return CarResponse
                .builder()
                .id(car.getId())
                .licensePlate(car.getLicensePlate())
                .vehicleModel(car.getVehicleModel())
                .productionYear(car.getProductionYear())
                .color(car.getColor())
                .workOrders(Optional.ofNullable(car.getWorkOrders())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(WorkOrderMapper::toResponse)
                        .toList())
                .build();
    }
}
