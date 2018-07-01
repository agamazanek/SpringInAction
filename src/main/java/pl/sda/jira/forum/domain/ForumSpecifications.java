package pl.sda.jira.forum.domain;

import org.springframework.data.jpa.domain.Specification;

public class ForumSpecifications {
    public static Specification<Forum> byName(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Forum> byForumId(String forumId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("description"), forumId);
    }
}
