package com.examflow.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HomeController {
	@FXML
	public Label logout, profil, nameUser, pLogout, numberNotif;
	
	@FXML
	public Pane dashContainer;
	
	@FXML
	public ScrollPane notifScroll;
	
	@FXML
	public GridPane notifGrid;
	
	@FXML
	public Rectangle rectangleCenter, rectangleTop, rectangleBottom;
	
	@FXML
	public AnchorPane anchorDialog;
	
	@FXML
	public Pane optionContainer;
	
	@FXML
	public ImageView userProfile, bellIcon;
	
	public static final int NOTIFCOLUMN = 1; 
	
	public static int i = 0;
	
	public int column = 0;
	
	public int row = 0;
	
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
	 
	 public void hideNotifContainer() {
		 notifScroll.setVisible(false);
		    bellIcon.setOnMouseClicked(event -> {
		        notifScroll.setVisible(!notifScroll.isVisible());
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
		System.out.println("SUCCES");
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
	                dashContainer.getChildren().add(notifScroll);
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
	                
	                notifScroll.setVisible(true);
	                dashContainer.getChildren().clear() ;  
	                dashContainer.getChildren().add(content);
	                dashContainer.getChildren().add(optionContainer);
	                dashContainer.getChildren().add(rectangleCenter);
	                dashContainer.getChildren().add(anchorDialog);
	                dashContainer.getChildren().add(notifScroll);
	                hideOptionContainer();
	                hideNotifContainer();
	        		logoutAction();
	        		
	        		PauseTransition delay = new PauseTransition(Duration.seconds(5));
	        		
	        		delay.setOnFinished(event -> {
	        	            i++;
	        	            String iText = String.valueOf(i);
	        	            numberNotif.setText(iText);
	        	 
	        	            String msgNotif = "Le code d'accès pour l'examen de l'enseignant " + 
	        	                                ListExamController.staticExamen.getEnseignant().getNom() + 
	        	                                " est " + ListExamController.staticExamen.getCode();
	        	            Pane codePane = createNotifPane("/com/examflow/resources/images/icons/exam.png", msgNotif);
	        	            notifGrid.add(codePane, column, row);
	        	            
	        	            if (i == 1) {
	        	                GridPane.setMargin(codePane, new Insets(0, 0, 0, 0));
	        	            } else {
	        	                GridPane.setMargin(codePane, new Insets(40, 0, 0, 0));
	        	            }
	        	            
	        	            column++;
	        	            if (column == NOTIFCOLUMN) {
	        	                column = 0;
	        	                row++; 
	        	            }
	        	        });

	        	        delay.play();
	        		
	            } else {
	                System.out.println("codeVerification.fxml not found!");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	
	public Pane createNotifPane(String src, String notif) {
		Pane pane = new Pane();
        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);
        pane.setStyle("-fx-background-color: white;");

        ImageView imageView = new ImageView();
        imageView.setFitHeight(21.0);
        imageView.setFitWidth(20.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(18.0);
        imageView.setOpacity(0.68);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        InputStream srcStream = getClass().getResourceAsStream(src);
        Image image = new Image(srcStream);
        imageView.setImage(image);
        
        Label label = new Label(notif);
        label.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        label.setLayoutX(45.0);
        label.setLayoutY(2.0);
        label.setPrefHeight(52.0);
        label.setPrefWidth(139.0);
        label.setWrapText(true);
        label.setFont(new Font("System Italic", 10.0));

        pane.getChildren().addAll(imageView, label);

        return pane;
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
