package com.examflow2.controllers;

import java.io.IOException;

import com.examflow.models.Enseignant;
import com.examflow.dao.EnseignantDao;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginController {
	public static Enseignant sessionEnseignant;
	
	@FXML
	public Label titleLogin;
	
	@FXML
	public Label pLogin;
	
	@FXML
	public Label email;
	
	@FXML
	public TextField inputEmail;
	
	@FXML
	public Label password;
	
	@FXML
	public PasswordField inputMdp;
	
	@FXML
	public Button btnLogin;
	
	public Stage stage;

	public void setStage(Stage stage) {
		this.stage= stage;
	}
	
	public void initialize() {
		  adjustLayout();
		  btnLogin.setOnAction(e -> {
				try {
					handleLogin();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
	}
	
	public void handleLogin() throws IOException {
		String email = inputEmail.getText();
		String mdp = inputMdp.getText();
		
		if (email.isEmpty() || mdp.isEmpty()) {
            return;
        }
		
		sessionEnseignant = EnseignantDao.authEnseignant(email, mdp);
		
		if(sessionEnseignant != null) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/examflow2/resources/fxml/home.fxml"));
			Scene homeScene;
			try {
				homeScene = new Scene(loader.load());
			    HomeController homeController = loader.getController();
			    homeController.setStage(stage);
			     stage.setScene(homeScene);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} 
		
	}
	
	public void adjustLayout() {
		Font kanitFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow2/resources/fonts/Kanit-Regular.ttf"), 20);
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow2/resources/fonts/Poppins-Regular.ttf"), 20);
        Font poppinsFont = Font.font(customFont.getName(), 12);
        Font poppinsFont2 = Font.font(customFont.getName(), FontWeight.BOLD, 14);
        
        titleLogin.setFont(kanitFont);
        titleLogin.setLayoutX(16);
        titleLogin.setPrefWidth(344);
        titleLogin.setPrefHeight(17);
        
        pLogin.setFont(poppinsFont);
        pLogin.setLayoutY(67);
		
        email.setFont(poppinsFont);
        password.setFont(poppinsFont);
        btnLogin.setFont(poppinsFont2);
	}

}
