package pl.sda.jira.project.repository;

import org.springframework.data.jpa.domain.Specification;
import pl.sda.jira.project.model.Project;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByNameProjectSpecification implements Specification<Project> {

    private final String name;

    public ByNameProjectSpecification(String name) {
        this.name=name;
    }

    @Override
    public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("name"),name);
    }
}
