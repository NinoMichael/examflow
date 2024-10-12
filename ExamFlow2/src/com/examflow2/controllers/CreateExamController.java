package com.examflow2.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.examflow.dao.ExamenDao;
import com.examflow.models.Examen;
import com.examflow.models.Enseignant;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CreateExamController {
	@FXML
	public ImageView btnBack;
	
	@FXML
	public TextField inputTheme;
	
	@FXML
	public DatePicker inputDateDebut;
	
	@FXML
	public TextField inputHeureDebut;
	
	@FXML
	public DatePicker inputDateFin;
	
	@FXML
	public TextField inputHeureFin;
	
	@FXML
	public TextField inputInstruction;
	
	@FXML
	public Button btnNext;
	
	public Label theme, dateDebut, dateFin, heureDebut, heureFin, instruction, configure, prepareExam;
	
	public HomeController homeController;

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
	
	public void initialize() {
		adjustLayout();
		
		btnNext.setOnAction(event -> {
            try {
            	handleRegister();
			} catch (IOException e) {
				e.printStackTrace();
			}
        });
		
		btnBack.setOnMouseClicked(e1 -> {
			homeController.dashboardInterface();
		});
	}
	
	public void adjustLayout() {
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow2/resources/fonts/Poppins-Regular.ttf"), 20);
		Font poppinsFont12 = Font.font(customFont.getName(), 12);
		Font poppinsBoldFont12 = Font.font(customFont.getName(), FontWeight.BOLD, 12);
		Font poppinsFont = Font.font(customFont.getName(), FontWeight.BOLD, 18);
		
		theme.setFont(poppinsFont12);
		dateDebut.setFont(poppinsFont12);
		dateFin.setFont(poppinsFont12);
		heureDebut.setFont(poppinsFont12);
		heureFin.setFont(poppinsFont12);
		instruction.setFont(poppinsFont12);
		prepareExam.setFont(poppinsFont12);
		configure.setFont(poppinsFont);
		btnNext.setFont(poppinsBoldFont12);
	}

    public void handleRegister() throws IOException {
    	String themeInput = inputTheme.getText();
    	LocalDate dateDebut = inputDateDebut.getValue();
    	String heureDebut = inputHeureDebut.getText();
    	LocalDate dateFin = inputDateFin.getValue();
    	String heureFin = inputHeureFin.getText();
        String instruction = inputInstruction.getText();
        
        if (themeInput.isEmpty() || heureDebut.isEmpty() || heureFin.isEmpty() || instruction.isEmpty()) {
            System.out.println("Information incomplète");
            return;
        }
        
        LocalTime timeDebut = LocalTime.parse(heureDebut);
        LocalDateTime debut = LocalDateTime.of(dateDebut, timeDebut);
        
        LocalTime timeFin = LocalTime.parse(heureFin);
        LocalDateTime fin = LocalDateTime.of(dateFin, timeFin);

        Examen examen = new Examen();
        examen.setTheme(themeInput);
        examen.setDebut(dateDebut, heureDebut);
        examen.setFin(dateFin, heureFin);
        examen.setInstruction(instruction);
        
        ExamenDao.createExamen(examen, LoginController.sessionEnseignant);
        
        homeController.createExam2Interface();
    }
}
