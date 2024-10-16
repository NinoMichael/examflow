package com.examflow.models;

public class Qcm {
	public int idQcm;
	public Examen examen;
	public String question;
	public int reboursSec;
	public double pointUnitaire;
	
	public Qcm() {}
	
	public Qcm(int idQcm, Examen idExamen, String question, int reboursSec, double pointUnitaire) {
		this.idQcm = idQcm;
		this.examen = idExamen;
		this.question = question;
		this.reboursSec = reboursSec;
		this.pointUnitaire = pointUnitaire;
	}

	public Qcm(int id, Examen exam) {
		this.idQcm = id;
		this.examen = exam;
	}

	public int getIdQcm() {
		return idQcm;
	}

	public void setIdQcm(int idQcm) {
		this.idQcm = idQcm;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
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
