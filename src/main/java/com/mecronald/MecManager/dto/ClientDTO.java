package com.mecronald.MecManager.dto;

import com.mecronald.MecManager.entities.Client;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Data
@Builder
@AllArgsConstructor
public class ClientDTO {

    private Long id;
    private String name;
    private String cpf;
    private int phoneNumber;
    private String email;

    // Constructor to convert Client entity to ClientDTO
    public ClientDTO(Client entity) {
        BeanUtils.copyProperties(entity, this); // Copies properties from entity to this DTO
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
