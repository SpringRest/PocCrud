package app.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by guelerauda on 27/05/2016.
 */
public interface ArticleRepository extends CrudRepository<Article, Integer> {
}
