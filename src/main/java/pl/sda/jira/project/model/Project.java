package pl.sda.jira.project.model;

public class Project {

    @Deprecated
    public Project() {
        this("SOME NAME");
    }

    public Project(String name) {
        this.name = name;
    }

    private final String name;
    private Long Id;
    private Long budget;
    private Team team;
    private String description;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
