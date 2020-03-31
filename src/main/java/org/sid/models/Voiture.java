package org.sid.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Voiture {
	@Id
	private String id;
	private String name;
	private String immatriculation;
	private int age;
	@DBRef //Permets l'agrégation pas pour une collection
	private Utilisateur user;
	
}
