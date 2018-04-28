package pl.sda.jira.project;

import org.springframework.beans.factory.annotation.Autowired;

public class ProjectControler {

    private final TeamStorage teamStorage;

    public ProjectControler(TeamStorage teamStorage) {
        this.teamStorage = teamStorage;
    }


    public boolean existsFor(String teamId) {
        teamStorage.setTeamExist(true);
        return true;
    }
}
