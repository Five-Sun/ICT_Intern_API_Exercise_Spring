package OpenAPI.demo.repository;

import OpenAPI.demo.domain.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class JPASearchRepository implements SearchRepository {

    private final EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(JPASearchRepository.class);

    public JPASearchRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Search save(Search search) {
        em.persist(search);
        return search;
    }

    @Override
    public Search update(Search search) {
//        Search update = em.find(Search.class, search.getTitle());
//        update.setCount(search.getCount() + 1);
        em.createQuery("update Search s set s.count = (s.count +1) where s.title = :title")
                .setParameter("count", search.getCount() + 1)
                .setParameter("title", search.getTitle())
                .executeUpdate();
        return null;
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
