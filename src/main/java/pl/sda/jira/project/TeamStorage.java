package pl.sda.jira.project;

public class TeamStorage {

    public boolean isTeamExist() {
        return isTeamExist;
    }

    private boolean isTeamExist = false;

    public void setTeamExist(boolean teamExist) {
        isTeamExist = teamExist;
    }
}
