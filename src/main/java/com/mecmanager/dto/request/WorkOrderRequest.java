package com.mecmanager.dto.request;

import com.mecmanager.domain.model.Car;
import com.mecmanager.domain.enums.WorkStatus;

import java.math.BigDecimal;

public record WorkOrderRequest(
        String description,
        BigDecimal cost,
        WorkStatus status,
        Car car
) { }
