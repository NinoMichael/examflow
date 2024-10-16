package com.examflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.examflow.models.Enseignant;
import com.examflow.models.Examen;
import com.examflow.models.Qcm;
import com.examflow.utils.DatabaseConnection;

public class ExamenDao {
	public static Examen createExamen(Examen examen, Enseignant enseignant) {
        String query = "INSERT INTO examen (code, theme, debut, fin, instruction, id_enseignant) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {
        	
        	 String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{};:'\",.<>/?";
             Random random = new Random();
             StringBuilder codeAlea = new StringBuilder(5);

             for (int i = 0; i < 5; i++) {
                 codeAlea.append(characters.charAt(random.nextInt(characters.length())));
             }

        	String code = codeAlea.toString();
        	
			preparedStatement.setString(1, code);
            preparedStatement.setString(2, examen.getTheme());
            preparedStatement.setObject(3, examen.getDebut());
            preparedStatement.setObject(4, examen.getFin());
            preparedStatement.setString(5, examen.getInstruction());
            
            examen.setEnseignant(enseignant);
            preparedStatement.setInt(6, examen.getEnseignant().getId());
            int rowsAffected = preparedStatement.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Examen créé avec succès !");
            
            } else {
            	System.out.println("Echec de la connexion");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return examen;
    }
	
	public static List<Examen> getAllExamen() {
		String query = "SELECT * FROM examen";
		
		List<Examen> examenList = new ArrayList<>();
		try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			 ResultSet resultSet = preparedStatement.executeQuery();
			 
			 while (resultSet.next()) {
				 int idExamen = resultSet.getInt("id");
				 String code = resultSet.getString("code");
				 String theme = resultSet.getString("theme");
				 LocalDateTime dateDebut = (LocalDateTime) resultSet.getObject("debut");
				 LocalDateTime dateFin = (LocalDateTime) resultSet.getObject("fin");
				 String instruction = resultSet.getString("instruction");
				 
				 int enseignantId = resultSet.getInt("id_enseignant");
				 Enseignant enseignant = EnseignantDao.getEnseignantById(enseignantId);
				 
				 Examen exam = new Examen (idExamen, code, theme, dateDebut, dateFin, instruction, enseignant);
				 
				 examenList.add(exam);
				  
			 }
		} catch (SQLException e) {
            e.printStackTrace();
        }
		 return examenList;
		}
	
	public static Examen getLastExamen() {
		String query = "SELECT * FROM examen ORDER BY id DESC LIMIT 1";
		 
	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {    
	        
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                 int idExamen = resultSet.getInt("id");
	                 String code = resultSet.getString("code");
	                 String theme = resultSet.getString("theme");
	                 LocalDateTime debut = (LocalDateTime) resultSet.getObject("debut");
	                 LocalDateTime fin = (LocalDateTime) resultSet.getObject("fin");
	                 String instruction = resultSet.getString("instruction");
	                 
	                 Enseignant enseignant = new Enseignant();
	                 int idEnseignant = resultSet.getInt("id_enseignant");
	                 enseignant.setId(idEnseignant);
	                 
	                 Examen exam = new Examen(idExamen, code, theme, debut, fin, instruction, enseignant);
	                 return exam;
	            }
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	    
	}
		
}
