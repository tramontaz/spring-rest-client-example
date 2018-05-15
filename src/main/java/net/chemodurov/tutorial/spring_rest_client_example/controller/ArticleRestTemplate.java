package net.chemodurov.tutorial.spring_rest_client_example.controller;

import net.chemodurov.tutorial.spring_rest_client_example.entity.Article;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ArticleRestTemplate {

    RestTemplate restTemplate = new RestTemplate();

    public Article getById(long id) {
        return restTemplate.getForObject("http://localhost:8080/user/article/" + id, Article.class);
    }

    public List<Article> getAllArticles() {
        ResponseEntity<List<Article>> responseEntity = restTemplate.exchange("http://localhost:8080/user/articles", HttpMethod.GET, null, new ParameterizedTypeReference<List<Article>>() {
                        });
        List<Article> articles = responseEntity.getBody();
        return articles;
    }
}
