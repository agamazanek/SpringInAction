package pl.sda.jira.project.model;

public class ProjectName {
   private String name;

    public ProjectName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ProjectName() {
    }

    @Override
    public String toString() {
        return name;
    }
}
