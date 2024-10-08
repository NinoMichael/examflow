package com.examflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.examflow.models.Enseignant;
import com.examflow.models.Examen;
import com.examflow.utils.DatabaseConnection;

public class ExamenDao {
	public static Examen createExamen(Examen examen) {
        String query = "INSERT INTO examen (code, theme, debut, fin, instruction, id_enseignant) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {

        	String code = "ABC13";
        	int idEnseignant = 1;
			preparedStatement.setString(1, code);
            preparedStatement.setString(2, examen.getTheme());
            preparedStatement.setObject(3, examen.getDebut());
            preparedStatement.setObject(4, examen.getFin());
            preparedStatement.setString(5, examen.getInstruction());
            preparedStatement.setInt(6, idEnseignant);
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
}
