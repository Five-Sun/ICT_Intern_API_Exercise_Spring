package OpenAPI.demo.controller;

import OpenAPI.demo.domain.Search;
import OpenAPI.demo.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProjectController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/kakao")
    public String kakao() {
        return "kakao";
    }



    @GetMapping("/data")
    public String data() {
        return "data";
    }

}
