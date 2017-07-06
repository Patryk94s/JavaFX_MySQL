package application.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import application.Klienci;
import application.Alert;
import application.db.DataBaseConnection;

import application.controller.KlienciController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TabController implements Initializable {
	
	
    
	

	@FXML
	private TextField IdTextField;
	
	
    
    @FXML
    private TextField imieTextField;

    @FXML
    private TextField nazwiskoTextField;

    @FXML
    private TextField ulTextField;

    @FXML
    private TextField kodpoczTextField;

    @FXML
    private TextField miejscTextField;

    @FXML
    private TextField telTextField;

    @FXML
    private Button dodaj_tabela_button;
    
    @FXML
    private Label lab_blad;

    
    @FXML
    private Button ok_zm_button;
    
    @FXML
    private Button cofnij_button;

        
    public DataBaseConnection  db;
    public KlienciController kc;
    
    
   
    public Alert al;
    
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    
	
    
    
    
    @FXML
    void CofnijOnAction(ActionEvent event) {
    	
    	try {
			
     		Stage stg2 = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/PanelZarzadzaniaUzytkownikami.fxml"));
			Scene sce = new Scene(root,600,400);		
			stg2.setScene(sce);
			stg2.setResizable(false);
			stg2.show();	
			
			((Node) event.getSource()).getScene().getWindow().hide();
			
     		} catch(Exception e) {
    			e.printStackTrace();
    		}
     		
    	

    }

    
    
    @FXML
    void OkZMOnAction(ActionEvent event) throws ClassNotFoundException {

    	
    	
    	
    	String wynik =	IdTextField.getText();  
		int id=Integer.parseInt(wynik);   
	 
	 	Klienci kl = DataBaseConnection.getKlienciId(id);
			
		 imieTextField.setText(kl.getImie());
		 nazwiskoTextField.setText(kl.getNazwisko());
		 ulTextField.setText(kl.getUlica());
		 kodpoczTextField.setText(kl.getKod_poczt());
		 miejscTextField.setText(kl.getMiejsc());
		 telTextField.setText(kl.getTel_kom());
		 
          
    	

}

    
    
    
    
    
    @FXML
    void OkOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
    		
    	
    	
    		String wynik =	IdTextField.getText();  
    		int id=Integer.parseInt(wynik);   
    	 
    	 	Klienci kl = DataBaseConnection.getKlienciId(id);
    	
				
			 imieTextField.setText(kl.getImie());
			 nazwiskoTextField.setText(kl.getNazwisko());
			 ulTextField.setText(kl.getUlica());
			 kodpoczTextField.setText(kl.getKod_poczt());
			 miejscTextField.setText(kl.getMiejsc());
			 telTextField.setText(kl.getTel_kom());
			 
    	
    	

    }
    
    
    
    
    
  
	

    
    
    
    
    
	
	@FXML
    void DodajTabOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
    	
		SprawdzPolaTekst();
		
		if(SprawdzPolaTekst()){
		
		String imie_k = imieTextField.getText();
    	String nazwisko_k = nazwiskoTextField.getText();
    	String ulica_k = ulTextField.getText();
    	String kod_pocz_k = kodpoczTextField.getText();
    	String miejsc_k = miejscTextField.getText();
    	String tel_kom_k = telTextField.getText();
		
	
		Klienci kc = new Klienci();  
		
		
    	kc.setImie(imie_k);
    	kc.setNazwisko(nazwisko_k);
    	kc.setUlica(ulica_k);
    	kc.setKod_poczt(kod_pocz_k);
    	kc.setMiejsc(miejsc_k);
    	kc.setTel_kom(tel_kom_k);
		
		
		 int status = DataBaseConnection.dodanieKl(kc);
		 
		 
		 
		 
		 
		 
		 if(status > 0){
				
				al.info("Dodanie u¿ytkownika zakoñczy³o sie sukcesem!");
				ClearTextField();
				
				
				
				
				
			}
		 
		 else{
				
				
				al.info("Dodanie u¿ytkownika nie powiod³o siê!");
				
			}
			
			
		
		}
		
		
		
    	
       
        
    }
    
	
	
	
	
    
	

	@FXML
    void UsunTabOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {
    
		
		SprawdzPolaTekst2();
    	if(SprawdzPolaTekst2()){

		
		
		String wynik = IdTextField.getText();  
	    int id=Integer.parseInt(wynik);    
 
	     
	    int status= DataBaseConnection.usunieciKl(id) ;
		
		
		if(status > 0){
			
			al.info("Usuniêcie u¿ytkownika zakoñczy³o sie sukcesem!");
			ClearTextField();
			
			
			
			
		}else{
			
			
			al.info("Usuniêcie u¿ytkownika nie powiod³o siê!");
			
		}
		
    	}
		
		
    }

  
    
  
    
    
   
    
    
    
    
    
    
   
    
    @FXML
    void ZmodTabOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
    	
    	

    	SprawdzPolaTekst2();
    	if(SprawdzPolaTekst2()){
			
		

    	String wynik = IdTextField.getText();  
	    int id=Integer.parseInt(wynik);    
	    
	    String imie_k = imieTextField.getText();
    	String nazwisko_k = nazwiskoTextField.getText();
    	String ulica_k = ulTextField.getText();
    	String kod_pocz_k = kodpoczTextField.getText();
    	String miejsc_k = miejscTextField.getText();
    	String tel_kom_k = telTextField.getText();

        
        Klienci kc = new Klienci();  
        
       
    	kc.setImie(imie_k);
    	kc.setNazwisko(nazwisko_k);
    	kc.setUlica(ulica_k);
    	kc.setKod_poczt(kod_pocz_k);
    	kc.setMiejsc(miejsc_k);
    	kc.setTel_kom(tel_kom_k);
    	kc.setId(id);
    	
    	



        int status=DataBaseConnection.zmianaDanychKl(kc);
        
        if(status>0){  
        	
        	al.info("Dane zosta³y zmodyfikowane!");
			ClearTextField();
			
			  
        	
        	// System.out.println(" Record saved successfully! ");
        }else{ 
        	
    		 
        	al.info("Dane nie zosta³y zmodyfikowane!");
        	
        }	
	     	
		
    	}
		

    }
    
    
    
    public void ClearTextField(){
    	imieTextField.clear();
    	nazwiskoTextField.clear();
    	ulTextField.clear();
    	kodpoczTextField.clear();
    	miejscTextField.clear();
    	telTextField.clear();
    	
    	
    	
    	
    }
    
    
    public boolean SprawdzPolaTekst(){
    	
    
    	
    	boolean poleImiePuste = BladPol.polePuste(imieTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
    	boolean poleNazwiskoPuste = BladPol.polePuste(nazwiskoTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
    	boolean poleUlPuste = BladPol.polePuste(ulTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
    	boolean poleKodPocz = BladPol.polePuste(kodpoczTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
    	boolean poleMiejscPuste = BladPol.polePuste(miejscTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
    	boolean poleTelKomPuste = BladPol.polePuste(telTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
		
    	return (poleImiePuste && poleNazwiskoPuste && poleUlPuste && poleKodPocz && poleMiejscPuste && poleTelKomPuste);
    	
    	
    }

 public boolean SprawdzPolaTekst2(){
    	
    
    	boolean poleIdPuste = BladPol.polePuste(IdTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
    	boolean poleImiePuste = BladPol.polePuste(imieTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
    	boolean poleNazwiskoPuste = BladPol.polePuste(nazwiskoTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
    	boolean poleUlPuste = BladPol.polePuste(ulTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
    	boolean poleKodPocz = BladPol.polePuste(kodpoczTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
    	boolean poleMiejscPuste = BladPol.polePuste(miejscTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
    	boolean poleTelKomPuste = BladPol.polePuste(telTextField, lab_blad, "WYPE£NIJ WSZYSTKIE POLA!");
		
    	return (poleIdPuste && poleImiePuste && poleNazwiskoPuste && poleUlPuste && poleKodPocz && poleMiejscPuste && poleTelKomPuste);
    	
    	
    }



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}




	
    
	
}
