package com.examflow2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;

import com.examflow.models.*;
import com.examflow.dao.*;

public class CreateExam2Controller {
	@FXML
	public static Qcm staticQuestion;

    @FXML
    public Label prepareExam, prepareExam1, configure;

    @FXML
    public TextField inputQuestion, inputConfigure;

    @FXML
    public Button btnNext;
    
    @FXML
    public Label configureRebours;

    public HomeController homeController;

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

    @FXML
    public void initialize() {
        adjustLayout();

        btnNext.setOnAction(event -> {
            String input = inputQuestion.getText();
            int inputRebours = Integer.valueOf(inputConfigure.getText());

            List<Qcm> qcmList = parseInput(input);

            for (Qcm qcm : qcmList) {
                qcm.setReboursSec(inputRebours);
                QcmDao.createQuestion(qcm, CreateExamController.staticExam);

                Qcm qcmInsere = QcmDao.getLastQcm(CreateExamController.staticExam);

                List<Reponse> reponseList = parseReponses(input, qcm);
                for (Reponse reponse : reponseList) {
                    reponse.setQcm(qcmInsere);
                    ReponseDao.createReponse(reponse);
                    System.out.println("Réponse : " + reponse.getIntitule() + " - Est bonne : " + reponse.isEstBonne());
                }
            }

            List<Qcm> qcmList2 = QcmDao.getAllQcm(CreateExamController.staticExam);
            for (Qcm qcm2 : qcmList2) {
                qcm2.setPointUnitaire(20.0 / qcmList2.size());
                QcmDao.updateQcm(qcm2);
            }

            homeController.dashboardInterface();
        });
    }

    public void adjustLayout() {
        Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/examflow2/resources/fonts/Poppins-Regular.ttf"), 20);
        Font poppinsFont12 = Font.font(customFont.getName(), 12);
        Font poppinsBoldFont12 = Font.font(customFont.getName(), FontWeight.BOLD, 12);
        Font poppinsFont = Font.font(customFont.getName(), FontWeight.BOLD, 18);

        inputQuestion.setFont(poppinsFont12);
        prepareExam.setFont(poppinsFont12);
        prepareExam1.setFont(poppinsFont12);
        configure.setFont(poppinsFont);
    }

    public List<Qcm> parseInput(String input) {
        List<Qcm> qcmList = new ArrayList<>();

        String[] questionsAndAnswers = input.split(";");

        for (String qAndA : questionsAndAnswers) {
            qAndA = qAndA.trim();
            if (!qAndA.isEmpty()) {
                String question = qAndA.substring(qAndA.indexOf("\"") + 1, qAndA.lastIndexOf("\""));

                Qcm qcm = new Qcm();
                qcm.setQuestion(question);

                qcmList.add(qcm);
            }
        }

        return qcmList;
    }

    public List<Reponse> parseReponses(String input, Qcm qcm) {
        List<Reponse> reponseList = new ArrayList<>();

        String questionInput = qcm.getQuestion();
        String[] questionsAndAnswers = input.split(";");

        for (String qAndA : questionsAndAnswers) {
            qAndA = qAndA.trim();
            if (qAndA.contains(questionInput)) {
                String answersPart = qAndA.substring(qAndA.lastIndexOf("\"") + 1).trim();

                String[] answersArray = answersPart.split(",");
                for (String answer : answersArray) {
                    answer = answer.trim();
                    Reponse reponse = new Reponse();

                    if (answer.startsWith("+")) {
                        reponse.setIntitule(answer.substring(1));
                        reponse.setEstBonne(true);
                    } else if (answer.startsWith("-")) {
                        reponse.setIntitule(answer.substring(1));
                        reponse.setEstBonne(false);
                    }

                    reponse.setQcm(qcm);
                    reponseList.add(reponse);
                }
                break;
            }
        }

        return reponseList;
    }
}