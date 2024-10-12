package com.examflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.examflow.models.Enseignant;
import com.examflow.utils.DatabaseConnection;

public class EnseignantDao {
	public static void createEnseignant(Enseignant enseignant) {
        String query = "INSERT INTO enseignant(nom, email, mdp) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {

            preparedStatement.setString(1, enseignant.getNom());
            preparedStatement.setString(2, enseignant.getEmail());
            preparedStatement.setString(3, enseignant.getMdp());
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static Enseignant authEnseignant(String email, String mdp) {
		 String query = "SELECT * FROM enseignant where email = ? and mdp = ?";
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        	
	        	preparedStatement.setString(1, email);
	        	preparedStatement.setString(2, mdp);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	            	int idEnseignant = resultSet.getInt("id");
	            	String nom = resultSet.getString("nom");
	            	String mail = resultSet.getString("email");
	            	String password = resultSet.getString("mdp");
	            	LocalDateTime dateRegister = (LocalDateTime) resultSet.getObject("date_inscription");
	            	return new Enseignant(idEnseignant, nom, mail, password, dateRegister);
	            } else {
	            	System.out.println("Echec de la connexion");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return null;
	}
	
	public static Enseignant getEnseignantById(int idEnseignant) {
		String query = "SELECT  * FROM enseignant where id = ?";
		
		 try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        	preparedStatement.setInt(1, idEnseignant);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	            	int id = resultSet.getInt("id");
	            	String nom = resultSet.getString("nom");
	            	String mail = resultSet.getString("email");
	            	String password = resultSet.getString("mdp");
	            	LocalDateTime dateRegister = (LocalDateTime) resultSet.getObject("date_inscription");
	            	return new Enseignant(id, nom, mail, password, dateRegister);
	            	
	            } else {
	            	System.out.println("Echec de la connexion");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 return null;
	}
}
