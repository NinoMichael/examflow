package com.examflow2.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SplashController {
    @FXML
    public ProgressBar progressBar;

    @FXML
    public VBox rootBoxe;
    
    public Stage stage;
    
    public void setStage(Stage stage) {
		this.stage = stage;
	}

    public void initialize() {
        animateProgressBar();
    }

    public void animateProgressBar() {
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), 0.0)),
            new KeyFrame(Duration.seconds(5), new KeyValue(progressBar.progressProperty(), 1.0))
        );

        timeline.setCycleCount(1);
        timeline.play();

        timeline.setOnFinished(event -> switchToNextScene());
    }



    private void switchToNextScene() {
        try {
        	 FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/examflow2/resources/fxml/login.fxml"));
             Scene loginScene = new Scene(loader.load());

             LoginController loginController = loader.getController();
             loginController.setStage(stage);

             stage.setScene(loginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
}
