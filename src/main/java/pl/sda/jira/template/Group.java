package pl.sda.jira.template;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Group {
    @Id @GeneratedValue
    private Long id;
    private String name;

    private Group() {}

    public Group(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
