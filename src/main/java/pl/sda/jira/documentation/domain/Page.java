package pl.sda.jira.documentation.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "page")
public class Page {
    @Id
    @GeneratedValue
    private Long id;
    @Convert(converter = TitleConverter.class)
    private Title title;

    private String contents;

    public Page() {
    }

    public Page(Title title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return Objects.equals(id, page.id) &&
                Objects.equals(title, page.title) &&
                Objects.equals(contents, page.contents);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
