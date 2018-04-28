package pl.sda.jira.project;

public class ProjectControler {

    public ProjectControler(TeamStorage teamStorage) {
        this.teamStorage = teamStorage;
        teamStorage.setTeamExist(true);
    }

    private final TeamStorage teamStorage;

}
