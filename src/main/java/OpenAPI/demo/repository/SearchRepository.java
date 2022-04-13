package OpenAPI.demo.repository;

import OpenAPI.demo.domain.Search;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface SearchRepository {
    Search save(Search search);
    Optional<Search> findByTitle(String title);
    List<Search> findAll();

    Search update(Search search);
}
