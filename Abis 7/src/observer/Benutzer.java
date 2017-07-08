package observer;

import java.util.*;

public class Benutzer implements Observer {
	
	public Integer KundenNummer = 0;
	public String Vorname = "";
	public String Nachname = "";
	public List<Auktion> beobachtungsListe = new ArrayList<>();
	public List<Auktion> aktiveAuktionen = new ArrayList<>();
	
	public Benutzer(Integer kundenNummer, String vorname, String nachname) {
		KundenNummer = kundenNummer;
		Vorname = vorname;
		Nachname = nachname;
	}

	public void addToAktiveAuktionen(Auktion auk) {
		aktiveAuktionen.add(auk);
	}
	
	public void addTobeobachtungsListe(Auktion auk) {
		auk.addObserver(this);
		
		beobachtungsListe.add(auk);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		List<Gebot> gebote = (List<Gebot>)arg1;
		
		System.out.println("[" + Nachname + "] Gebot für " +((Auktion)arg0).ArikelName);
		System.out.println("[" + Nachname + "] Gebot von " + gebote.get(gebote.size()-1).benutzer.Nachname);
		System.out.println("[" + Nachname + "] Gebotener Preis " + gebote.get(gebote.size()-1).preis);
		System.out.println();
		
	}	
}