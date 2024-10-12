package com.examflow2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CreateExam2Controller {
	public HomeController homeController;
	
	@FXML
	public Label prepareExam, prepareExam1, configure;
	
	@FXML
	public TextField inputQuestion;
	
	@FXML
	public Button btnNext;

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
	
    public void initialize() {
    	adjustLayout();
        btnNext.setOnAction(event -> {
        });
    }
    
    public void adjustLayout() {
    	Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow2/resources/fonts/Poppins-Regular.ttf"), 20);
		Font poppinsFont12 = Font.font(customFont.getName(), 12);
		Font poppinsBoldFont12 = Font.font(customFont.getName(), FontWeight.BOLD, 12);
		Font poppinsFont = Font.font(customFont.getName(), FontWeight.BOLD, 18);
		
		inputQuestion.setFont(poppinsFont12);
		prepareExam.setFont(poppinsFont12);
		prepareExam1.setFont(poppinsFont12);
		configure.setFont(poppinsFont);
    }
    
}
