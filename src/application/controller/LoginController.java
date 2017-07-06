package application.controller;




import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;

import application.db.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private Label nameUserLab;

    @FXML
    private Label passwordUserLab;

    @FXML
    private PasswordField pasField;

    @FXML
    private TextField logTextField;

    @FXML
    private Button logButton;

    @FXML
    private Label statLab;
    
    
    public DataBaseConnection  db;
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
	

    @FXML
    public void OnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
    	
    	
    
    	
		String login = logTextField.getText();
		String haslo = pasField.getText();
		
		
		
     	
     
    		if(login.equals("admin") && haslo.equals("*haslo*")){
    			statLab.setText("Udalo Ci sie zalogowaæ!");
         		((Node) event.getSource()).getScene().getWindow().hide();
         		try {
        			
         		Stage stg2 = new Stage();
    			Parent root = FXMLLoader.load(getClass().getResource("/application/view/PanelZarzadzaniaUzytkownikami.fxml"));
    			Scene sce = new Scene(root,600,400);		
    			stg2.setScene(sce);
    			stg2.setResizable(false);
    			stg2.show();	
         		} catch(Exception e) {
        			e.printStackTrace();
        		}
         		
         	}
         		else{
         			
         		statLab.setText("Nie udalo Ci sie zalogowaæ!");
         		}
         		
         	
         
         
     	
    
    	
     	
    }







	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
    	
	db = new DataBaseConnection();
    	
    	
    }
    
    
}
   
    
   	
    

