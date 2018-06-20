package pl.sda.jira.project.model;

public class Project {

    private Long id;
    private String name;

    public Project(Long id, String projectName) {
        this.id = id;
        this.name = projectName;
    }

    void setProjectName(String projectName) {
        this.name = projectName;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectDto asDto() {
        return  new ProjectDto(name);
    }

    public void update(ProjectDto projectDto) {
        setProjectName(projectDto.getName());
    }

    public String getName() {
        return name;
    }
}

