package com.examflow2.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateExam2Controller {
	public HomeController homeController;
	
	@FXML
	public TextField inputQuestion;
	
	@FXML
	public Button btnNext;
	
    
    public void initialize() {
        btnNext.setOnAction(event -> {
            try {
            	homeController.switchToNextScene();
			} catch (IOException e) {
				e.printStackTrace();
			}
        });
    }
    
    /* public void handleRegister() throws IOException {
    	String theme = inputTheme.getText();
    	LocalDate dateDebut = inputDateDebut.getValue();
    	String heureDebut = inputHeureDebut.getText();
    	LocalDate dateFin = inputDateFin.getValue();
    	String heureFin = inputHeureFin.getText();
        String instruction = inputInstruction.getText();

        if (theme.isEmpty() || heureDebut.isEmpty() || heureFin.isEmpty() || instruction.isEmpty()) {
            System.out.println("Information incomplète");
            return;
        }
        
        Examen examen = new Examen();
        ExamenDao.createExamen(examen);
        
        switchToNextScene();
   } */
}
