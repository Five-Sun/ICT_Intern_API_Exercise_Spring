package OpenAPI.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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
