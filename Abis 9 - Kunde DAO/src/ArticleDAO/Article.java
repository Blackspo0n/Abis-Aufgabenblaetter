package ArticleDAO;

public class Article {

	private Long articleNumber;
	private String description;
	private int price;
	// fuer Zugriff ArticleDAO
	private ArticleDAO articleDAO = ArticleDAO.getInstance();

	public Article(Long articleNumber, String description, int price) {
		super();
		this.articleNumber = articleNumber;
		this.description = description;
		this.price = price;
		articleDAO.create(this);
	}

	public Long getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(Long articleNumber) {
		this.articleNumber = articleNumber;
		articleDAO.update(this);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		articleDAO.update(this);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		articleDAO.update(this);
	}

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
		articleDAO.update(this);
	}

	/**
	 * Holen eines vorhandenen Artikels aus der Datenhaltungsschicht uber die
	 * Artikelnummer
	 **/
	public static Article read(Long articlenumber) {
		return ArticleDAO.getInstance().read(articlenumber);
	}
}
