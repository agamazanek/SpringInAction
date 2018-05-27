package pl.sda.jira.forum.domain;

public class Forum {
    private int forumId;

    public int getForumId() {
        return forumId;
    }

    public Forum(int forumId) {
        this.forumId = forumId;
    }

    public ForumDto asDto() {
        ForumDto forumDto = new ForumDto();
        forumDto.setId(forumId);

        return forumDto;
    }
}

