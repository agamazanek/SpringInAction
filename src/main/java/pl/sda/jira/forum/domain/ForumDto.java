package pl.sda.jira.forum.domain;

import java.util.Objects;

public class ForumDto {
    private int id;
    public final String login;

    public ForumDto(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumDto)) return false;
        ForumDto forumDto = (ForumDto) o;
        return id == forumDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(int id) {
        this.id = id;
    }
}
