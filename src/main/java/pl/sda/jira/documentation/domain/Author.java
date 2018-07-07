package pl.sda.jira.documentation.domain;

public class Author {
    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    private String name;
    private String lastName;



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
