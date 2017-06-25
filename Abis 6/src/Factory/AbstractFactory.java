package Factory;
import Entities.Fahrzeug;

public abstract class AbstractFactory {
	public abstract Fahrzeug create(String[] FactoryParameters);
}
