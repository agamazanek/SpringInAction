package pl.sda.jira.documentation.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.sda.jira.calendar.queries.QueryCriteriaDto;
import pl.sda.jira.documentation.dto.DocumentationDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryDocumentationService {

    @Autowired
    DocumentationRepository repository;

    public List<DocumentationDto> findAllBy(QueryCriteriaDto dto) {
        Specification<Documentation> specification = aSpecificationsFrom(dto);
        List<Documentation> documentations = repository.findAll(specification);

        return asDtos(documentations);
    }

    private Specification<Documentation> aSpecificationsFrom(QueryCriteriaDto dto) {
        switch (dto.getType()) {
            case "equal":
                return ((root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(dto.getName()), dto.getValue()));
            case "like":

                return ((root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.like(root.get(dto.getName()),"%" + dto.getValue()+ "%"));
            case "not":

                return ((root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.notEqual(root.get(dto.getName()), dto.getValue()));
        }
        throw new IllegalArgumentException();

    }

    private List<DocumentationDto> asDtos(List<Documentation> documentations) {
        return documentations.stream().map(Documentation::asDto).collect(Collectors.toList());
    }
}
