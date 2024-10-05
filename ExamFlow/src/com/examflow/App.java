package com.examflow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.examflow.controllers.SplashController;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader splashLoader = new FXMLLoader(getClass().getResource("/com/examflow/resources/fxml/splash.fxml"));
        Parent splashRoot = splashLoader.load();
        
        SplashController splashController = splashLoader.getController();
        splashController.setStage(primaryStage);
        
        Scene splashScene = new Scene(splashRoot);
        primaryStage.setScene(splashScene);
        primaryStage.setTitle("ExamFlow - Etudiant");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
