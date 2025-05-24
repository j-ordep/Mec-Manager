package com.mecmanager.entity;

import com.mecmanager.enums.WorkStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal cost;

    @Enumerated(EnumType.STRING)
    private WorkStatus status;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;

    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;

    public WorkOrder() {
    }

    public WorkOrder(Long id, String description, BigDecimal cost, WorkStatus status, LocalDateTime dataEntrada, LocalDateTime dataSaida, Car car) {
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.status = status;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public WorkStatus getStatus() {
        return status;
    }

    public void setStatus(WorkStatus status) {
        this.status = status;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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
