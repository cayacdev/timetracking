package de.jazhead.timetracking.service.impl;

import de.jazhead.timetracking.dao.ProjectDao;
import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jazhead
 */
@Service
public class DefaultProjectService implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> getAllProjects() {

        return projectDao.findAllProjects();

    }

    @Override
    public Project saveProject(String text) {

        int id = projectDao.saveProject(text);

        return projectDao.findProject(id);

    }
}
