package observer;

import java.time.LocalDateTime;
import java.util.*;

public class Auktion extends Observable {
	public Integer AuktionsNr = 0;
	public String ArikelName = "";
	public String Beschreibung = "";
	
	public List<Gebot> gebote = new ArrayList<>();
	public LocalDateTime AuktionsEnde;
	
	public Auktion(Integer auktionsNr, String arikelName, String beschreibung, LocalDateTime auktionsEnde) {
		AuktionsNr = auktionsNr;
		ArikelName = arikelName;
		Beschreibung = beschreibung;
		AuktionsEnde = auktionsEnde;
		
		setChanged();
	}
	
	public void setzeGebot(Benutzer user, float preisInEuro) {
		if(AuktionsEnde.isAfter(LocalDateTime.now())) {
			if(gebote.isEmpty() || (preisInEuro > gebote.get(gebote.size()-1).preis)) {
				Gebot gebot = new Gebot();
				gebot.preis = preisInEuro;
				gebot.benutzer = user;
				
				gebote.add(gebot);
				user.addToAktiveAuktionen(this);
				
				setChanged();
				notifyObservers(gebote);
			}
		}
	}
}