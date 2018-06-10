package pl.sda.jira;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {
    @RequestMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }
}
