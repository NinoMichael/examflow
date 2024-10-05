package com.examflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.examflow.models.Etudiant;
import com.examflow.utils.DatabaseConnection;

public class EtudiantDao {
	public static void createEtudiant(Etudiant etudiant) {
        String query = "INSERT INTO etudiant (nom, email, mdp) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {

            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getEmail());
            preparedStatement.setString(3, etudiant.getMdp());
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static Etudiant authEtudiant(String email, String mdp) {
		 String query = "SELECT * FROM etudiant where email = ? and mdp = ?";
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        	
	        	preparedStatement.setString(1, email);
	        	preparedStatement.setString(2, mdp);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	            	int idEtudiant = resultSet.getInt("id");
	            	String nom = resultSet.getString("nom");
	            	String mail = resultSet.getString("email");
	            	String password = resultSet.getString("mdp");
	            	LocalDateTime dateRegister = (LocalDateTime) resultSet.getObject("date_inscription");
	            	return new Etudiant(idEtudiant, nom, mail, password, dateRegister);
	            } else {
	            	System.out.println("Echec de la connexion");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return null;
	}
}
