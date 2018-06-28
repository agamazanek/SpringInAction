package pl.sda.jira.documentation.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.jira.documentation.domain.DocumentationService;
import pl.sda.jira.documentation.dto.DocumentationDto;

@RestController
@RequestMapping("/document")
public class DocumentationController {
    private final DocumentationService documentationService;

    public DocumentationController(DocumentationService documentationService) {
        this.documentationService = documentationService;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Long create(@ModelAttribute DocumentationDto documentationDto) {
        return documentationService.add(documentationDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> read(@PathVariable Long id) {
        if(documentationService.exists(id)){
            DocumentationDto documentationDto = documentationService.get(id);
            return new ResponseEntity<>(documentationDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("document not exist" , HttpStatus.NOT_FOUND);
        }
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
    public void delete(@PathVariable Long id) {
        documentationService.delete(id);
    }


}
