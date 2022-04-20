package OpenAPI.demo.service;

import OpenAPI.demo.domain.Search;
import OpenAPI.demo.repository.SearchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SearchService {
    private final SearchRepository searchRepository;

    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public void join(Search search) {
        try {
            validateDuplicateSearch(search);//중복 내용 검증
            searchRepository.save(search);
        }
        catch (IllegalStateException e) {
//            searchRepository.update(search);
        }
    }

    private void validateDuplicateSearch(Search search) {
        searchRepository.findByTitle(search.getTitle())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 기록입니다.");

                        });
    }

    public List <Search> findSearch(int page ) {
        return searchRepository.findAll(page);
    }
}
