package application.controller;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

	




public class PanelController    {

    @FXML
    private Button dod_uzytk;

    @FXML
    private Button usun_uzytk;

    @FXML
    private Button zmod_uzytk;

    @FXML
    private Button pok_tab;

    


    
    
   
    @FXML
    void PokaztabOnAction(ActionEvent event) throws SQLException {

    	
		
    	try {
    		
    		
    		
        	Stage primaryStage = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("/application/view/Tabela_Klientow.fxml"));
    		Scene sce = new Scene(root,700,400);	
    		primaryStage.setScene(sce);
    		primaryStage.show();	
    		
    		
    		
        	}catch (Exception e){
        		
        		
        		e.printStackTrace();
        	}	
    	
    	
    	
    	
    }
   

    
    @FXML
    public void DodajOnAction(ActionEvent event) {
    	
    	((Node) event.getSource()).getScene().getWindow().hide();
    	
    	
    	
    	try {
    		
    	
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/DodajKlienta.fxml"));
		Scene sce = new Scene(root,400,500);		
		primaryStage.setScene(sce);
		primaryStage.show();	
    	}catch (Exception e){
    		
    		
    		e.printStackTrace();
    	}	
    }

   
    @FXML
    void UsunOnAction(ActionEvent event)  {

    	((Node) event.getSource()).getScene().getWindow().hide();
    	
    	
    	
    	
    	try {
    		
    	
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/UsunKlienta.fxml"));
		Scene sce = new Scene(root,400,500);		
		primaryStage.setScene(sce);
		primaryStage.show();	
    	}catch (Exception e){
    		
    		
    		e.printStackTrace();
    	}	 
    	
    	
    	
    }

    @FXML
    void ZmodOnAction(ActionEvent event) {

    	((Node) event.getSource()).getScene().getWindow().hide();
    	
    
    	
    	try {
    		
    		
        	
        	Stage primaryStage = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("/application/view/ZmianaDanychKlienta.fxml"));
    		Scene sce = new Scene(root,400,500);		
    		primaryStage.setScene(sce);
    		primaryStage.show();	
        	}catch (Exception e){
        		
        		
        		e.printStackTrace();
        	}	    	
    	
    	
    	
    }


	
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
