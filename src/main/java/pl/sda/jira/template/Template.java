package pl.sda.jira.template;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marvel_heroes")
public class Template {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false, updatable = false, name = "first_name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String description;

    private Template() {}

    public Template(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getId() {
        return String.valueOf(id);
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
