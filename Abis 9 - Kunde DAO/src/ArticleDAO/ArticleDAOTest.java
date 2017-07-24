package ArticleDAO;
public class ArticleDAOTest {
    
    public static void main(String[] args) {
    	//Zugriff auf DAO-Objekt bekommen
    	ArticleDAO articleDAO = ArticleDAO.getInstance();
    	
        System.out.println("Create an Article");
        Article theArticle = new Article(4711l, "Priemer", 1);
        System.out.println("Setze lokale Variable auf NULL und hole Artikel zurueck");
        theArticle = null;
        theArticle = Article.read(4711l);
        System.out.println("Artikel ist " + theArticle.getArticleNumber() + " "
                + theArticle.getDescription()+", "+theArticle.getPrice());
        System.out.println("Aktualisiere den Artikel. Setze Preis auf 2");
        theArticle.setPrice(2);
        theArticle = null;
        theArticle = Article.read(4711l);
        System.out.println("Artikel hat jetzt Preis " + theArticle.getPrice());

        // Jetzt wird der Artikel geloescht
 
        articleDAO.delete(theArticle);
        theArticle = null;
        System.out.println("Versuche den Artikel nach Loeschung erneut zu lesen:");
        theArticle = Article.read(4711l);
        System.out.println(theArticle);

    }
    
}
