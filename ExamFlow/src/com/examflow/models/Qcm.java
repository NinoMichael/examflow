package com.examflow.models;

public class Qcm {
	public int idQcm;
	public Examen idExamen;
	public String question;
	public int reboursSec;
	public double pointUnitaire;
	
	public Qcm() {}
	
	public Qcm(int idQcm, Examen idExamen, String question, int reboursSec, double pointUnitaire) {
		this.idQcm = idQcm;
		this.idExamen = idExamen;
		this.question = question;
		this.reboursSec = reboursSec;
		this.pointUnitaire = pointUnitaire;
	}

	public int getIdQcm() {
		return idQcm;
	}

	public void setIdQcm(int idQcm) {
		this.idQcm = idQcm;
	}

	public Examen getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Examen idExamen) {
		this.idExamen = idExamen;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getReboursSec() {
		return reboursSec;
	}

	public void setReboursSec(int reboursSec) {
		this.reboursSec = reboursSec;
	}

	public double getPointUnitaire() {
		return pointUnitaire;
	}

	public void setPointUnitaire(double pointUnitaire) {
		this.pointUnitaire = pointUnitaire;
	}
	
	
}
