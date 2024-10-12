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
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomeController {
	@FXML
	public Label logout, profil, nameUser, pLogout;
	
	@FXML
	public Pane dashContainer;
	
	@FXML
	public Rectangle rectangleCenter, rectangleTop, rectangleBottom;
	
	@FXML
	public AnchorPane anchorDialog;
	
	@FXML
	public Pane optionContainer;
	
	@FXML
	public ImageView userProfile, bellIcon;
	
	@FXML
	public Button cancelLogout, confirmLogout;
	
	public Stage stage;

	public void setStage(Stage stage) {
		this.stage= stage;
	}
	
	public void initialize() {
		adjustLayout();
		dashboardInterface();
		anchorDialog.setVisible(false);
		rectangleCenter.setVisible(false);
		rectangleTop.setVisible(false);
		rectangleBottom.setVisible(false);
		nameUser.setText(LoginController.sessionEtudiant.getNom()); 
	}
	
	 public void hideOptionContainer() {
		 optionContainer.setVisible(false);
		    userProfile.setOnMouseClicked(event -> {
		        optionContainer.setVisible(!optionContainer.isVisible());
		    });
	 }
	 
	 public void logoutAction() {
		 logout.setOnMouseClicked(event -> {
			 optionContainer.setVisible(false);
			 rectangleCenter.setVisible(true);
			 rectangleTop.setVisible(true);
			 rectangleBottom.setVisible(true);
			 anchorDialog.setVisible(true);
			 
			 cancelLogout.setOnAction(event1 -> {
				 anchorDialog.setVisible(false);
				 rectangleCenter.setVisible(false);
				 rectangleTop.setVisible(false);
				 rectangleBottom.setVisible(false);
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
	 
	public void dashboardInterface() {
		URL fxmlLocation = getClass().getResource("/com/examflow/resources/fxml/dashboard.fxml");
        try {
            
            if (fxmlLocation != null) {
                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                VBox content = loader.load();
   
                DashboardController dashboardController = loader.getController();
                dashboardController.setHomeController(this);
                
                dashContainer.getChildren().clear() ;               
                dashContainer.getChildren().add(content);
                dashContainer.getChildren().add(optionContainer);
                dashContainer.getChildren().add(rectangleCenter);
                dashContainer.getChildren().add(anchorDialog);
                hideOptionContainer();
        		logoutAction();
            } else {
                System.out.println("listExam.fxml not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	 
	public void listExamInterface() {
		 URL fxmlLocation = getClass().getResource("/com/examflow/resources/fxml/listExam.fxml");
	        try {
	            
	            if (fxmlLocation != null) {
	                FXMLLoader loader = new FXMLLoader(fxmlLocation);
	                VBox content = loader.load();
	   
	                ListExamController listExamController = loader.getController();
	                listExamController.setHomeController(this);
	                
	                dashContainer.getChildren().clear() ;               
	                dashContainer.getChildren().add(content);
	                dashContainer.getChildren().add(optionContainer);
	                dashContainer.getChildren().add(rectangleCenter);
	                dashContainer.getChildren().add(anchorDialog);
	                hideOptionContainer();
	        		logoutAction();
	            } else {
	                System.out.println("listExam.fxml not found!");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	
	public void listExamPassedInterface() {
		 URL fxmlLocation = getClass().getResource("/com/examflow/resources/fxml/listExamPassed.fxml");
	        try {
	            
	            if (fxmlLocation != null) {
	                FXMLLoader loader = new FXMLLoader(fxmlLocation);
	                VBox content = loader.load();
	   
	                ListExamPassedController listExamPassedController = loader.getController();
	                listExamPassedController.setHomeController(this);
	                
	                dashContainer.getChildren().clear() ;               
	                dashContainer.getChildren().add(content);
	                dashContainer.getChildren().add(optionContainer);
	                dashContainer.getChildren().add(rectangleCenter);
	                dashContainer.getChildren().add(anchorDialog);
	                hideOptionContainer();
	        		logoutAction();
	            } else {
	                System.out.println("listExamPassed.fxml not found!");
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
	                
	                dashContainer.getChildren().clear() ;               
	                dashContainer.getChildren().add(content);
	                dashContainer.getChildren().add(optionContainer);
	                dashContainer.getChildren().add(rectangleCenter);
	                dashContainer.getChildren().add(anchorDialog);
	                hideOptionContainer();
	        		logoutAction();
	            } else {
	                System.out.println("codeVerification.fxml not found!");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	
	public void detailExamInterface() {
		 URL fxmlLocation = getClass().getResource("/com/examflow/resources/fxml/detailExam.fxml");
	        try {
	            
	            if (fxmlLocation != null) {
	                FXMLLoader loader = new FXMLLoader(fxmlLocation);
	                VBox content = loader.load();
	   
	                DetailExamController detailExamController = loader.getController();
	                detailExamController.setHomeController(this);
	                
	                dashContainer.getChildren().clear() ;               
	                dashContainer.getChildren().add(content);
	                dashContainer.getChildren().add(optionContainer);
	                dashContainer.getChildren().add(rectangleCenter);
	                dashContainer.getChildren().add(anchorDialog);
	                hideOptionContainer();
	        		logoutAction();
	            } else {
	                System.out.println("detailExam.fxml not found!");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	
	public void examenInterface() {
		 URL fxmlLocation = getClass().getResource("/com/examflow/resources/fxml/examen.fxml");
	        try {
	            
	            if (fxmlLocation != null) {
	                FXMLLoader loader = new FXMLLoader(fxmlLocation);
	                VBox content = loader.load();
	   
	                ExamenController examenController = loader.getController();
	                examenController.setHomeController(this);
	                
	                dashContainer.getChildren().clear() ;               
	                dashContainer.getChildren().add(content);
	                dashContainer.getChildren().add(optionContainer);
	                dashContainer.getChildren().add(rectangleCenter);
	                dashContainer.getChildren().add(anchorDialog);
	                hideOptionContainer();
	        		logoutAction();
	            } else {
	                System.out.println("examen.fxml not found!");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	
	public void resultExamInterface() {
		 URL fxmlLocation = getClass().getResource("/com/examflow/resources/fxml/resultExam.fxml");
	        try {
	            
	            if (fxmlLocation != null) {
	                FXMLLoader loader = new FXMLLoader(fxmlLocation);
	                VBox content = loader.load();
	   
	                ResultExamController resultExamController = loader.getController();
	                resultExamController.setHomeController(this);
	                
	                dashContainer.getChildren().clear() ;               
	                dashContainer.getChildren().add(content);
	                dashContainer.getChildren().add(optionContainer);
	                dashContainer.getChildren().add(rectangleCenter);
	                dashContainer.getChildren().add(anchorDialog);
	                hideOptionContainer();
	        		logoutAction();
	            } else {
	                System.out.println("resultExam.fxml not found!");
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
        
        logout.setFont(poppinsFont12);
        profil.setFont(poppinsFont12);
        nameUser.setFont(poppinsFontBold12);
        
        pLogout.setFont(poppinsFont12);
        cancelLogout.setFont(poppinsFont12);
        confirmLogout.setFont(poppinsFont12);
	}
	

}
