package OpenAPI.demo.controller;

import OpenAPI.demo.domain.Search;
import OpenAPI.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String list(Model model) {
        List<Search> searches = searchService.findSearch();
        model.addAttribute("searches", searches);
        return "search";
    }
}
