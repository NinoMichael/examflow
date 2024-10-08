package com.examflow.models;

public class Resultat {
	public int idResultat;
	public Examen idExamen;
	public Etudiant idEtudiant;
	public double note;
	
	public Resultat() {}
	
	public Resultat(int idResultat, Examen idExamen, Etudiant idEtudiant, double note) {
		this.idResultat = idResultat;
		this.idExamen = idExamen;
		this.idEtudiant = idEtudiant;
		this.note = note;
	}

	public int getIdResultat() {
		return idResultat;
	}

	public void setIdResultat(int idResultat) {
		this.idResultat = idResultat;
	}

	public Examen getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Examen idExamen) {
		this.idExamen = idExamen;
	}

	public Etudiant getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Etudiant idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}
}
