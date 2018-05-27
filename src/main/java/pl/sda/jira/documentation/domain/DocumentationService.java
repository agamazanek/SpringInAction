package pl.sda.jira.documentation.domain;

import pl.sda.jira.calendar.persistency.inmemory.InMemoryCalendarRepository;
import pl.sda.jira.documentation.dto.DocumentationDto;

public class DocumentationService {

    private DocumentationRepository documentationRepository;


    public DocumentationService(DocumentationRepository documentationRepository) {

        this.documentationRepository = documentationRepository;
    }


    public DocumentationDto get(Long documentationId) {

        if(documentationRepository.exists(documentationId)) {
            return documentationRepository.get(documentationId).asDto();
        } else {
            throw new DocumentDoesntExist("Doc doesn't exist");
        }
    }

}
