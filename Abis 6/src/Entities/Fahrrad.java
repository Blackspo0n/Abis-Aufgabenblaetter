package Entities;

public class Fahrrad implements Fahrzeug {
	private String Farbe;
	private String anzahlDerGaenge;
	private String BremsenArt;
	
	public Fahrrad(String farbe, String anzahlDerGaenge, String bremsenArt) {
		setFarbe(farbe);
		setAnzahlDerGaenge(anzahlDerGaenge);
		setBremsenArt(bremsenArt);
	}
	
	public String getFarbe() {
		return Farbe;
	}

	public void setFarbe(String farbe) {
		Farbe = farbe;
	}

	public String getAnzahlDerGaenge() {
		return anzahlDerGaenge;
	}

	public void setAnzahlDerGaenge(String anzahlDerGaenge) {
		this.anzahlDerGaenge = anzahlDerGaenge;
	}

	public String getBremsenArt() {
		return BremsenArt;
	}

	public void setBremsenArt(String bremsenArt) {
		BremsenArt = bremsenArt;
	}

	@Override
	public void bremsen() {
		System.out.println("[Fahrrad] Der Radfahrer bremst!");
	}

	@Override
	public void beschleunigen() {
		System.out.println("[Fahrrad] Beschleunigen. Immer Flotter und immer weiter, so der Radfahrer heiter!");
	}

	@Override
	public void beschreibung() {
		System.out.println("[Fahrrad] Farbe = " + getFarbe() + ", BremsenArt = " + getBremsenArt() + ", Anzahl der Gänge = " + getAnzahlDerGaenge());
	}

	@Override
	public void hupe() {
		System.out.println("[Fahrrad] Ringring");	
	}
}
