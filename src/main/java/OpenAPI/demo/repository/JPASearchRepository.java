package OpenAPI.demo.repository;

import OpenAPI.demo.domain.Search;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JPASearchRepository implements SearchRepository {

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
    public Search update(Search search) {
        em.createQuery("update Search s set s.count = (s.count +1) where s.title = :title")
                .setParameter("title", search.getTitle())
                .executeUpdate();
        return null;
    }

    @Override
    public Optional<Search> findById(Long id) {
        Search search = em.find(Search.class, id);
        return Optional.ofNullable(search);
    }

    @Override
    public Optional<Search> findByTitle(String title) {
        List<Search> result = em.createQuery("select s from Search s where s.title = :title", Search.class)
                .setParameter("title", title)
                .getResultList();
        return result.stream().findAny();
    }


//    @Override
//    public List<Search> findAll() {
//         return em.createQuery("select s from Search s order by s.id desc", Search.class)
//                 .setFirstResult(11)
//                 .setMaxResults(10)
//                 .getResultList();
//
//    }
    @Override
    public List<Search> findAll() {
        return em.createQuery("select s from Search s order by s.id desc", Search.class)
                .setFirstResult(11)
                .setMaxResults(10)
                .getResultList();

    }
}
