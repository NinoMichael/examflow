package com.examflow.controllers;

import com.examflow.dao.QcmDao;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ResultExamController {
	@FXML
	public Label success, answeredQuestion, answered, durationTime, duration, exactAnswer, exact, totalPoint, total;
	
	@FXML
	public ImageView logoutIcon;
	
	public HomeController homeController;

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}
	
	public Stage stage;

	public void setStage(Stage stage) {
		this.stage= stage;
	}
	
	public void initialize() {
		adjustLayout();
		loadResultExamen();
		
		logoutIcon.setOnMouseClicked(e -> {
		    homeController.dashboardInterface();
		});

	}
	
	public void loadResultExamen() {
		answered.setText(String.valueOf(ExamenController.answeredQuestion) + " / " + QcmDao.getAllQcm(ListExamController.staticExamen).size());
		
		int tempsPasse = (int) Math.ceil(ExamenController.cumulTemps / 60);
		duration.setText(String.valueOf(tempsPasse) + " min");
		
		if (ExamenController.score % 1 == 0) {
	        total.setText(String.valueOf((int) ExamenController.score) + " / 20");
	    } else {
	    	total.setText(String.valueOf(ExamenController.score) + " / 20");
	    }
		
		exact.setText(String.valueOf(ExamenController.finalReponsesCorrectes));
	}
	
	public void adjustLayout() {
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow/resources/fonts/Poppins-Regular.ttf"), 20);
		Font poppinsFont12 = Font.font(customFont.getName(), 12);
		Font poppinsFontBold16 = Font.font(customFont.getName(), FontWeight.BOLD, 16);
		Font poppinsFontBold20 = Font.font(customFont.getName(), FontWeight.BOLD, 20);
		
		success.setFont(poppinsFontBold16);
		answeredQuestion.setFont(poppinsFont12);
		answered.setFont(poppinsFontBold20);
		durationTime.setFont(poppinsFont12);
		duration.setFont(poppinsFontBold20);
		exactAnswer.setFont(poppinsFont12);
		exact.setFont(poppinsFontBold20);
		totalPoint.setFont(poppinsFont12);
		total.setFont(poppinsFontBold20);
	}
	
	
}
