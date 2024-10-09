package com.examflow.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ExamenController {
	@FXML
	public Label rebours, theme, questions, nombreQuestion, intituleQuestion;
	
	@FXML
	public CheckBox reponse1;
	
	@FXML
	public Button btnValideReponse;
	
	public HomeController homeController;

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
	
	public void initialize() {
		adjustLayout();
		btnValideReponse.setOnAction(e -> {
			homeController.resultExamInterface();
		});
	}
	
	public void adjustLayout() {
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow/resources/fonts/Poppins-Regular.ttf"), 20);
		Font poppinsFont12 = Font.font(customFont.getName(), 12);
		Font poppinsFontBold12 = Font.font(customFont.getName(), FontWeight.BOLD, 12);
		Font poppinsFontBold14 = Font.font(customFont.getName(), FontWeight.BOLD, 14);
		Font poppinsFontBold16 = Font.font(customFont.getName(), FontWeight.BOLD, 16);
		Font poppinsFontBold22 = Font.font(customFont.getName(), FontWeight.BOLD, 22);
		
		theme.setFont(poppinsFontBold12);
		rebours.setFont(poppinsFontBold22);
		questions.setFont(poppinsFont12);
		nombreQuestion.setFont(poppinsFontBold14);
		intituleQuestion.setFont(poppinsFontBold16);
		reponse1.setFont(poppinsFontBold12);
	}
}
