package pl.sda.jira.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.jira.calendar.queries.QueryCriteriaDto;
import pl.sda.jira.project.model.ProjectQueriesService;
import pl.sda.jira.project.model.ProjectDto;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectQueriesController {

    @Autowired
    ProjectQueriesService service;

    @RequestMapping( method = RequestMethod.POST)
    public List<ProjectDto> read(@ModelAttribute QueryCriteriaDto query){

        return service.getProjectsBy(query);
    }
}
