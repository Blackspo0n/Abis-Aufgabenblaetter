package Main;
import Entities.Fahrzeug;
import Factory.AbstractFactory;
import Factory.FactoryCreator;

public class Main {
	public static void main(String[] args) {
				// Zum verdeutlichen Variablen explizit deklariert
		AbstractFactory factory;
		Fahrzeug fahrzeug;
		
		factory = FactoryCreator.getInstance().createfactory("Auto");
		fahrzeug = factory.create(new String[]{"Silber", "VW Passat", "106"});
		
		fahrzeug.beschreibung();
		fahrzeug.beschleunigen();
		fahrzeug.hupe();
		fahrzeug.bremsen();
		
		factory = FactoryCreator.getInstance().createfactory("Fahrrad");
		fahrzeug = factory.create(new String[]{"Grün","27", "Scheibenbremsen"});
		
		fahrzeug.beschreibung();
		fahrzeug.beschleunigen();
		fahrzeug.hupe();
		fahrzeug.bremsen();
		
	}
}