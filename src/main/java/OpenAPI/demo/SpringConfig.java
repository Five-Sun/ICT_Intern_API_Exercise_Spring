package OpenAPI.demo;

import OpenAPI.demo.repository.JPASearchRepository;
import OpenAPI.demo.repository.SearchRepository;
import OpenAPI.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public SearchService searchService() {
        return new SearchService(searchRepository());
    }

    @Bean
    public SearchRepository searchRepository() {
        return new JPASearchRepository(em);
    }
}
