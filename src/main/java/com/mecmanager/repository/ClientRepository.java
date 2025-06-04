package com.mecmanager.repository;

import com.mecmanager.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Optional<Client> FindByCpf(String cpf);
}
