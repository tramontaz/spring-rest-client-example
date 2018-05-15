package net.chemodurov.tutorial.spring_rest_client_example;

import net.chemodurov.tutorial.spring_rest_client_example.controller.ArticleRestTemplate;
import net.chemodurov.tutorial.spring_rest_client_example.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final ArticleRestTemplate articleRestTemplate;

    @Autowired
    public Application(ArticleRestTemplate articleRestTemplate) {
        this.articleRestTemplate = articleRestTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) {
        Article article = articleRestTemplate.getById(1);
        System.out.println("Id: " + article.getArticleId());
        System.out.println("Title: " + article.getTitle());
        System.out.println("Category: " + article.getCategory());

        for (Article article1 : articleRestTemplate.getAllArticles()) {
            System.out.println();
            System.out.println("Id: " + article1.getArticleId());
            System.out.println("Title: " + article1.getTitle());
            System.out.println("Category: " + article1.getCategory());
            System.out.println("\n=========================================================");
        }
    }
}