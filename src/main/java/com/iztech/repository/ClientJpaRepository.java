package com.iztech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iztech.model.Client;

public interface ClientJpaRepository extends JpaRepository<Client, Long>{

	public Client findByFirstNameAndLastName(String firstName,String LastName);

}
