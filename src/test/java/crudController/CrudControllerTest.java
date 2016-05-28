package crudController;

import app.Application;
import app.domain.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by guelerauda on 28/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest("server.port:0")
public class CrudControllerTest {

    @Value("${local.server.port}")
    private int port;

    private String baseUrl = "http://127.0.0.1:";

    private RestTemplate restTemplate = new TestRestTemplate();
    private HttpHeaders requestHeaders;

    @Before
    public void init() {
        baseUrl = baseUrl + port;
        requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }

    @Test
    public void test()
    {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("EE");
        //ResponseEntity<TestEntity> result = restTemplate.postForEntity(baseUrl+"/test", testEntity, TestEntity.class);
        ResponseEntity<TestEntity> testEntityResponseEntity = restTemplate.exchange(baseUrl+"/test", HttpMethod.POST, new HttpEntity<TestEntity>(testEntity, requestHeaders) , TestEntity.class);
        assertThat(testEntityResponseEntity.getStatusCode().toString()).isEqualTo("200");
    }

    @Test
    public void testArt()
    {
        Article testEntity = new Article();
        testEntity.setName("EE");
        //ResponseEntity<TestEntity> result = restTemplate.postForEntity(baseUrl+"/test", testEntity, TestEntity.class);
        ResponseEntity<Article> testEntityResponseEntity = restTemplate.exchange(baseUrl+"/article", HttpMethod.POST, new HttpEntity<Article>(testEntity, requestHeaders) , Article.class);
        assertThat(testEntityResponseEntity.getStatusCode().toString()).isEqualTo("200");
    }

}
