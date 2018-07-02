package pl.sda.jira.forum.domain;

import com.sun.javafx.beans.IDProperty;
import pl.sda.jira.forum.dto.ForumDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Forum {
    @Id
    @GeneratedValue
    private long forumId;
    private String name;

    public long getForumId() {
        return forumId;
    }

    public String getName() {
        return name;
    }

    public Forum() {
    }

    Forum(String name) {
        this.name = name;
    }

    public ForumDto asDto(){
        return new ForumDto(name);
    }

    public void changeName(String name) {
        this.name = name;
    }
}
