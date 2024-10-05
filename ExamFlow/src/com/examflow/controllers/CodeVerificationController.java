package com.examflow.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CodeVerificationController {
	@FXML
	public Label titleCode, introCode, resendCode;
	
	@FXML
	public Button btnValidate;
	
	public HomeController homeController;

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
	
	public void initialize() {
		adjustLayout();
	}
	
	public void adjustLayout() {
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow/resources/fonts/Poppins-Regular.ttf"), 20);
		Font poppinsFont12 = Font.font(customFont.getName(), 12);
		Font poppinsFontBold12 = Font.font(customFont.getName(), FontWeight.BOLD, 12);
		Font poppinsFont = Font.font(customFont.getName(), FontWeight.BOLD, 18);
		
		titleCode.setFont(poppinsFont);
		introCode.setFont(poppinsFont12);
		resendCode.setFont(poppinsFont12);
		btnValidate.setFont(poppinsFontBold12);
	}
}
