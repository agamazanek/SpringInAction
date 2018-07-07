package pl.sda.jira.documentation.domain;

import org.springframework.stereotype.Service;
import pl.sda.jira.documentation.domain.exception.DocumentDoestExist;
import pl.sda.jira.documentation.dto.DocumentationDto;

@Service
public class DocumentationService {

    private final DocumentationRepository documentationRepository;

    public DocumentationService(DocumentationRepository documentationRepository) {
        this.documentationRepository = documentationRepository;
    }


    public DocumentationDto get(Long documentationId) {
        if (documentationRepository.exists(documentationId)) {
            return documentationRepository.get(documentationId).asDto();
        }
        throw new DocumentDoestExist(documentationId);
    }

    public Long add(DocumentationDto documentationDto) {

        Documentation documentation = new Documentation(documentationDto.getTitle());
        Documentation documentation1 = documentationRepository.add(documentation);

        return documentation1.getId();
    }

    public void delete(Long documentationId) {
        if (exists(documentationId)) {
            documentationRepository.delete(documentationId);
        }else {
            throw new DocumentDoestExist(documentationId);
        }

    }

    public void update(DocumentationDto documentationDto, Long id) {
        if(!exists(id)){
            throw new DocumentDoestExist(id);
        }else {
            Documentation documentation = documentationRepository.get(id);
            documentation.setNewName(documentationDto.getTitle());
            documentationRepository.update(documentation);
        }

    }

    public boolean exists(Long documentationId) {
        return documentationRepository.exists(documentationId);
    }


}

