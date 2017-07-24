package dao;

import java.sql.SQLException;

import entity.Article;

public class ArticleDAOTest {
	public static void main(String[] args) {
		System.out.println("############ Framework Test ###########");
		
		System.out.println("Erstelle Artikel :");
        Article article;
		try {
			article = new Article(1331l, "Mega geiler Laptop mit Pentium 4 Prozessor", 2999.99);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("#######################");
        System.out.println("Setze lokale Variable auf NULL und hole den Artikel zurueck:");
        article = null;
        try {
			article = Article.read(1331l);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	System.out.println("#######################");
        System.out.println("Der Artikel " + article.getArticleNumber() + " "
                + article.getDescription()+", hat folgenden Preis : "+article.getPrice());
    	System.out.println("#######################");        
        System.out.println("Aktualisiere Artikel. Preis auf 3099,99 gesetzt");
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
    	System.out.println("#######################");
        System.out.println("Der Artikel hat jetzt einen Preis von  " + article.getPrice());

 
        try {
			Article.delete(article);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        article = null;
    	System.out.println("#######################");
        System.out.println("Versuche den Artikel nach löschen erneut zu lesen: ");
        try {
            article = Article.read(1331l);
            System.out.println(article);
        }
        catch (Exception e) {
        	System.err.println("Lesen des Artikels fehlgeschlagen");
		}
	}
}
