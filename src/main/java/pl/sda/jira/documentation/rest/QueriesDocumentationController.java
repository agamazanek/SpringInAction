package pl.sda.jira.documentation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.sda.jira.calendar.queries.QueryCriteriaDto;
import pl.sda.jira.documentation.domain.CrudJpaDocumentationRepository;
import pl.sda.jira.documentation.domain.Documentation;
import pl.sda.jira.documentation.domain.QueryDocumentationService;
import pl.sda.jira.documentation.dto.DocumentationDto;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class QueriesDocumentationController {
    @Autowired private QueryDocumentationService service;

    @RequestMapping(method = RequestMethod.POST)
    public List<DocumentationDto> getCriteria(@ModelAttribute QueryCriteriaDto dto) {
       return service.findAllBy(dto);

    }


}
