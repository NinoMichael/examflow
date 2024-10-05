module ExamFlow2 {
	requires ExamFlow;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires java.sql;
	requires com.gluonhq.charm.glisten;
	requires com.gluonhq.attach.util;
	requires java.desktop;
	requires javafx.base;

	opens com.examflow2 to javafx.fxml;
    opens com.examflow2.controllers to javafx.fxml;
	exports com.examflow2;
	
}