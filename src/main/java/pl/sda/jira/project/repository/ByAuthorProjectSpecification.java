package pl.sda.jira.project.repository;

import org.springframework.data.jpa.domain.Specification;
import pl.sda.jira.project.model.Project;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByAuthorProjectSpecification implements Specification<Project> {

    private final String author;
    public ByAuthorProjectSpecification(String author) {
        this.author=author;
    }

    @Override
    public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("author"),author);
    }
}
