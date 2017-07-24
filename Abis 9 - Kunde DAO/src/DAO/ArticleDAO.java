package DAO;

import java.sql.*;
import Entity.Article;
import framework.AbstractDAO;

public class ArticleDAO extends AbstractDAO<Article> {

	static ArticleDAO instance;
	
	private ArticleDAO () {}
	
	public static ArticleDAO getInstance() {
		if(instance == null) {
			instance = new ArticleDAO();
		}
		
		return instance;
	}
	
	public String getInsertStatement() {
		return "INSERT INTO KUNDEN VALUES(?, ?, ?)";
	}

	public String getUpdateStatement() {
		return "UPDATE KUNDEN SET NAME = ?, KDGRP = ? WHERE KDNR = ?";
	}

	public String getDeleteStatement() {
		return "DELETE FROM KUNDEN WHERE KDNR = ?";
	}

	public String getFindStatement() {
		return "SELECT KDNR, NAME, KDGRP FROM KUNDEN WHERE KDNR=?";
	}

	public Article doLoad(ResultSet rs) throws SQLException {
		Long articleNumber = new Long(rs.getLong(1));
		String description = rs.getString(2);
		double price = rs.getDouble(3);
		
		Article result = new Article(articleNumber, description, price);
		return result;
	}

	public PreparedStatement doUpdate(Article entity, PreparedStatement stmnt) throws SQLException {
        stmnt.setLong(3, entity.getArticleNumber());
        stmnt.setString(1, entity.getDescription());
        stmnt.setDouble(2, entity.getPrice());
        
		return stmnt;
	}

	public PreparedStatement doInsert(Article entity, PreparedStatement stmnt) throws SQLException {
        stmnt.setLong(3, entity.getArticleNumber());
        stmnt.setString(1, entity.getDescription());
        stmnt.setDouble(2, entity.getPrice());
        
		return stmnt;
	}
}