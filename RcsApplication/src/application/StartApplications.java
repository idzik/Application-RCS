package application;
	
import java.io.IOException;

import calendarPicker.AddCalendar;
import conectionDb.ConectionSql2o;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class StartApplications extends Application {
	
	@FXML
	protected Button btnProduct;
	@FXML
	protected Button btnAuction;
	@FXML
	protected Button test;
	@FXML
	protected HBox hbSqlProduct;
	@FXML
	protected HBox hbSelectAuctionFilter;
	@FXML
	protected TextField txtDateFilterFrom;
	@FXML
	protected TextField txtDateFilterTo;
	@FXML
	protected HBox hbDateFilterFrom;
	@FXML
	protected HBox hbDateFilterTo;
	
	static boolean inAuction = false;
	
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
	
	public void actionButtonProduct(){
		btnProduct.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				hbSqlProduct.setVisible(true);
				hbSelectAuctionFilter.setVisible(false);
				
			}
		});
	}
	
	public void actionButtonAuction(){
		
		btnAuction.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(!inAuction){
				AddCalendar calendar = new AddCalendar();
				calendar.addCalendar(txtDateFilterFrom, hbDateFilterFrom);
				calendar.addCalendar(txtDateFilterTo, hbDateFilterTo);
				}
				inAuction = true;
				hbSelectAuctionFilter.setVisible(true);
				hbSqlProduct.setVisible(false);
				
			}
		});
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
