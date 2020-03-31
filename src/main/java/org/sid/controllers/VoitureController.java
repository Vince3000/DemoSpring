package org.sid.controllers;

import java.util.List;
import java.util.Optional;

import org.sid.models.Voiture;
import org.sid.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("voitures")

public class VoitureController {
	@Autowired	private VoitureService service;
	
	@GetMapping("")
	public List<Voiture> findAll() {
		return this.service.findAll();	
	}
	
	@PostMapping("")
	public Voiture save(@RequestBody Voiture entity) {
		return this.service.save(entity);//Récupère la method save dans VoitureService
	}

	@GetMapping("{id}")
	public Optional<Voiture> findByid(@PathVariable String id){
		return this.service.findById(id);
	}
	
	@GetMapping("nom/{name}")
	public List<Voiture> findByNom(@PathVariable String nom){
		return null;
	}
		
	@PutMapping("")
	public Voiture update(@RequestBody Voiture u) {
		return this.service.update(u);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
	
	/*
	@DeleteMapping("")
	public void delete(@RequestBody Voiture u) {
		this.delete(u.getId());
	}*/
}
