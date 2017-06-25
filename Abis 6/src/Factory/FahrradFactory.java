package Factory;

import Entities.Fahrrad;
import Entities.Fahrzeug;

public class FahrradFactory extends AbstractFactory {
	@Override
	public Fahrzeug create(String[] FactoryParameters) {
		if(FactoryParameters.length != 3) return null;
		
		return new Fahrrad(FactoryParameters[0], FactoryParameters[1], FactoryParameters[2]);
	}
}