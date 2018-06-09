package pl.sda.jira.project.model;

public class Project {

    private Long id;
    private String projectName;

    public Project(Long id, String projectName) {
        this.id = id;
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
