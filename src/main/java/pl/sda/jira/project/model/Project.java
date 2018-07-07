package pl.sda.jira.project.model;

import javax.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    @Convert(converter = ProjectNameConverter.class)
    private ProjectName name;
    private String author;
    @Embedded
    private ProjectManager manager;

    public Project(ProjectDto projectDto) {
        this.name = new ProjectName(projectDto.getName());
    }

    public Project() {
    }

    public Project(String name, String author) {
        this.name = new ProjectName(name);
        this.author = author;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }


    public ProjectDto asDto() {
        return new ProjectDto(name.getName());
    }

    public void update(ProjectDto projectDto) {
        this.name = new ProjectName(projectDto.getName());
    }

    public String getName() {
        return name.getName();
    }

    public void setManager(ProjectManager manager) {
        this.manager = manager;
    }
}


