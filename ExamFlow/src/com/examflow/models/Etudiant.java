package com.examflow.models;

import java.time.LocalDateTime;

public class Etudiant {
	public int id;
	public String nom;
	public String email;
	public String mdp;
	public LocalDateTime dateInscription;
	
	public Etudiant() {}

	public Etudiant(int id, String nom, String email, String mdp, LocalDateTime dateInscription) {
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.mdp = mdp;
		this.dateInscription = dateInscription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public LocalDateTime getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(LocalDateTime dateInscription) {
		this.dateInscription = dateInscription;
	}
	
	
		
}
