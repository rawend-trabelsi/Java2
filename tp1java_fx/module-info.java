module java_fixtuto {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
