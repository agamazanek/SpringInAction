package pl.sda.jira.project.repository;

import org.springframework.data.jpa.domain.Specification;
import pl.sda.jira.project.model.Project;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByIdProjectSpecification implements Specification<Project> {

    private final Long id;
    public ByIdProjectSpecification(Long id) {
        this.id = id;
    }

    @Override
    public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("id"),id);
    }
}
