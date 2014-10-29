package windowInformationFromUser;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowErrorInformation {
	
	public static void windowShow(String komunikat){
		Stage dialogStage = new Stage();
		dialogStage.setTitle("KOMUNIKAT");
		dialogStage.setHeight(100);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.setScene(new Scene(VBoxBuilder.create().
		    children(new Text(komunikat)).
		    alignment(Pos.CENTER).padding(new Insets(5)).build()));
		dialogStage.show();
	}

}
