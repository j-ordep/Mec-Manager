package com.mecmanager.controller.request;

import com.mecmanager.entity.Car;
import com.mecmanager.enums.WorkStatus;

import java.math.BigDecimal;

public record WorkOrderRequest(String description, BigDecimal cost, WorkStatus status, Car car) {
}
