package Entity;


import java.sql.SQLException;
import DAO.ArticleDAO;
import framework.Entity;

public class Article implements Entity {
	private Long articleNumber;
	private String description;
	private double price;
	
	// fuer Zugriff ArticleDAO
	private ArticleDAO articleDAO = ArticleDAO.getInstance();

	public Article(Long articleNumber, String description, double price) throws SQLException {
		setArticleNumber(articleNumber);
		setDescription(description);
		setPrice(price);
		
		articleDAO.insert(this);
	}

	public Long getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(Long articleNumber) throws SQLException {
		this.articleNumber = articleNumber;
		articleDAO.update(this);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws SQLException {
		this.description = description;
		articleDAO.update(this);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws SQLException {
		this.price = price;
		articleDAO.update(this);
	}

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) throws SQLException {
		this.articleDAO = articleDAO;
		articleDAO.update(this);
	}

	/**
	 * Holen eines vorhandenen Artikels aus der Datenhaltungsschicht uber die
	 * Artikelnummer
	 * @throws SQLException 
	 **/
	public static Article read(Long articlenumber) throws SQLException {
		return ArticleDAO.getInstance().read(articlenumber);
	}

	@Override
	public Long getPrimaryKey() {
		return getArticleNumber();
	}
}
