package pl.sda.jira.forum.domain;

public class Forum {
    private final String identifier;
    private String login;

    public Forum(String identifier, String login) {
        this.identifier = identifier;
        this.login = login;
    }

    public String identifier() {return identifier;}

    public boolean hasSampleLoginAs(String login) {return this.login.equals(login);}

    public void changeLogin (String login) {this.login = login;}
}
