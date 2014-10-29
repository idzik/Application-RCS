package application;
	
import java.io.IOException;

import conectionDb.ConectionSql2o;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class StartApplications extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.setPrimaryStage(primaryStage);
		primaryStage.setTitle("Application suport sale for RCS Systemy Komputerowe");
		try {
			FXMLLoader loader = new FXMLLoader(StartApplications.class.getResource("/view/ViewRootApplication.fxml"));
			rootLayout = (BorderPane)loader.load();
			Scene scene = new Scene(rootLayout);
			scene.getStylesheets().add(getClass().getResource("/graphicDesign/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ConectionSql2o conectionSql2o = new ConectionSql2o();
		conectionSql2o.setConectionDataBase();
		showStartApplications();
		
	}
	
	public void showStartApplications(){
		
		try {
			FXMLLoader loader = new FXMLLoader(StartApplications.class.getResource("/view/ViewStartApplications.fxml"));
			AnchorPane startApplications = (AnchorPane)loader.load();
			rootLayout.setCenter(startApplications);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
