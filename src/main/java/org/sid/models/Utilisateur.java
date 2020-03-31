package org.sid.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Permet de definir ce dont on a besoin dans le code
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
	@Id
	private String id;
	private String nom;
	private LocalDate naissance;
	@DBRef
	private List<Voiture> voitures = new ArrayList<>();
}
