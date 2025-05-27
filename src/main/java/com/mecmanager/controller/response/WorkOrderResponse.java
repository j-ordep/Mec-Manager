package com.mecmanager.controller.response;

import com.mecmanager.enums.WorkStatus;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record WorkOrderResponse(
        Long id,
        String description,
        BigDecimal cost,
        WorkStatus status,
        LocalDateTime entryDate,
        LocalDateTime exitDate,
        Long carId) {
}
