package BasicApp.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ArticleService: This is the service layer. It has the access to the database.
 * It provides services to the controller.
 *
 * The @Service annotation annotates that this class is a service class and Spring Framework only
 * creates one instance of this class. It can be autowired in the controller class.
 */

@Service
public class ArticleService {

	@Autowired
	ArticleRepository articleRepository;

	public List<Article> getAllArticles() {
		return (List<Article>) articleRepository.findAll();
	}

	public void addArticle(Article article) {
		articleRepository.save(article);
	}

	public Article getArticle(Integer article_id) {
		return articleRepository.findById(article_id).get();
	}

	public void updateArticle(Article article) {
		articleRepository.save(article);
	}

	public void deleteArticle(Integer article_id) {
		articleRepository.deleteById(article_id);
	}

	public boolean titleExists(String title) {
		if (articleRepository.findByTitle(title).size() == 0)
			return false;
		return true;
	}

	public Article getArticleByTitle(String title) {
		return articleRepository.findByTitle(title).get(0);
	}
}
