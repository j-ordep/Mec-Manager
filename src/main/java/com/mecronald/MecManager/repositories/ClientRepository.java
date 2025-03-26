package com.mecronald.MecManager.repositories;

import com.mecronald.MecManager.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Cliente, Long> {
}
