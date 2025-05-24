package com.mecmanager.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_client_car")
public class Client_Car {

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

}
