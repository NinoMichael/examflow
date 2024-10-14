package com.examflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examflow.models.Examen;
import com.examflow.models.Qcm;
import com.examflow.models.Reponse;
import com.examflow.utils.DatabaseConnection;

public class ReponseDao {
	public static Reponse createReponse(Reponse reponse) {
        String query = "INSERT INTO Qcm (id, id_qcm, intitule, est_bonne, point_unitaire) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {

        	preparedStatement.setObject(1, reponse.getIdReponse());
        	preparedStatement.setObject(2, reponse.getIdQcm());
            preparedStatement.setString(3, reponse.getIntitule());
            preparedStatement.setObject(4, reponse.isEstBonne());
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
            	int idReponse = resultSet.getInt("id");
            	Qcm idQcm = (Qcm) resultSet.getObject("idQcm");
            	String intitule = resultSet.getString("intitule");
            	boolean estBonne = resultSet.getBoolean("est_bonne");
            	double pointUnitaire = resultSet.getDouble("point_unitaire");
            	return new Reponse(idReponse, idQcm, intitule, estBonne);
            } else {
            	System.out.println("Echec de la connexion");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return reponse;
    }
	
	public static List<Reponse> getAllReponse(Qcm qcm) {
		String query = "SELECT * FROM reponse where id_qcm = ?";
		
		List<Reponse> reponseList = new ArrayList<>();
		try (Connection connection = DatabaseConnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				 preparedStatement.setInt(1, qcm.getIdQcm());
			
				 ResultSet resultSet = preparedStatement.executeQuery();
				 
				 while (resultSet.next()) {
					 int idReponse = resultSet.getInt("id");
					 
					 Qcm question = qcm;
					 
					 String intitule = resultSet.getString("intitule");
					 boolean statutReponse = resultSet.getBoolean("est_bonne");
					 
					 Reponse reponse = new Reponse(idReponse, question, intitule, statutReponse);
					 reponseList.add(reponse);
					 
					  
				 }
			} catch (SQLException e) {
	            e.printStackTrace();
	        }
			 return reponseList;
	}
}
