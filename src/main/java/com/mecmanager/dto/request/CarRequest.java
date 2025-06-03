package com.mecmanager.dto.request;


public record CarRequest(
        String licensePlate,
        String vehicleModel,
        int productionYear,
        String color
){ }
