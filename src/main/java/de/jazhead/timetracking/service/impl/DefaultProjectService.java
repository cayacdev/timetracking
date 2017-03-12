package de.jazhead.timetracking.service.impl;

import de.jazhead.timetracking.dao.ProjectDao;
import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.Task;
import de.jazhead.timetracking.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProjectService implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> getAllProjects() {
        return projectDao.findAllProjects();
    }

    @Override
    public void save(final String text) {
        projectDao.saveProject(text);
    }

    @Override
    public List<Task> getTasks(final Project project) {
        return projectDao.findSubProjects(project);
    }
}
