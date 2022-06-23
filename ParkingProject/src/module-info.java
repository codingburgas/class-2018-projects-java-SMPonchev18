module ParkingProject {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens main to javafx.graphics, javafx.fxml;
	opens models to javafx.graphics,javafx.base, javafx.fxml;
	opens controllers to javafx.graphics, javafx.fxml;
	opens views to javafx.graphics, javafx.fxml;
	opens resources to javafx.graphics, javafx.fxml;
}
