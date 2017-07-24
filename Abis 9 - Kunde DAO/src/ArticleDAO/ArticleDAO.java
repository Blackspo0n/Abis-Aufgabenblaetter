package ArticleDAO;

import java.util.*;
import java.sql.*;

public class ArticleDAO {

    /* Wir benoetigen eine Struktur, um uns alle schon im Speicher
     * vorhandenen Kunden zu merken. 
     */
    private HashMap<Long, Article> cache = new HashMap<Long, Article>();
    private Connection db;
    private ResultSet rs;
    
    private static ArticleDAO instance = new ArticleDAO();
    
    private ArticleDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            db = DriverManager.getConnection("jdbc:mysql://localhost/xdb", "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /* KundeDAO ist als Singleton implementiert */
	public static ArticleDAO getInstance() {
    	return instance;
    }
    
    /* Es folgen die so genannten CRUD-Methoden:
     * (C)reate
     * (R)ead
     * (U)pdate
     * (D)elete
     */
    private final static String insertStatementString =
            "INSERT INTO KUNDEN VALUES(?, ?, ?)";

    /** Methode zum Einf�gen von Kunden in die DB
    Eigentlich wird der Schl�ssel Kundennummer erst hier
    durch die Datenbank bestimmt. Deshalb wird auch Long
    zur�ckgeliefert. Dann wird noch ein entsprechendes Muster
    ben�tigt, das einen aktuellen ID zur�ckliefert.
    Wir haben an dieser Stelle darauf verzichtet und gehen
    davon aus, dass ein eindeutiger ID bei der Anlage des Kunden
    mitgegeben wird. */
    public Long create(Article kd) {
        PreparedStatement insertStatement = null;
        try {
            insertStatement = db.prepareStatement(insertStatementString);
            insertStatement.setLong(1, kd.getArticleNumber());
            insertStatement.setString(2, kd.getDescription());
            insertStatement.setInt(3, kd.getPrice());
            insertStatement.execute();
            cache.put(kd.getArticleNumber(), kd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kd.getArticleNumber();

    }
    private final static String findStatementString =
            "SELECT KDNR, NAME, KDGRP FROM KUNDEN WHERE KDNR=?";

    /** Methode zum Finden eines Kunden anhand der Kundennummer 
     * im Speicher oder aus der Datenbank
     */
    public Article read(Long kdnr) {
        Article result = (Article) cache.get(kdnr);
        // Zunaechst in der Registry suchen
        if (result != null) {
            return result;
        }

        /* Der Kunde ist noch nicht im Speicher, laden aus der DB */
        PreparedStatement findStatement = null;
        rs = null;
        try {
            findStatement = db.prepareStatement(findStatementString);
            findStatement.setLong(1, kdnr.longValue());
            rs = findStatement.executeQuery();
            rs.next();
            result = load(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Article read(long kdnr) {
        return read(new Long(kdnr));
    }

    /** Methode zum Laden eines Kunden in den Speicher aus dem Resultset */
    private Article load(ResultSet rs) throws SQLException {
        Long articlenumber = new Long(rs.getLong(1));
        Article result = (Article) cache.get(articlenumber);
        if (result != null) {
            return result;
        }
        String description = rs.getString(2);
        int price = rs.getInt(3);
        result = new Article(articlenumber, description, price);
        cache.put(articlenumber, result);
        return result;
    }
    private final static String updateStatementString =
            "UPDATE KUNDEN SET NAME = ?, KDGRP = ? WHERE KDNR = ?";

    /** Methode zum Aktualisieren eines Kunden in der DB */
    public void update(Article kd) {
        PreparedStatement updateStatement = null;
        try {
            updateStatement = db.prepareStatement(updateStatementString);
            updateStatement.setLong(3, kd.getArticleNumber());
            updateStatement.setString(1, kd.getDescription());
            updateStatement.setInt(2, kd.getPrice());
            updateStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private final static String deleteStatementString =
            "DELETE FROM KUNDEN WHERE KDNR = ?";

    public void delete(Article kd) {
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = db.prepareStatement(deleteStatementString);
            deleteStatement.setLong(1, kd.getArticleNumber());
            deleteStatement.execute();
            cache.remove(kd.getArticleNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
