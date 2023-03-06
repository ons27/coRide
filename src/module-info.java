module project {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;
	requires org.json;
	
	
	opens application to sample.Datamodel,javafx.base,javafx.graphics, javafx.fxml;
    opens entity to sample.Datamodel,javafx.base,javafx.graphics, javafx.fxml;
    opens services to sample.Datamodel,javafx.base,javafx.graphics, javafx.fxml;


}
