package org.sid.services.imp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;

import org.sid.models.Utilisateur;
import org.sid.models.Voiture;
import org.sid.repositories.UtilisateurRepository;
import org.sid.services.UtilisateurService;
import org.sid.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vince
 * Créer les services à implémenter
 * Recuperer la reaquete et l'envoi au bon service
 *
 */

@Service
public class UtilisateurServiceImp implements UtilisateurService {
	
	@Autowired 
	private UtilisateurRepository repo;
	@Autowired
	private VoitureService VoitureService;
	
	
	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();	
	}
	
	@Override
	public Optional<Utilisateur> findById(String id) {
		return this.repo.findById(id);
	}
	
	@Override
	public List<Utilisateur> findAllByNom(String nom) {
		return this.repo.findAllByNom(nom);
	}
	
	@Override
	public Utilisateur update(Utilisateur u) {
		return this.repo.save(u);
	}
	
	@Override
	public void delete(String id) {
		this.repo.deleteById(id);	
		}
	
	@Override
	public Utilisateur save(Utilisateur u) {
		return this.repo.save(u);
	}

	@Override
	public List<Voiture> getVoiture(String uId){
		Optional<Utilisateur> Optional = this.findById(uId);
		if(Optional.isPresent()) {
			Utilisateur u = Optional.get();
			return u.getVoitures();
		}
		else
			return null;
	}

	@Override
	public Utilisateur addVoiture(String uid, String vid) {
		Utilisateur res=null;
		// TODO Auto-generated method stub
		Optional<Utilisateur> Optionnal = this.repo.findById(uid);
		if(Optionnal.isPresent()) {
			Utilisateur u = Optionnal.get();
			Optional<Voiture> OptV=this.VoitureService.findById(vid);
			if(OptV.isPresent()) {
				u.getVoitures().add(OptV.get());
				res=u;
				this.update(u);
			}
		}	
		return res;
	}
	
	@Override
	public Utilisateur deleteVoiture(String uid, String vid) {
		Utilisateur res=null;
		// TODO Auto-generated method stub
		Optional<Utilisateur> Optionnal = this.repo.findById(uid);
		if(Optionnal.isPresent()) {
			Utilisateur u = Optionnal.get();
			Optional<Voiture> OptV=this.VoitureService.findById(vid);
			if(OptV.isPresent()) {
				for(Voiture v : u.getVoitures()) {
					if(v.getId()==vid)
						u.getVoitures().remove(v);
				}
				res=u;
				this.update(u);
			}
		}	
		return res;
	}
	
	//Récupere les utilisateur au dessus d'un certain age
	@Override
	public List<Utilisateur> findAllByAgeGreaterThan(int age) {
		LocalDate date = LocalDate.now().minusYears(age);
		return this.repo.findByNaissanceLessThan(date);
	}
}

