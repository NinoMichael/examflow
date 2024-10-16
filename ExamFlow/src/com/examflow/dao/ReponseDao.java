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
	public static void createReponse(Reponse reponse) {
        String query = "INSERT INTO reponse (id_qcm, intitule, est_bonne) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {

        	preparedStatement.setInt(1, reponse.getQcm().getIdQcm());
            preparedStatement.setString(2, reponse.getIntitule());
            preparedStatement.setBoolean(3, reponse.isEstBonne());
            preparedStatement.executeUpdate();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
