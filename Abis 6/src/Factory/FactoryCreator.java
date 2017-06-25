package Factory;

public class FactoryCreator {
	// Singleton Pattern
	public static FactoryCreator instance;
	
	private FactoryCreator() {
		// Leerer privater Konstruktor 
	};
	
	public static FactoryCreator getInstance() {
		if(instance == null) {
			instance = new FactoryCreator();
		}
		
		return instance;
	}
	
	public AbstractFactory createfactory(String FactoryType) {
		if(FactoryType.equals("Fahrrad")) {
			return new FahrradFactory();
		}
		
		if(FactoryType.equals("Auto")) {
			return new AutoFactory();
		}
		
		return null;
	}
}
