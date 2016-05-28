package de.jazhead.timetracking.service.impl;

import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author jazhead
 */
@Service
public class DefaultProjectService implements ProjectService {
    @Override
    public List<Project> getAllProjects() {
        Project project1 = new Project();
        project1.setId(1);
        project1.setName("Project 1");


        Project project2 = new Project();
        project2.setId(2);
        project2.setName("Project 2");

        return Arrays.asList(project1, project2);


    }
}
