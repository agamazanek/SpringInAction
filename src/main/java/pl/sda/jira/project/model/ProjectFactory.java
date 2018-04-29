package pl.sda.jira.project.model;

public class ProjectFactory {
    public Project aProject (String name) {
        return new Project(name);
    }

    public Project aProjectWithDescription(String name, String description){
        Project project = aProject(name);
        project.setDescription(description);
        return project;
    }
}
