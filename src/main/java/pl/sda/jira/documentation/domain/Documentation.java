package pl.sda.jira.documentation.domain;


import org.hibernate.annotations.Cascade;
import pl.sda.jira.documentation.dto.DocumentationDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Documentation {
    @Id
    @GeneratedValue
    private Long id;
    @Convert(converter = TitleConverter.class)

    private Title title;
    @OneToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    private Author author;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Page> pages = new ArrayList<>();

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
        return "Title " + title + ", id : " + id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
