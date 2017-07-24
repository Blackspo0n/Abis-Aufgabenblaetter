package framework;

public abstract class AbstractDAO<T> {

	static AbstractDAO instance;

	abstract AbstractDAO getInstance();

	abstract void findStatement();

	abstract void deleteStatement();

	abstract void getKey();

	abstract void getConnection();

	abstract void doLoad();

	public void cleanUp() {

	}

	public void abstractRead() {

	}

	public void load() {

	}

	public void update() {

	}

	abstract void doUpdate();

	public void insert() {

	}

	abstract void doInsert();

	public void delete() {

	}

}
