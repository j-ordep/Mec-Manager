package com.mecronald.MecManager.dto;

import com.mecronald.MecManager.entities.Carro;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Data
@Builder
@AllArgsConstructor
public class CarroDTO {

    private long id;
    private String placa;
    private String modelo;
    private int ano;
    private String cor;

    public CarroDTO(Carro entity) {
        this.id = entity.getId();
        this.placa = entity.getPlaca();
        this.modelo = entity.getModelo();
        this.ano = entity.getAno();
        this.cor = entity.getCor();
    }

    public CarroDTO() {
    }

}
