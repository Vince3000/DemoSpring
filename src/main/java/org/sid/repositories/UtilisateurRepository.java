package org.sid.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.sid.models.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;

//Connection à MongoDB
public interface UtilisateurRepository extends MongoRepository<Utilisateur, String>{
	public List<Utilisateur> findAllByNom(String nom);
	public List<Utilisateur> findAllByAgeLessThan(LocalDate min);
	public Optional<Utilisateur> findAllVoitureByNom(String utilisateur);
    public List<Utilisateur> findByNaissanceLessThan(LocalDate date);
	public List<Utilisateur> findAll();
}

