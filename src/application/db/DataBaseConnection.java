package application.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;


import application.Klienci;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



public class DataBaseConnection {

	
	static Connection conn = null;
	
	public static Connection ConnectDB() throws ClassNotFoundException, SQLException {
		    
            
		 Class.forName("com.mysql.jdbc.Driver");
         conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sklep_klienci","root","*Munios23*"); 
         
        return conn;
          
			
		}
	
	
	
	public static int dodanieKl(Klienci kc) throws ClassNotFoundException{
		
		int rs = 0;
		
		try {
			String sql = "INSERT INTO klienci (imie_k, nazwisko_k, ulica_k, kod_pocz_k, miejsc_k, tel_kom_k) VALUES (?,?,?,?,?,?)";
	    	
			Connection conn = DataBaseConnection.ConnectDB();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1, kc.getImie() );
			ps.setString(2, kc.getNazwisko());
			ps.setString(3, kc.getUlica());
			ps.setString(4, kc.getKod_poczt());
			ps.setString(5, kc.getMiejsc());
			ps.setString(6, kc.getTel_kom());
			
			
			rs = ps.executeUpdate();
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	

	
	
public static int zmianaDanychKl(Klienci kc) throws ClassNotFoundException{
		
		int rs = 0;
		
		try {
			String sql = "UPDATE klienci SET imie_k=  ?, nazwisko_k = ?, ulica_k = ?, kod_pocz_k = ? , miejsc_k = ?, tel_kom_k = ? WHERE id_k = ?";
			
			Connection conn = DataBaseConnection.ConnectDB();
			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			
			ps.setString(1, kc.getImie() );
			ps.setString(2, kc.getNazwisko());
			ps.setString(3, kc.getUlica());
			ps.setString(4, kc.getKod_poczt());
			ps.setString(5, kc.getMiejsc());
			ps.setString(6, kc.getTel_kom());
			ps.setInt(7, kc.getId());
			
			rs = ps.executeUpdate();
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	
	

	
	
	
public static Klienci getKlienciId(int id) throws ClassNotFoundException {
		
		Klienci kl = new Klienci();
		
		try {
			String sql = "SELECT * FROM klienci WHERE id_k = ?";
			Connection conn = DataBaseConnection.ConnectDB();
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				kl.setId(resultSet.getInt(1));
				kl.setImie(resultSet.getString(2));
				kl.setNazwisko(resultSet.getString(3));
				kl.setUlica(resultSet.getString(4));
				kl.setKod_poczt(resultSet.getString(5));
				kl.setMiejsc(resultSet.getString(6));
				kl.setTel_kom(resultSet.getString(7));		
				
			}

			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kl;
		
	}


	
	
	public static int usunieciKl(int id){
		
		int rs = 0;
		
		try {
			String sql = "DELETE FROM klienci WHERE id_k = ? ";
			Connection conn = DataBaseConnection.ConnectDB();
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			 
			preparedStatement.setInt(1, id);
		
			
			rs = preparedStatement.executeUpdate();
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	
	

	

		
	
	
	
	
	
	
	
	
	
	
}
