package pl.sda.jira.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.sda.jira.project.repository.ProjectRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProjectQueriesService {

    @Autowired
   private final ProjectRepository repository;

    public ProjectQueriesService(ProjectRepository repository) {
        this.repository = repository;
    }


    public List<ProjectDto> getProjectsBy(QueryDTO queryDTO) {
        Specification<Project> specification = aSpecificationFrom(queryDTO);
        List<Project> projects = repository.findAll(specification);

        return asDtos(projects);
    }

    private Specification<Project> aSpecificationFrom(QueryDTO queryDTO) {
        return (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.equal(root.get(queryDTO.getColumnName()), queryDTO.getValue());
    }

    private List<ProjectDto> asDtos(List<Project> projects) {
        return projects.stream()
                .map(Project::asDto)
                .collect(toList());
    }

}




