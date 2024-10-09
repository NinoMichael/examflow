package com.examflow.controllers;

import com.examflow.controllers.ListExamPassedController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ListExamPassedController {
	@FXML
	public Label sessionExam, theme, nameTeacher, dateDebut, dateFin;
	
	@FXML
	public AnchorPane anchorPaneExam;
	
	public HomeController homeController;

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
	
	public void initialize() {
		adjustLayout();
		anchorPaneExam.setOnMouseClicked(e -> {
			homeController.codeVerifInterface();
		});
	}
	
	public void adjustLayout() {
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow/resources/fonts/Poppins-Regular.ttf"), 20);
		Font poppinsFont12 = Font.font(customFont.getName(), 12);
		Font poppinsFontBold14 = Font.font(customFont.getName(), FontWeight.BOLD, 14);
		Font poppinsFont = Font.font(customFont.getName(), FontWeight.BOLD, 18);
		
		sessionExam.setFont(poppinsFont);
		nameTeacher.setFont(poppinsFontBold14);
		dateDebut.setFont(poppinsFont12);
		dateFin.setFont(poppinsFont12);
		theme.setFont(poppinsFontBold14);
		
	}
	
}
