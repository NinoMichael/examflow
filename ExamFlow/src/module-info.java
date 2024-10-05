module ExamFlow {
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires java.sql;
	requires com.gluonhq.charm.glisten;
	requires com.gluonhq.attach.util;
	requires java.desktop;
	requires javafx.base;

	exports com.examflow to javafx.graphics;
	opens com.examflow to javafx.fxml;
    opens com.examflow.controllers to javafx.fxml;
	exports com.examflow.models;
	exports com.examflow.dao;
}