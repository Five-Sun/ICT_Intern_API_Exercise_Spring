package OpenAPI.demo.repository;

import OpenAPI.demo.domain.Search;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemorySearchRepository implements SearchRepository{

    private static Map<Integer, Search> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public Search save(Search search) {
        search.setId((++sequence));
        store.put(search.getId(),search);
        return search;
    }

    @Override
    public Optional<Search> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Search> findByTitle(String title) {
        return store.values().stream()
                .filter(search -> search.getTitle().equals(title))
                .findAny();
    }

    @Override
    public List<Search> findAll() {
        return new ArrayList<>(store.values());
    }
}
