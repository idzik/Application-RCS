package controll;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartApplicationControll extends FieldOfViewApplication {

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
