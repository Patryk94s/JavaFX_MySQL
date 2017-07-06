package application.controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BladPol {

	
	
	public static boolean poleNiePuste(TextField tf){
		
		boolean bool = false;
		
		if(tf.getText().length() != 0 ){
			
			bool = true;
			
			
		}
			
		return bool;	
		
		
	}
	
	
	public static boolean polePuste(TextField tf, Label lb, String zlaWiad){
		
		boolean bool = true;
		String wiad = null;
		
		if(!poleNiePuste(tf)){
			
			bool = false;
			wiad = zlaWiad;
			
		}
	
		lb.setText(wiad);
		return bool;
		
		
		
	}


	
	
	
}
