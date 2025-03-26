package com.mecronald.MecManager.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;


@Embeddable
public class CarClientPK {

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public CarClientPK() {
    }

    public CarClientPK(Client client, Car car) {
        this.client = client;
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        CarClientPK that = (CarClientPK) o;
        return Objects.equals(client, that.client) && Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, car);
    }
}
