package OpenAPI.demo.repository;

import OpenAPI.demo.domain.Search;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JPASearchRepository implements SearchRepository{

    private final EntityManager em;

    public JPASearchRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Search save(Search search) {
        em.persist(search);
        return search;
    }


    @Override
    public Optional<Search> findByTitle(String title) {
        List<Search> result = em.createQuery("select s from Search s where s.title = :title", Search.class)
                .setParameter("title", title)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Search> findAll() {
        List<Search> result = em.createQuery("select s from Search s", Search.class)
                .getResultList();
        return result;
    }
}
