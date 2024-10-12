package com.examflow2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardController {
	@FXML
	public Label createExamTitle, seeResultTitle, titleDash;
	
	public HomeController homeController;
	
	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
	
	public void initialize() {
		adjustLayout();
		
		createExamTitle.setOnMouseClicked(e -> {
			homeController.createExamInterface();
		});
	}
	
	public void adjustLayout() {
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow2/resources/fonts/Poppins-Regular.ttf"), 20);
		Font poppinsFont = Font.font(customFont.getName(), FontWeight.BOLD, 16);
		
		titleDash.setFont(poppinsFont);
		createExamTitle.setFont(poppinsFont);
		seeResultTitle.setFont(poppinsFont);
	}
}
