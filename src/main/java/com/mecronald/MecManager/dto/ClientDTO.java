package com.mecronald.MecManager.dto;

import com.mecronald.MecManager.entities.Cliente;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Data
@Builder
@AllArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private int numero;
    private String email;

    // Contructor de Cliente para ClienteDTO
    // copia as propriedades do parametro entity para o objeto atual
    public ClienteDTO(Cliente entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
