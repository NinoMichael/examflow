package com.examflow.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
		logoutIcon.setOnMouseClicked(e -> {
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/examflow/resources/fxml/home.fxml"));
		    Scene homeScene;
		    try {
		        homeScene = new Scene(loader.load());

		        HomeController homeReturnController = loader.getController();
		        homeReturnController.setStage(stage);  
		        stage.setScene(homeScene);            
		    } catch (IOException e1) {
		        e1.printStackTrace();
		    }
		});

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
