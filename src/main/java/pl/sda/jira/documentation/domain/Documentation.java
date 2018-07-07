package pl.sda.jira.documentation.domain;

import pl.sda.jira.documentation.dto.DocumentationDto;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Documentation {
    @Id
    @GeneratedValue
    private Long id;
    @Convert(converter = TitleConverter.class)

    private Title title;
    @Convert(converter = AuthorConverter.class)
    private Author author;

    public Documentation(Title name) {

        this.title = name;

    }

    private Documentation() {
    }


    public Long getId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }


    public DocumentationDto asDto() {
        return new DocumentationDto(title.getName());
    }

    public void setNewName(Title title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return "Title " + title + ", id : " + id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
