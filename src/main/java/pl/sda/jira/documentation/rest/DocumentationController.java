package pl.sda.jira.documentation.rest;

import org.springframework.web.bind.annotation.*;
import pl.sda.jira.documentation.domain.Documentation;
import pl.sda.jira.documentation.domain.DocumentationService;
import pl.sda.jira.documentation.dto.DocumentationDto;

@RestController
@RequestMapping("document")
public class DocumentationController {

    private final DocumentationService documentationService;

    public DocumentationController(DocumentationService documentationService) {
        this.documentationService = documentationService;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String create(@ModelAttribute DocumentationDto documentationDto) {
        documentationService.add(documentationDto);
        return "Documentation title: "
                + documentationDto.getTitle();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String read(@PathVariable Long id) {
        documentationService.get(id);
        return "Retrieved: " + id;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute DocumentationDto documentationDto, @PathVariable Long id) {
        documentationService.update(documentationDto , id);
        return "Documentation changed: "
                + documentationDto.getTitle()
                + " "
                + id;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        documentationService.delete(id);
        return "Removed: " + id;

    }


}
