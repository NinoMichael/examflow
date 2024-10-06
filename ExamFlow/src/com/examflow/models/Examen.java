package com.examflow.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Examen {
	public int id;
	public String code;
	public String theme;
	public LocalDateTime debut;
	public LocalDateTime fin;
	public String instruction;
	public Enseignant enseignant;
	
	public Examen() {}
	
	public Examen(int id, String code, String theme, LocalDateTime debut, LocalDateTime fin, String instruction, Enseignant enseignant) {
		this.id = id;
		this.code = code;
		this.theme = theme;
		this.debut = debut;
		this.fin = fin;
		this.instruction = instruction;
		this.enseignant = enseignant;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public LocalDateTime getDebut() {
		return debut;
	}
	public void setDebut(LocalDate dateDebut, String heureDebut) {
		// Parse the heureDebut string to LocalTime
        LocalTime timeDebut = LocalTime.parse(heureDebut);
        
        // Combine LocalDate and LocalTime into LocalDateTime
        this.debut = LocalDateTime.of(dateDebut, timeDebut);

	}
	public LocalDateTime getFin() {
		return fin;
	}
	public void setFin(LocalDate dateFin, String heureFin) {
		LocalTime timeFin = LocalTime.parse(heureFin);
		this.fin = LocalDateTime.of(dateFin, timeFin);
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	
}
