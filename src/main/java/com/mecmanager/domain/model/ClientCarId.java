package com.mecmanager.domain.model;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ClientCarId {

    private Long clientId;
    private Long carId;

    public ClientCarId() {
    }

    public ClientCarId(Long clientId, Long carId) {
        this.clientId = clientId;
        this.carId = carId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientCarId)) return false;
        ClientCarId that = (ClientCarId) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(carId, that.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, carId);
    }

}
