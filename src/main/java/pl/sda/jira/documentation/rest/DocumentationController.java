package pl.sda.jira.documentation.rest;

import org.springframework.web.bind.annotation.*;
import pl.sda.jira.documentation.domain.DocumentationService;
import pl.sda.jira.documentation.dto.DocumentationDto;

@RestController
@RequestMapping("document")
public class DocumentationController {

    private final DocumentationService documentationService;

    public DocumentationController(DocumentationService documentationService) {
        this.documentationService = documentationService;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    private String create(@ModelAttribute DocumentationDto documentationDto) {
        documentationService.add(documentationDto);
        return "Documentation title: "
                + documentationDto.getTitle()
                + " "
                + documentationDto.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private String read(@PathVariable Long id) {
        documentationService.get(id);
        return "Retrieved: " + id;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    private String update(@ModelAttribute DocumentationDto documentationDto) {
        documentationService.update(documentationDto.getId(), documentationDto.getTitle());
        return "Documentation changed: "
                + documentationDto.getTitle()
                + " "
                + documentationDto.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    private String delete(@PathVariable Long id) {
        documentationService.delete(id);
        return "Removed: " + id;

    }


}
