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


    public Project(ProjectDto projectDto) {
        this.name = new ProjectName(projectDto.getName());
        this.author=projectDto.getAuthor();
    }

    public Project() {
    }

    public Project(ProjectName name, String author) {
        this.name = name;
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
        return new ProjectDto(name.getName(),author);
    }

    public void update(ProjectDto projectDto) {
        this.name = new ProjectName(projectDto.getName());
    }

    public String getName() {
        return name.getName();
    }


}


