package pl.sda.jira.calendar.rest.persistency;

import org.springframework.data.jpa.domain.Specification;
import pl.sda.jira.calendar.domain.model.Calendar;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByEventCakendarSpecification implements Specification<Calendar> {
    private final String event;

    public ByEventCakendarSpecification(String event) {
        this.event = event;
    }

    @Override
    public Predicate toPredicate(Root<Calendar> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("event"), event);
    }
}
