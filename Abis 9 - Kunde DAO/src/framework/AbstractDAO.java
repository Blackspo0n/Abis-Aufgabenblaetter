package framework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public abstract class AbstractDAO<T extends Entity> {

    private HashMap<Long, T> cache = new HashMap<Long, T>();
    public Connection connection = null;
	
    public AbstractDAO() {
		connection = Database.getConnection();
	}
	
	public abstract String getInsertStatement();
	public abstract String getUpdateStatement();
	public abstract String getDeleteStatement();
	public abstract String getFindStatement();
	public abstract T doLoad(ResultSet rs) throws SQLException;
	public abstract PreparedStatement doUpdate(T entity, PreparedStatement stmnt) throws SQLException;
	public abstract PreparedStatement doInsert(T entity, PreparedStatement stmnt) throws SQLException;
	
	public T read(Long primaryKey) throws SQLException {

        if(cache.containsKey(primaryKey)) return cache.get(primaryKey);
		        
		PreparedStatement findStatement = null;
        findStatement = connection.prepareStatement(getFindStatement());
        findStatement.setLong(1, primaryKey);
        ResultSet rs = findStatement.executeQuery();
        rs.next();
        
        T result = load(rs);
    
		cleanUp();
		
	    return result;
	}
	
	public T load(ResultSet rs) throws SQLException {
        Long primaryKey = new Long(rs.getLong(1));
        
        if(cache.containsKey(primaryKey)) return cache.get(primaryKey);
        
        T loadedobj = doLoad(rs);
        cache.put(primaryKey, loadedobj);
        
        return loadedobj;
	}
	
	public void update(T Entity) throws SQLException {
		PreparedStatement updateStatement = null;
		
        updateStatement = connection.prepareStatement(getUpdateStatement());
        updateStatement = doUpdate(Entity, updateStatement);
        updateStatement.execute();
        
        cache.put(Entity.getPrimaryKey(), Entity);
	}

	public Long insert(T Entity) throws SQLException {
		PreparedStatement insertStatement = null;
		
        insertStatement = connection.prepareStatement(getInsertStatement());
        insertStatement = doInsert(Entity, insertStatement);
        insertStatement.execute();
        
        cache.put(Entity.getPrimaryKey(), Entity);
        
        return Entity.getPrimaryKey();
	}

	public void delete(T Entity) throws SQLException {
        PreparedStatement deleteStatement = null;
        
        deleteStatement = connection.prepareStatement(getDeleteStatement());
        deleteStatement.setLong(1, Entity.getPrimaryKey());
        deleteStatement.execute();
        
        cache.remove(Entity.getPrimaryKey());
        
	}
	
	public void cleanUp() {
		cache.clear();
	}
}
