package ru.anvarzhonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anvarzhonov.entity.client.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}