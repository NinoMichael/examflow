package com.examflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.examflow.models.Examen;
import com.examflow.models.Qcm;
import com.examflow.utils.DatabaseConnection;

public class QcmDao {
	public static Qcm createQuestion(Qcm qcm) {
        String query = "INSERT INTO Qcm (id, idExamen, question, reboursSec) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {

        	preparedStatement.setObject(1, qcm.getIdQcm());
        	preparedStatement.setObject(2, qcm.getIdExamen());
            preparedStatement.setString(3, qcm.getQuestion());
            preparedStatement.setObject(4, qcm.getReboursSec());
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
            	int idQcm = resultSet.getInt("id");
            	Examen idExamen = (Examen) resultSet.getObject("idExamen");
            	String question = resultSet.getString("question");
            	int reboursSec = resultSet.getInt("reboursSec");
            	return new Qcm(idQcm, idExamen, question, reboursSec);
            } else {
            	System.out.println("Echec de la connexion");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return qcm;
    }
}
