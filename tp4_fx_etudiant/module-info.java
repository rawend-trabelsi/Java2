module tp4fx {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
