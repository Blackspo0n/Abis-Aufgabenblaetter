package dao;

import java.sql.SQLException;

import entity.Article;

public class ArticleDAOTest {
	public static void main(String[] args) {
		System.out.println("############ Framework Test ###########");
		
		System.out.println("Creating des Article nimst fahrt auf:");
        Article article;
		try {
			article = new Article(1331l, "Mega geiler Laptop mit Pentium 4 Prozessor", 2999.99);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        
        System.out.println("Putte lokale Variable at NULL und gette Article back:");
        article = null;
        try {
			article = Article.read(1331l);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        
        System.out.println("Der Artikel bimst vong der Presistensigkeit her follewed " + article.getArticleNumber() + " "
                + article.getDescription()+", "+article.getPrice());
                
        System.out.println("Refreshe Article. Price auf 3099,99 am been");
        try {
			article.setPrice(3099.99);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        
        article = null;
        try {
			article = Article.read(1331l);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        System.out.println("Article bimst jetzt mit Price " + article.getPrice());

 
        try {
			Article.delete(article);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        article = null;
        
        System.out.println("Trye den Article nach destruction erneud zu readen: ");
        try {
            article = Article.read(1331l);
            System.out.println(article);
        }
        catch (Exception e) {
        	System.err.println("readen des Articles bimst fehlgeschlagen");
		}
	}
}
