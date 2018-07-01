package pl.sda.jira.template.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.sda.jira.query.criteria.QueryCriteriaDto;
import pl.sda.jira.template.Template;
import pl.sda.jira.template.TemplateRepository;
import pl.sda.jira.template.dto.TemplateDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class QueryService {
    @Autowired private TemplateRepository repository;

    public List<TemplateDto> findAllBy(QueryCriteriaDto queryCriteriaDto) {
        Specification<Template> specification = aSpecificationsFrom(queryCriteriaDto);
        List<Template> templates = repository.findAll(specification);

        return asDtos(templates);
    }

    private Specification<Template> aSpecificationsFrom(QueryCriteriaDto queryCriteriaDto) {
        return (root, criteriaQuery, criteriaBuilder)
                    -> criteriaBuilder.equal(root.get("name"), "value");
    }

    private List<TemplateDto> asDtos(List<Template> templates) {
        return templates.stream()
                .map(Template::asDto)
                .collect(toList());
    }
}
