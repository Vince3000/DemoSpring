package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.models.Voiture;

/**
 * @author vince
 *Interface qui récupére les service implémeté dasn VoitureServiceImp
 */
public interface VoitureService {
	public List<Voiture> findAll();
	public Optional<Voiture> findById(String id);
	public Voiture update(Voiture u);
	public Voiture save(Voiture u);
	public void delete(String id);
}
