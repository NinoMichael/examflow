package com.examflow.models;

public class Reponse {
	public int idReponse;
	public Qcm qcm;
	public String intitule;
	public boolean estBonne;
	
	public Reponse() {}
	
	public Reponse(int idReponse, Qcm qcm, String intitule, boolean estBonne) {
		this.idReponse = idReponse;
		this.qcm = qcm;
		this.intitule = intitule;
		this.estBonne = estBonne;
	}

	public int getIdReponse() {
		return idReponse;
	}

	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}

	public Qcm getQcm() {
		return qcm;
	}

	public void setQcm(Qcm qcm) {
		this.qcm = qcm;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public boolean isEstBonne() {
		return estBonne;
	}

	public void setEstBonne(boolean estBonne) {
		this.estBonne = estBonne;
	}
}
