package pl.sda.jira.documentation.domain;


import pl.sda.jira.documentation.dto.DocumentationDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Documentation {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.EAGER , cascade = {CascadeType.PERSIST ,CascadeType.REMOVE})
    private List<Page> pages = new ArrayList<>();

    @Convert(converter = TitleConverter.class)
    private Title title;

    @OneToOne
    private Author author;

    public Documentation(String name) {
        this.title = new Title(name);
    }

    private Documentation() {
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title.getName();
    }


    public DocumentationDto asDto() {
        return new DocumentationDto(title.getName());
    }

    public void setNewName(String title) {
        this.title = new Title(title);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFu1llName() {
        return "Title " + title.getName() + ", id : " + id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isAuthor(Author author) {
        if(this.author == null){
            return false;
        }else {
            return author.getName().equals(this.author.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documentation that = (Documentation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(author, that.author);
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
