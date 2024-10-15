package com.examflow.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.examflow.dao.QcmDao;
import com.examflow.dao.ReponseDao;
import com.examflow.models.Qcm;
import com.examflow.models.Reponse;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ExamenController {
    @FXML
    public Label rebours, theme, questions, nombreQuestion, intituleQuestion;

    @FXML 
    public GridPane gridReponses;

    @FXML
    public Button btnValideReponse;

    public HomeController homeController;

    public List<Qcm> listQuestions;
    
    public static int finalReponsesCorrectes;

    public List<Reponse> reponsesCorrectes = new ArrayList<>();

    public List<Reponse> reponsesIncorrectes = new ArrayList<>();
    
    public int questionActuelle;

    public static double score;
    
    public AnimationTimer timer;
    
    public int tempsRestant; 
   
    public static double cumulTemps; 
    
    public static int answeredQuestion;

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }
    
    public void initialize() {
        adjustLayout();
        
        listQuestions = QcmDao.getAllQcm(ListExamController.staticExamen);
        answeredQuestion = listQuestions.size();
        Collections.shuffle(listQuestions); 
        loadExamen(questionActuelle);
        
        theme.setText(ListExamController.staticExamen.getTheme());
        
        btnValideReponse.setOnAction(e -> {
            validateReponse();
        });
    }
    
    public void loadExamen(int index) {
        if (index < listQuestions.size()) {
            Qcm question = listQuestions.get(index);
            intituleQuestion.setText(question.question);
            nombreQuestion.setText((index + 1) + " / " + listQuestions.size());

            tempsRestant = question.getReboursSec(); 
            rebours.setText(String.valueOf(tempsRestant));

            gridReponses.getChildren().clear();

            List<Reponse> reponses = ReponseDao.getAllReponse(question); 

            for (int i = 0; i < reponses.size(); i++) {
                Reponse reponse = reponses.get(i);

                CheckBox checkBox = new CheckBox(reponse.getIntitule());
                checkBox.setUserData(reponse);

                Pane pane = new Pane();
                pane.getChildren().add(checkBox);
                gridReponses.add(pane, 0, i);
            }

            startTimer();
        }
    }

    public void startTimer() {
        if (timer != null) {
            timer.stop();
        }

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (tempsRestant > 0) {
                    tempsRestant--;
                    rebours.setText(String.valueOf(tempsRestant) + "s");

                    try {
                        Thread.sleep(1000); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    this.stop();
                    answeredQuestion--;
                    validateReponse();
                }
            }
        };
        timer.start();
    }

    public void validateReponse() {
        if (timer != null) {
            timer.stop();
        }

        double tempsPasse = (tempsRestant > 0) ? (listQuestions.get(questionActuelle).getReboursSec() - tempsRestant) : listQuestions.get(questionActuelle).getReboursSec();
        cumulTemps += tempsPasse; 

        reponsesCorrectes.clear(); 
        reponsesIncorrectes.clear();
        double scoreQuestion = 0;

        final boolean [] reponseDonnee = {false}; 

        gridReponses.getChildren().forEach(node -> {
            if (node instanceof Pane) {
                Pane pane = (Pane) node;
                CheckBox checkBox = (CheckBox) pane.getChildren().get(0);
                Reponse reponse = (Reponse) checkBox.getUserData();

                if (checkBox.isSelected()) {
                    reponseDonnee[0] = true;
                    if (reponse.isEstBonne()) {
                        reponsesCorrectes.add(reponse);
                    } else {
                        reponsesIncorrectes.add(reponse); 
                    }
                }
            }
        });

        if (!reponseDonnee[0]) {
            reponsesIncorrectes.add(new Reponse()); 
        }

        if (!reponsesCorrectes.isEmpty() && reponsesIncorrectes.isEmpty()) {
            for (Reponse bonneReponse : reponsesCorrectes) {
                scoreQuestion += bonneReponse.getIdQcm().getPointUnitaire(); 
                finalReponsesCorrectes++;
            }
            score += scoreQuestion; 
        }

        questionActuelle++;
        if (questionActuelle < listQuestions.size()) {
            loadExamen(questionActuelle);
        } else {
            homeController.resultExamInterface();
        }
    }


    public void adjustLayout() {
        Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow/resources/fonts/Poppins-Regular.ttf"), 20);
        Font poppinsFont12 = Font.font(customFont.getName(), 12);
        Font poppinsFontBold12 = Font.font(customFont.getName(), FontWeight.BOLD, 12);
        Font poppinsFontBold14 = Font.font(customFont.getName(), FontWeight.BOLD, 14);
        Font poppinsFontBold16 = Font.font(customFont.getName(), FontWeight.BOLD, 16);
        Font poppinsFontBold22 = Font.font(customFont.getName(), FontWeight.BOLD, 22);
        
        theme.setFont(poppinsFontBold12);
        rebours.setFont(poppinsFontBold22);
        questions.setFont(poppinsFont12);
        nombreQuestion.setFont(poppinsFontBold14);
        intituleQuestion.setFont(poppinsFontBold16);
    }
}
