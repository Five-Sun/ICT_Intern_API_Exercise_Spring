package OpenAPI.demo.controller;

import OpenAPI.demo.domain.Search;
import OpenAPI.demo.repository.SearchRepository;
import OpenAPI.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    private final SearchService searchService;


    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/kakao")
    public String create(Form form) {
        Search search = new Search();
        search.setTitle(form.getTitle());
        System.out.println(("search = " + search.getTitle()));
        searchService.join(search);
        return "search";
    }


    @GetMapping("/search")
    public String list(Model model,@RequestParam(required = false,defaultValue = "0", value = "page") int page ) {
        model.addAttribute("searches", searchService.findSearch(page));
        System.out.println(page);
        return "search";
    }
}
