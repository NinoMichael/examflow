package com.examflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.examflow.models.Enseignant;
import com.examflow.models.Examen;
import com.examflow.models.Qcm;
import com.examflow.utils.DatabaseConnection;

public class QcmDao {
	public static Qcm createQuestion(Qcm qcm, Examen exam) {
        String query = "INSERT INTO Qcm (id_examen, question, rebours_sec, point_unitaire) VALUES (?, ?, null, null)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {

        	preparedStatement.setObject(1, exam.getId());
            preparedStatement.setString(2, qcm.getQuestion());
            preparedStatement.executeUpdate();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return qcm;
    }
	
	public static List<Qcm> getAllQcm(Examen examen) {
		String query = "SELECT * FROM qcm where id_examen = ?";
		
		List<Qcm> qcmList = new ArrayList<>();
		try (Connection connection = DatabaseConnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				 preparedStatement.setInt(1, examen.getId());
			
				 ResultSet resultSet = preparedStatement.executeQuery();
				 
				 while (resultSet.next()) {
					 int idQcm = resultSet.getInt("id");
					 Examen exam = examen;
					 String question = resultSet.getString("question");
					 int reboursSec = resultSet.getInt("rebours_sec");
					 double pointUnitaire = resultSet.getDouble("point_unitaire");
					 
					 Qcm qcm = new Qcm(idQcm, exam, question, reboursSec, pointUnitaire);
					 qcmList.add(qcm);
					  
				 }
			} catch (SQLException e) {
	            e.printStackTrace();
	        }
			 return qcmList;
	}
	
	public static Qcm getLastQcm(Examen examen) {
		String query = "SELECT * FROM qcm where id_examen = ? ORDER BY id DESC LIMIT 1";
		 
	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        
	        preparedStatement.setInt(1, examen.getId());
	        
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                 int idQcm = resultSet.getInt("id");
	                 Examen exam = examen;
	                 
	                 Qcm qcm = new Qcm(idQcm, exam);
	                 return qcm;
	            }
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	    
	}
	
	
	public static int getTotalQuestion(Examen examen) {
	    String query = "SELECT COUNT(*) as totalQuestion FROM qcm where id_examen = ?";
	    int totalQuestions = 0;
	    
	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        
	        preparedStatement.setInt(1, examen.getId());
	        
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                totalQuestions = resultSet.getInt("totalQuestion");  
	            }
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return totalQuestions;
	}
}
