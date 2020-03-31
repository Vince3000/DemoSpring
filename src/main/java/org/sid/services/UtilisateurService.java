package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.models.Utilisateur;
import org.sid.models.Voiture;

/**
 * @author vince
 *Récupére les services implémenter dans UtilisateurServiceImp
 *c'est ici qu'on code
 */
public interface UtilisateurService {
	public List<Utilisateur> findAll();
	public List<Utilisateur> findAllByNom(String nom);
	public Optional<Utilisateur> findById(String id);
	public Utilisateur update(Utilisateur u);
	public Utilisateur save(Utilisateur u);
	public void delete(String id);
	public List<Voiture> getVoiture(String uId);
	public Utilisateur addVoiture(String uid, String vid);
	public Utilisateur deleteVoiture(String uid, String vid);
	public List<Utilisateur> findAllByAgeGreaterThan(int age);
}