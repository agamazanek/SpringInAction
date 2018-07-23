package pl.sda.jira.project.model;

import java.util.Objects;

public class ProjectDto {

    private String Name;
    private String author;

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public ProjectDto() {
    }

    public ProjectDto(String name) {
        Name = name;
    }

    public ProjectDto(String name, String author) {
        Name = name;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectDto)) return false;
        ProjectDto that = (ProjectDto) o;
        return Objects.equals(Name, that.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name);
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                "Name='" + Name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
