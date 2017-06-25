package Factory;

import Entities.Auto;
import Entities.Fahrzeug;

public class AutoFactory extends AbstractFactory {
	@Override
	public Fahrzeug create(String[] FactoryParameters) {
		if(FactoryParameters.length != 3) return null;
			
		return new Auto(FactoryParameters[0], FactoryParameters[1], Integer.parseInt(FactoryParameters[2]));		
	}
}