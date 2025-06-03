package com.mecmanager.repository;

import com.mecmanager.domain.model.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
    Optional<WorkOrder> findByCarId(Long carId);
}
