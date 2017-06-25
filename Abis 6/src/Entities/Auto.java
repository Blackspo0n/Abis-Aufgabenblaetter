package Entities;

public class Auto implements Fahrzeug {
	private String Farbe;
	private String Marke;
	private int Leistung;
	
	public Auto(String Farbe, String Marke, int Leistung) {
		setFarbe(Farbe);
		setMarke(Marke);
		setLeistung(Leistung);
	}
	
	public String getFarbe() {
		return Farbe;
	}

	public void setFarbe(String farbe) {
		Farbe = farbe;
	}

	public String getMarke() {
		return Marke;
	}

	public void setMarke(String marke) {
		Marke = marke;
	}

	public int getLeistung() {
		return Leistung;
	}

	public void setLeistung(int leistung) {
		Leistung = leistung;
	}

	@Override
	public void bremsen() {
		System.out.println("[Auto] Die Reifen quitschen laut während des Bremsens.");
	}

	@Override
	public void beschleunigen() {
		System.out.println("[Auto] Der Fahrer gibt Vollgas");
	}

	@Override
	public void beschreibung() {
		System.out.println("[Auto] Farbe = " + getFarbe() + ", Marke = " + getMarke() + ", Leistung = " + getLeistung());
		
	}

	@Override
	public void hupe() {
		System.out.println("[Auto] Moooeep");
		
	}

}
