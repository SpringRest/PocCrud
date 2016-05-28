package app.rs;

import app.domain.Article;
import app.domain.ArticleRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guelerauda on 26/05/2016.
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends CrudController<Article, Integer, ArticleRepository> {

    @RequestMapping(value="/test", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    public void test(@RequestBody String string)
    {
        System.out.println("test");
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String hello()
    {
        return "HELLO";
    }

}
