package com.examflow.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardController {
	@FXML
	public Label titleDash, passExamTitle, seeHistoryTitle;
	
	@FXML
	public AnchorPane passExamPane, seeHistoryPane;
	
	public HomeController homeController;
	
	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
	
	public void initialize() {
		adjustLayout();
		
		passExamPane.setOnMouseClicked(e -> {
			homeController.listExamInterface();
		});
		
		seeHistoryPane.setOnMouseClicked(e -> {
			homeController.listExamPassedInterface();
		});
	}
	
	public void adjustLayout() {
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow/resources/fonts/Poppins-Regular.ttf"), 20);
		Font poppinsFont = Font.font(customFont.getName(), FontWeight.BOLD, 16);
		
		titleDash.setFont(poppinsFont);
		passExamTitle.setFont(poppinsFont);
		seeHistoryTitle.setFont(poppinsFont);
	}
	
}	
