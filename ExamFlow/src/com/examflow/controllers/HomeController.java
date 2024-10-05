package com.examflow.controllers;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomeController {
	@FXML
	public Label introText, passExam, seeHistory, logout, profil, nameUser, pLogout;
	
	@FXML
	public StackPane dashContainer;
	
	@FXML
	public AnchorPane anchorDialog;
	
	@FXML
	public Pane optionContainer, paneExam;
	
	@FXML
	public ImageView userProfile, bellIcon;
	
	@FXML
	public Rectangle rectangle;
	
	@FXML
	public Button cancelLogout, confirmLogout;
	
	public Stage stage;

	public void setStage(Stage stage) {
		this.stage= stage;
	}
	
	public void initialize() {
		adjustLayout();
		optionContainer.setVisible(false);
		rectangle.setVisible(false);
		anchorDialog.setVisible(false);
		
		hideOptionContainer();
		logoutAction();
		
		nameUser.setText(LoginController.sessionEtudiant.getNom());
		paneExam.setOnMouseClicked(event -> {
			listExamInterface();
		}); 
	}
	
	 public void hideOptionContainer() {
        optionContainer.setVisible(false);
        userProfile.setOnMouseClicked(event -> optionContainer.setVisible(!optionContainer.isVisible()));
	 }
	 
	 public void logoutAction() {
		 logout.setOnMouseClicked(event -> {
			 rectangle.setVisible(true);
			 paneExam.setOpacity(0.5);
			 optionContainer.setVisible(false);
			 anchorDialog.setVisible(true);
			 
			 cancelLogout.setOnAction(event1 -> {
				 rectangle.setVisible(false);
				 paneExam.setOpacity(1);
				 anchorDialog.setVisible(false);
			 });
			 
			 confirmLogout.setOnAction(event2 -> {
				 LoginController.sessionEtudiant = null;
				 try {
		        	 FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/examflow/resources/fxml/login.fxml"));
		             Scene loginScene = new Scene(loader.load());

		             LoginController loginController = loader.getController();
		             loginController.setStage(stage);
		             

		             stage.setScene(loginScene);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			 });
		 });
	 }
	 
	public void listExamInterface() {
		 URL fxmlLocation = getClass().getResource("/com/examflow/resources/fxml/listExam.fxml");
	        try {
	            
	            if (fxmlLocation != null) {
	                FXMLLoader loader = new FXMLLoader(fxmlLocation);
	                VBox content = loader.load();
	   
	                ListExamController listExamController = loader.getController();
	                listExamController.setHomeController(this);
	                
	                dashContainer.getChildren().clear();
	                dashContainer.getChildren().add(content);
	            } else {
	                System.out.println("listExam.fxml not found!");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	
	public void codeVerifInterface() {
		 URL fxmlLocation = getClass().getResource("/com/examflow/resources/fxml/codeVerification.fxml");
	        try {
	            
	            if (fxmlLocation != null) {
	                FXMLLoader loader = new FXMLLoader(fxmlLocation);
	                VBox content = loader.load();
	   
	                CodeVerificationController codeVerificationController = loader.getController();
	                codeVerificationController.setHomeController(this);
	                
	                dashContainer.getChildren().clear();
	                dashContainer.getChildren().add(content);
	            } else {
	                System.out.println("codeVerification.fxml not found!");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	
	public void adjustLayout() {
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow/resources/fonts/Poppins-Regular.ttf"), 20);
        Font poppinsFont = Font.font(customFont.getName(), FontWeight.BOLD, 15);
        Font poppinsFont12 = Font.font(customFont.getName(), 12);
        Font poppinsFontBold12 = Font.font(customFont.getName(), FontWeight.BOLD, 12);
        
        introText.setFont(poppinsFont);
        introText.setPrefHeight(80);
        
        passExam.setFont(poppinsFont);
        seeHistory.setFont(poppinsFont);
        
        logout.setFont(poppinsFont12);
        profil.setFont(poppinsFont12);
        nameUser.setFont(poppinsFontBold12);
        
        pLogout.setFont(poppinsFont12);
        cancelLogout.setFont(poppinsFont12);
        confirmLogout.setFont(poppinsFont12);
	}
}
