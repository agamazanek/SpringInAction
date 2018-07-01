package pl.sda.jira.documentation.domain;

import pl.sda.jira.documentation.dto.DocumentationDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Documentation {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;

    public Documentation(String name ) {

        this.title = name;

    }

    private Documentation(){}


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public DocumentationDto asDto() {
        return new DocumentationDto(title);
    }

    public void setNewName(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName(){
        return "Title " + title + ", id : " + id;
    }

}
