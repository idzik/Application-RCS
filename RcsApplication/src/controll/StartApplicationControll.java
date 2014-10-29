package controll;

import calendarPicker.AddCalendar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartApplicationControll extends FieldOfViewApplication {

	static boolean inAuction = false;
	
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
	
	public void actionButtonTest(){
		test.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Akcja dla aukcji");
				
			}
		});
	}
}
