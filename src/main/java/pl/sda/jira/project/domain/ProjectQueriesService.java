package pl.sda.jira.project.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import pl.sda.jira.project.model.Project;
import pl.sda.jira.project.model.ProjectDto;
import pl.sda.jira.project.model.QueryDTO;
import pl.sda.jira.project.repository.ByNameProjectSpecification;
import pl.sda.jira.project.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectQueriesService {

    @Autowired
    ProjectRepository repository;

    public List<ProjectDto> getProjectsBy(QueryDTO queryDTO) {
        Specification<Project> specification = aSpecificationFrom(queryDTO);
        List<Project> projects = repository.findAll(specification);

        return asDtos(projects);
    }

    private List<ProjectDto> asDtos(List<Project> projects) {
        List<ProjectDto> projectDtos = new ArrayList<>();
        for (Project project : projects) {
            projectDtos.add(project.asDto());
        }
        return projectDtos;
    }

    private Specification<Project> aSpecificationFrom(QueryDTO queryDTO) {

        Specification<Project> specification = Specifications
                .where(new ByNameProjectSpecification(queryDTO.getValue()));

        return specification;
    }


}

