package com.examflow.controllers;

import java.io.InputStream;
import java.util.List;

import com.examflow.controllers.ListExamController;
import com.examflow.dao.ExamenDao;
import com.examflow.models.Examen;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ListExamController {
	@FXML
	public static Examen staticExamen;
	
	@FXML
	public Label sessionExam, introListExam;
	
	@FXML
	public GridPane gridPaneExam;
	
	@FXML
	public ImageView btnBack;
	
	public HomeController homeController;
	
	public static final int COLUMNS = 2; 

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
	
	public void initialize() {
		adjustLayout();
		loadExamenData();
		
		btnBack.setOnMouseClicked(e-> {
			homeController.dashboardInterface();
		});
	}
	
	public void loadExamenData() {
		 List<Examen> examenList = ExamenDao.getAllExamen();
		 
		 int column = 0;
	     int row = 0;
	        
	     gridPaneExam.setHgap(60); 
	     gridPaneExam.setVgap(60); 
	     
	     for (Examen examen : examenList) { 
	           AnchorPane anchorPaneExam = createExamenPane(examen);

	            gridPaneExam.add(anchorPaneExam, column, row);
	            GridPane.setMargin(anchorPaneExam, new Insets(10, 10, 10, 10));
	            
	            anchorPaneExam.setOnMouseClicked(e-> {
	            	staticExamen = examen;
	            	homeController.codeVerifInterface();
	            });   

	            column++;
	            if (column == COLUMNS) {
	                column = 0;
	                row++; 
	            }
	        }	 
	}
	
	public AnchorPane createExamenPane(Examen examen) {
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow/resources/fonts/Poppins-Regular.ttf"), 20);
		Font poppinsFont12 = Font.font(customFont.getName(), 12);
		Font poppinsFontBold14 = Font.font(customFont.getName(), FontWeight.BOLD, 14);
		
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setPrefHeight(131.0);
        anchorPane.setPrefWidth(225.0);
        anchorPane.setStyle(
                "-fx-background-color: white; " +
                "-fx-background-radius: 5;"
            );
        anchorPane.setPickOnBounds(true);
        anchorPane.setCursor(Cursor.HAND);
        
        Label nameTeacher = new Label();
        nameTeacher.setText(examen.getEnseignant().getNom());
        nameTeacher.setLayoutX(102.0);
        nameTeacher.setLayoutY(14.0);
        nameTeacher.setPrefHeight(29.0);
        nameTeacher.setPrefWidth(201.0);
        
        Label dateDebut = new Label(); 
        LocalDateTime dateDebutValue = examen.getDebut(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm");
        String formattedDateDebut = dateDebutValue.format(formatter);
        dateDebut.setText(formattedDateDebut);
        dateDebut.setLayoutX(128.0);
        dateDebut.setLayoutY(44.0);
        dateDebut.setPrefHeight(29.0);
        dateDebut.setPrefWidth(175.0);
        
        Label dateFin = new Label(); 
        LocalDateTime dateFinValue = examen.getFin(); 
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm");
        String formattedDateFin =  dateFinValue.format(formatter2);
        dateFin.setText(formattedDateFin);
        dateFin.setLayoutX(128.0);
        dateFin.setLayoutY(63.0);
        dateFin.setPrefHeight(29.0);
        dateFin.setPrefWidth(175.0);
        
		nameTeacher.setFont(poppinsFontBold14);
		dateDebut.setFont(poppinsFont12);
		dateFin.setFont(poppinsFont12);
        
        InputStream clockStream = getClass().getResourceAsStream("/com/examflow/resources/images/icons/clock.png");
        if (clockStream == null) {
            System.out.println("Image 'clock.png' not found!");
        } else {
            Image clockImage = new Image(clockStream);
            ImageView clockImageView = new ImageView(clockImage);
            clockImageView.setFitHeight(16.0);
            clockImageView.setFitWidth(18.0);
            clockImageView.setLayoutX(103.0);
            clockImageView.setLayoutY(58.0);
            clockImageView.setOpacity(0.72);
            clockImageView.setPickOnBounds(false);
            clockImageView.setPreserveRatio(true);
            anchorPane.getChildren().add(clockImageView);
        }

        InputStream checkedStream = getClass().getResourceAsStream("/com/examflow/resources/images/icons/checked.png");
        if (checkedStream == null) {
            System.out.println("Image 'checked.png' not found!");
        } else {
            Image checkedImage = new Image(checkedStream);
            ImageView checkedImageView = new ImageView(checkedImage);
            checkedImageView.setFitHeight(16.0);
            checkedImageView.setFitWidth(18.0);
            checkedImageView.setLayoutX(103.0);
            checkedImageView.setLayoutY(103.0);
            checkedImageView.setOpacity(0.72);
            checkedImageView.setPickOnBounds(false);
            checkedImageView.setPreserveRatio(true);
            anchorPane.getChildren().add(checkedImageView);
        }

        InputStream examenStream = getClass().getResourceAsStream("/com/examflow/resources/images/icons/examen.png");
        if (examenStream == null) {
            System.out.println("Image 'examen.png' not found!");
        } else {
            Image examenImage = new Image(examenStream);
            ImageView examenImageView = new ImageView(examenImage);
            examenImageView.setFitHeight(57.0);
            examenImageView.setFitWidth(59.0);
            examenImageView.setLayoutX(23.0);
            examenImageView.setLayoutY(38.0);
            examenImageView.setOpacity(0.72);
            examenImageView.setPickOnBounds(false);
            examenImageView.setPreserveRatio(true);
            anchorPane.getChildren().add(examenImageView);
        }

        Label labelOuvert = new Label("Ouvert");
        labelOuvert.setLayoutX(128.0);
        labelOuvert.setLayoutY(96.0);
        labelOuvert.setPrefHeight(29.0);
        labelOuvert.setPrefWidth(201.0);
        
        anchorPane.getChildren().addAll(nameTeacher, dateDebut, dateFin, labelOuvert);
        
        return anchorPane;
	}
	
	
	public void adjustLayout() {
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow/resources/fonts/Poppins-Regular.ttf"), 20);
		Font poppinsFont12 = Font.font(customFont.getName(), 12);
		Font poppinsFont = Font.font(customFont.getName(), FontWeight.BOLD, 18);
		
		sessionExam.setFont(poppinsFont);
		introListExam.setFont(poppinsFont12);
		
	}
	
}
