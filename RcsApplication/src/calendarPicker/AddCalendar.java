package calendarPicker;


import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class AddCalendar {

	public void addCalendar(final TextField txt , HBox hb){
		txt.setEditable(true);
		txt.clear();
		SimpleCalendar simpleCalenderr = new SimpleCalendar();
        simpleCalenderr.dateProperty().addListener(new ChangeListener<Date>() {

			@Override
			public void changed(ObservableValue<? extends Date> ov,
					Date oldDate, Date newDate) {
				txt.setText((new SimpleDateFormat("yyyy-MM-dd")).format(newDate));
				
			}
		});
		

		
		hb.getChildren().add( simpleCalenderr);
	}
}
