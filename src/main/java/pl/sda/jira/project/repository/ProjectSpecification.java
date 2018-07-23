package pl.sda.jira.project.repository;

import org.springframework.data.jpa.domain.Specification;
import pl.sda.jira.calendar.queries.QueryCriteriaDto;
import pl.sda.jira.project.model.Project;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProjectSpecification implements Specification<Project> {
    private QueryCriteriaDto criteria;

    public ProjectSpecification(QueryCriteriaDto criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        switch (criteria.getType()) {
            case "%like%":
                if (criteria.getValue().getClass() == String.class) {
                    return criteriaBuilder.like(root.get(criteria.getName()), "%" + criteria.getValue() + "%");
                } else {
                    return criteriaBuilder.equal(root.get(criteria.getName()), criteria.getValue());
                }

            case "%like":
                if (criteria.getValue().getClass() == String.class) {
                    return criteriaBuilder.like(root.get(criteria.getName()), "%" + criteria.getValue());
                } else {
                    return criteriaBuilder.equal(root.get(criteria.getName()), criteria.getValue());
                }

            case "equals":
                return criteriaBuilder.equal(root.get(criteria.getName()), criteria.getValue());

            case "not":
                return criteriaBuilder.notEqual(root.get(criteria.getName()), criteria.getValue());

            default:
                throw new IllegalArgumentException("Invalid type: " + criteria.getType());
        }
    }
}
