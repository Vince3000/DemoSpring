package org.sid.controllers;

import java.util.List;
import java.util.Optional;

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

import org.sid.models.Utilisateur;
import org.sid.models.Voiture;
import org.sid.services.UtilisateurService;
/**
 * @author vince
 *Permet l'utilisation
 */

@RestController
@CrossOrigin
@RequestMapping("utilisateurs") //pointe sur "localhost:8080/utilisateurs"
public class UtilisateurController {

	@Autowired	
	private UtilisateurService service;

	@PostMapping("")
	public Utilisateur save(@RequestBody Utilisateur entity) {
		return this.service.save(entity);
	}

	@GetMapping("")
	public List<Utilisateur> findAll() {
		return this.service.findAll();
	}

	@GetMapping("{id}")
	public Optional<Utilisateur> findbyid(@PathVariable String id){
		return this.service.findById(id);
	}

	@GetMapping("nom/{nom}")
	public List<Utilisateur> findbyNom(@PathVariable String nom){
		return null;
	}

	@PutMapping("")
	public Utilisateur update(@RequestBody Utilisateur u) {
		return this.service.update(u);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}

	@DeleteMapping("")
	public void delete(@RequestBody Utilisateur u) {
		this.delete(u.getId());
	}

	//
	@GetMapping("agegt/{age}")
	public List<Utilisateur> findAllByAgeGreaterThan(@PathVariable int age) {
		return this.service.findAllByAgeGreaterThan(age);
	}

	//Toutes les voitures d'un utilisateur
	@GetMapping("{id}/voitures")
	public List<Voiture> getVoiture(String id) {
		return this.service.getVoiture(id);
	}

	//Ajouter une voiture à un utilisateur
	@PutMapping("{uid}/voitures/vid")
	public Utilisateur addVoiture(@PathVariable String uid, @PathVariable String vid) {
		//Appel au service
		return this.service.addVoiture(uid, vid);
		//return this.service.update(u);
	}

	//supprimer une voiture à un utilisateur
	@PutMapping("{uid}/voitures/vid")
	public Utilisateur deleteVoiture(@PathVariable String uid, @PathVariable String vid) {
		//Appel au service
		return this.service.deleteVoiture(uid, vid);
		//return this.service.update(u);
	}
}


