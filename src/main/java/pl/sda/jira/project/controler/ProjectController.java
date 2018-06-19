package pl.sda.jira.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.jira.project.model.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {


    private final ProjectService service;

    @Autowired
    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @RequestMapping(path = "/hello")
    public String helloWorld() {
        return "Hello world!";
    }


}
