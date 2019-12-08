package com.iztech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iztech.model.Client;
import com.iztech.repository.ClientJpaRepository;

@RestController
@RequestMapping(value="/client")
public class ClientController {
	
	@Autowired
	ClientJpaRepository clientJpaRepository;
	
	@PostMapping(value = "/insert")
	public Client insert(@RequestBody final Client client) {
		clientJpaRepository.save(client);
		return clientJpaRepository.findByFirstNameAndLastName(client.getFirstName(),client.getLastName());
	}
	
	@GetMapping(value="/all")
	public List<Client> findAll(){
		return clientJpaRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Optional<Client> findById(@PathVariable final Long id){
		return clientJpaRepository.findById(id);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable final Long id) {
		clientJpaRepository.deleteById(id);
	}
	
	

}
