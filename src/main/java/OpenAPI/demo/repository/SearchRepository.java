package OpenAPI.demo.repository;

import OpenAPI.demo.domain.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface SearchRepository {
    Search save(Search search);
    Search update(Search search);
    Optional<Search> findById(Long id);
    Optional<Search> findByTitle(String title);
    List<Search> findAll();
}