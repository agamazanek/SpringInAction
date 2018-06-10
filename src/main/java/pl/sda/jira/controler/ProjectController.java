package pl.sda.jira.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.jira.project.model.ProjectRepository;
import pl.sda.jira.project.model.TeamRepository;
@RestController
public class ProjectController {

    @RequestMapping("/project")
    public String getProject(@RequestParam(defaultValue = "There is no such project", name = "projectId") Long projectId){
        return null;
    }


}
