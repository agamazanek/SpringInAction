package pl.sda.jira.documentation.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.jira.documentation.domain.DocumentationService;

@RestController
@RequestMapping("/documentation")
public class DocumentationController {

    private final DocumentationService documentationService;

    public DocumentationController(DocumentationService documentationService) {
        this.documentationService = documentationService;
    }

    @RequestMapping("/hello")
    public String printHello(@RequestParam(defaultValue = "No name" , name = "name") String name){
        return "Hello " + name;
    }
}
