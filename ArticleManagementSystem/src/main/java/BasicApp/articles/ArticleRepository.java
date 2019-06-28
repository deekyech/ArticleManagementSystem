package BasicApp.articles;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for all database operations. The database configuration
 * must be stored in the path "src/main/resources/application.properties"
 */
@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
	List<Article> findByTitle(String title);
}
