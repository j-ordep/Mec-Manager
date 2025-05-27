package com.mecmanager.entity;

import com.mecmanager.enums.WorkStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_work_order")
@Getter
@Setter
@NoArgsConstructor
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal cost;

    @Enumerated(EnumType.STRING)
    private WorkStatus status;

    private LocalDateTime entryDate;
    private LocalDateTime exitDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


    public WorkOrder(Long id, String description, BigDecimal cost, WorkStatus status, LocalDateTime entryDate, LocalDateTime exitDate, Car car) {
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.status = status;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.car = car;
    }

    @Override
    public String toString() {
        return "WorkOrder{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", status=" + status +
                ", entryDate=" + entryDate +
                ", exitDate=" + exitDate +
                ", car=" + car +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkOrder workOrder = (WorkOrder) o;
        return Objects.equals(id, workOrder.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
