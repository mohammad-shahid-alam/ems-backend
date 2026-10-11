package net.javaguides.ems.controller;

import net.javaguides.ems.entity.Project;
import net.javaguides.ems.repository.ProjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public Map<String , List<String>> getProjectsWithEmployees () {
        return projectRepository.findAll().stream()
                .collect(Collectors.toMap(
                        project -> project.getName(),
                        project -> project.getEmployees().stream()
                                .map(e -> e.getFirstName() + " " + e.getLastName())
                                .toList()
                ));
    }
}

