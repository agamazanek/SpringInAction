package pl.sda.jira.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.jira.project.domain.ProjectQueriesService;
import pl.sda.jira.project.model.Project;
import pl.sda.jira.project.model.ProjectDto;
import pl.sda.jira.project.model.QueryDTO;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectQueriesController {

    @Autowired
    ProjectQueriesService service;

    @RequestMapping( method = RequestMethod.POST)
    public List<ProjectDto> read(@ModelAttribute QueryDTO query){
        return service.getProjectsBy(query);
    }
}
