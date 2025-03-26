package com.mecronald.MecManager.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_car_client")
public class CarClient {

    @EmbeddedId
    private CarClientPK id = new CarClientPK();

    public CarClient() {
    }

    public CarClient(Client client, Car car) {
        id.setClient(client);
        id.setCar(car);
    }

    public CarClientPK getId() {
        return id;
    }

    public void setId(CarClientPK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarClient that = (CarClient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
