package BasicApp.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * ArticleController: The controller part of the MVC. It acts as an interface between the server's
 * services (in this case ArticleService) and the user interface.
 * It maps the requests to the server and uses the service methods to get jobs done.
 */
@RestController
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@RequestMapping("/getArticles")
	public List<Article> getAllArticles() {
		return articleService.getAllArticles();
	}

	@RequestMapping("/getArticles/{article_id}")
	public Article getArticle(@PathVariable Integer article_id) {
		return articleService.getArticle(article_id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addArticles")
	public void addArticle(Article article) {
		articleService.addArticle(article);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateArticle")
	public void updateArticle(Article article) {
		articleService.updateArticle(article);
	}

	@RequestMapping("/deleteArticle/{article_id}")
	public void deleteArticle (@PathVariable Integer article_id) {
		articleService.deleteArticle(article_id);
	}

	@RequestMapping("/titleExists/{title}")
	public boolean titleExists(@PathVariable String title) {
		return articleService.titleExists(title);
	}

	@RequestMapping("/getArticleByTitle/{title}")
	public Article getArticleByTitle(@PathVariable String title) {
		return articleService.getArticleByTitle(title);
	}

}
