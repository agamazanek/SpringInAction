package pl.sda.jira.documentation.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Author {

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Author() {
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

    public String fullName() {
        return name + " " + lastName;
    }
}
