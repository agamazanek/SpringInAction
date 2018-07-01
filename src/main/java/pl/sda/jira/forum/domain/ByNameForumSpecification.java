package pl.sda.jira.forum.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByNameForumSpecification implements Specification<Forum> {
    private final String name;

    public ByNameForumSpecification(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(Root<Forum> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("name"), name);
    }
}
