package application;


public class Klienci {
	
	private int id;
	private String imie;
	private String nazwisko;
	private String ulica;
	private String kod_poczt;
	private String miejsc;
	private String tel_kom;
	
	
	
	public Klienci(int id, String imie, String nazwisko, String ulica, String kod_poczt, String miejsc,
			String tel_kom) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.ulica = ulica;
		this.kod_poczt = kod_poczt;
		this.miejsc = miejsc;
		this.tel_kom = tel_kom;
	}



	public Klienci(int id){
		
		this.id = id;
		
		
	}



	public Klienci() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getImie() {
		return imie;
	}



	public void setImie(String imie) {
		this.imie = imie;
	}



	public String getNazwisko() {
		return nazwisko;
	}



	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}



	public String getUlica() {
		return ulica;
	}



	public void setUlica(String ulica) {
		this.ulica = ulica;
	}



	public String getKod_poczt() {
		return kod_poczt;
	}



	public void setKod_poczt(String kod_poczt) {
		this.kod_poczt = kod_poczt;
	}



	public String getMiejsc() {
		return miejsc;
	}



	public void setMiejsc(String miejsc) {
		this.miejsc = miejsc;
	}



	public String getTel_kom() {
		return tel_kom;
	}



	public void setTel_kom(String tel_kom) {
		this.tel_kom = tel_kom;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
