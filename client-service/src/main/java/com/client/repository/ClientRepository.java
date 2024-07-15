package com.client.repository;

import com.data.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("FROM Client WHERE email LIKE :email AND password LIKE :password")
    Optional<Client> findByEmailAndPassword(@Param(value = "email") String email, @Param(value = "password") String password);

}
