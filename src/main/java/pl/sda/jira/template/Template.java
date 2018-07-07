package pl.sda.jira.template;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
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

    public Long getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return Objects.equals(id, template.id) &&
                Objects.equals(name, template.name) &&
                Objects.equals(lastName, template.lastName) &&
                Objects.equals(description, template.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, description);
    }
}
