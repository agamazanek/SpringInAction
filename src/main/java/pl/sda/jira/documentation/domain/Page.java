package pl.sda.jira.documentation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Page {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "some_new_column")
    private String content;

    private Page() {
    }
    public Page(String content){
        this.content=content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
