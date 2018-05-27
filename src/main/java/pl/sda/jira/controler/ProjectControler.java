package pl.sda.jira.controler;

import pl.sda.jira.project.model.ProjectRepository;
import pl.sda.jira.project.model.TeamRepository;

public class ProjectControler {

    private final ProjectRepository projectRepository;

    public ProjectControler( ProjectRepository projectRepository) {
        this.projectRepository=projectRepository;
    }

}
