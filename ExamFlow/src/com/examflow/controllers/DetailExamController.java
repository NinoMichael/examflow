package com.examflow.controllers;

import java.time.Duration;

import com.examflow.dao.QcmDao;
import com.examflow.models.Examen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DetailExamController {
	@FXML
	public Label theme, themeIntitule, duree, sessionDuration, question, numberQuestion, point, totalPoint, welcomeExam, consigneExam;
	
	@FXML
	public Button btnStartExam;
	
	public HomeController homeController;

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
	
	public void initialize() {
		adjustLayout();
		loadDataExam();
		btnStartExam.setOnAction(e -> {
			homeController.examenInterface();
		});
	}
	
	public void loadDataExam() {
		Examen exam = ListExamController.staticExamen;
		int totalQuestion = QcmDao.getTotalQuestion(exam);
		
		themeIntitule.setText(exam.getTheme());
		String totalQuestionStr = String.valueOf(totalQuestion);
		numberQuestion.setText(totalQuestionStr);
		
		Duration duration = Duration.between(exam.getDebut(), exam.getFin());
		sessionDuration.setText(String.valueOf(duration.toHours()) + " heures");
		
		consigneExam.setText(exam.getInstruction());
	}
	
	public void adjustLayout() {
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow/resources/fonts/Poppins-Regular.ttf"), 20);
		Font poppinsFont12 = Font.font(customFont.getName(), 12);
		Font poppinsFontBold16 = Font.font(customFont.getName(), FontWeight.BOLD, 16);
		
		theme.setFont(poppinsFont12);
		themeIntitule.setFont(poppinsFontBold16);
		duree.setFont(poppinsFont12);
		sessionDuration.setFont(poppinsFontBold16);
		question.setFont(poppinsFont12);
		numberQuestion.setFont(poppinsFontBold16);
		point.setFont(poppinsFont12);
		totalPoint.setFont(poppinsFontBold16);
		welcomeExam.setFont(poppinsFontBold16);
		consigneExam.setFont(poppinsFont12);
	}
}
