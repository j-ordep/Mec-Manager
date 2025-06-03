
package com.mecmanager.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_client_car")
@Getter
@Setter
@NoArgsConstructor
public class ClientCar {

    @EmbeddedId
    private ClientCarId id = new ClientCarId();

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @MapsId("carId")
    @JoinColumn(name = "car_id")
    private Car car;

    private LocalDateTime associationDate;

    public ClientCar(Client client, Car car, LocalDateTime associationDate) {
        this.client = client;
        this.car = car;
        this.associationDate = associationDate;
        this.id = new ClientCarId(client.getId(), car.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientCar)) return false;
        ClientCar clientCar = (ClientCar) o;
        return Objects.equals(id, clientCar.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClientCar{" +
                "client=" + client.getName() +
                ", car=" + car.getLicensePlate() +
                ", associationDate=" + associationDate +
                '}';
    }
}