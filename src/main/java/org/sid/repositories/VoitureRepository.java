package org.sid.repositories;

import org.sid.models.Voiture;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author vince
 *Paramétre la connection à la BDD
 */
public interface VoitureRepository extends MongoRepository<Voiture, String> {

}
