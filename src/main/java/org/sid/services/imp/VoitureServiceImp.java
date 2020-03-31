package org.sid.services.imp;

import java.util.List;
import java.util.Optional;

import org.sid.models.Voiture;
import org.sid.repositories.VoitureRepository;
import org.sid.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vince
 *Créer les services à implémenter dans VoitureService
 */
@Service
public class VoitureServiceImp implements VoitureService {
	@Autowired 
	private VoitureRepository repo;
	
	@Override
	public List<Voiture> findAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();	
	}
	
	@Override
	public Optional<Voiture> findById(String id) {
		return this.repo.findById(id);
	}
	
	
	@Override
	public Voiture update(Voiture u) {
		return this.repo.save(u);
	}
	
	@Override
	public void delete(String id) {
		this.repo.deleteById(id);	
		}
	
	@Override
	public Voiture save(Voiture u) {
		return this.repo.save(u);
	}
	
}
