package pl.sda.jira.template;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Template {
    @Id @GeneratedValue private String id;
    private String name;
    private String lastName;
    private Template() {}

    public Template(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    private String description;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
