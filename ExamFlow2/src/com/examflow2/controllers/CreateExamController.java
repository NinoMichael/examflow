package com.examflow2.controllers;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CreateExamController {
	public Label theme, dateDebut, dateFin, heureDebut, heureFin, instruction, configure, prepareExam;
	
	public Button btnNext;
	
	public HomeController homeController;

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
	
	public void initialize() {
		adjustLayout();
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
}
