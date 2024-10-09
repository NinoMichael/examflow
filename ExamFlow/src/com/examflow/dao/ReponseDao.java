package com.examflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            preparedStatement.setObject(4, reponse.getPointUnitaire());
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
            	int idReponse = resultSet.getInt("id");
            	Qcm idQcm = (Qcm) resultSet.getObject("idQcm");
            	String intitule = resultSet.getString("intitule");
            	boolean estBonne = resultSet.getBoolean("est_bonne");
            	double pointUnitaire = resultSet.getDouble("point_unitaire");
            	return new Reponse(idReponse, idQcm, intitule, estBonne, pointUnitaire);
            } else {
            	System.out.println("Echec de la connexion");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return reponse;
    }
}
