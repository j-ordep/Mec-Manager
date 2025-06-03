package com.mecmanager.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record CarResponse(
        Long id,
        String licensePlate,
        String vehicleModel,
        int productionYear, String color,
        List<WorkOrderResponse> workOrders
) { }
