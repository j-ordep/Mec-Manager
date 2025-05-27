package com.mecmanager.mapper;

import com.mecmanager.controller.request.WorkOrderRequest;
import com.mecmanager.controller.response.WorkOrderResponse;
import com.mecmanager.entity.WorkOrder;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WorkOrderMapper {

    public WorkOrder toWorkOrder(WorkOrderRequest request) {
        return WorkOrder
                .builder()
                .description(request.description())
                .cost(request.cost())
                .status(request.status())
                .build();
    }

    public WorkOrderResponse toResponse(WorkOrder workOrder) {
        return WorkOrderResponse
                .builder()
                .id(workOrder.getId())
                .cost(workOrder.getCost())
                .description(workOrder.getDescription())
                .status(workOrder.getStatus())
                .entryDate(workOrder.getEntryDate())
                .exitDate(workOrder.getExitDate())
                .carId(workOrder.getCar() != null ? workOrder.getCar().getId() : null)
                .build();
    }

}
