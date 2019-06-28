package BasicApp.articles;

import javax.persistence.*;

/*
The Article class is the Model part of the MVC framework.





* The @Entity annotation is used to establish Article as database Entity.
* */
@Entity
@Table(name = "articles")
public class Article {

	/*
	* The @Id annotation specifies that private Integer article_id is a primary key.
	* The @GeneratedValue(strategy = GenerationType.AUTO) annotation specifies that the article_id is auto generated and will not be provided as parameter while insertion operations.
	* */


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer article_id;
	private String title;
	private String text;

	public Article() {
	}

	public Article(String title, String text) {
		this.title = title;
		this.text = text;
	}

	public Article(Integer article_id, String title, String text) {
		this.article_id = article_id;
		this.title = title;
		this.text = text;
	}

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
