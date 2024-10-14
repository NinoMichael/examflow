package com.examflow.models;

public class Reponse {
	public int idReponse;
	public Qcm idQcm;
	public String intitule;
	public boolean estBonne;
	
	public Reponse() {}
	
	public Reponse(int idReponse, Qcm idQcm, String intitule, boolean estBonne) {
		this.idReponse = idReponse;
		this.idQcm = idQcm;
		this.intitule = intitule;
		this.estBonne = estBonne;
	}

	public int getIdReponse() {
		return idReponse;
	}

	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}

	public Qcm getIdQcm() {
		return idQcm;
	}

	public void setIdQcm(Qcm idQcm) {
		this.idQcm = idQcm;
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
