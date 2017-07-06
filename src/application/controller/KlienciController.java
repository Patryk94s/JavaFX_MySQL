package application.controller;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Alert;
import application.Klienci;
import application.db.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class KlienciController implements Initializable {

	
	
	
	@FXML
    private TableView<Klienci> tab_klienci;
	
    @FXML
    private TableColumn<?, ?> Id_column;

    @FXML
    private TableColumn<?, ?> Imie_column;

    @FXML
    private TableColumn<?, ?> Naz_column;

    @FXML
    private TableColumn<?, ?> Ul_column;

    @FXML
    private TableColumn<?, ?> Kod_column;

    @FXML
    private TableColumn<?, ?> Miejsc_column;

    @FXML
    private TableColumn<?, ?> Tel_column;
    
    
    
    
    public ObservableList<Klienci>data=FXCollections.observableArrayList();
    
   
    public DataBaseConnection  db;
    public Alert al;
   
    
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    
    
   
    
    
    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {
   		db = new DataBaseConnection();
   		try {
			LoadDataFromDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		
   	}
    
    

  
    
    
    
    public void setTable(){
      	
      	Id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
      	Imie_column.setCellValueFactory(new PropertyValueFactory<>("imie"));
      	Naz_column.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
      	Ul_column.setCellValueFactory(new PropertyValueFactory<>("ulica"));
      	Kod_column.setCellValueFactory(new PropertyValueFactory<>("kod_poczt"));
      	Miejsc_column.setCellValueFactory(new PropertyValueFactory<>("miejsc"));
      	Tel_column.setCellValueFactory(new PropertyValueFactory<>("tel_kom"));
      		
      }

  
  public void LoadDataFromDB() throws SQLException{
  	
  	data.clear();
  	
		try {
			conn = db.ConnectDB();
			data = FXCollections.observableArrayList();
			ps = conn.prepareStatement("SELECT * FROM Klienci");
			rs=ps.executeQuery();
			
			  while (rs.next()){
	            	data.add(new Klienci(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
	            }
	            
			  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	
     
		setTable();
		tab_klienci.setItems(null);
		tab_klienci.setItems(data);
		
		
  	
  	
  }
  
  
  
  
  


  
  
  

  
	
	
  

  

  
    
    
    
  
    
    
    
    
    
    
    
}


