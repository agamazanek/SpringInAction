package pl.sda.jira.documentation.dto;

import pl.sda.jira.documentation.domain.Author;

public class DocumentationDto {
    private String title;
    private Author author;

    public DocumentationDto() {
    }

    public DocumentationDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }
}
