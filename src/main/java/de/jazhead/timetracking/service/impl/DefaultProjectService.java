package de.jazhead.timetracking.service.impl;

import de.jazhead.timetracking.dao.ProjectDao;
import de.jazhead.timetracking.exception.ValidationErrorException;
import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.Task;
import de.jazhead.timetracking.model.validator.ProjectValidator;
import de.jazhead.timetracking.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultProjectService implements ProjectService
{
    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private ProjectValidator validator;

    @Override
    public List<Project> getAllProjects()
    {
        return projectDao.findAllProjects();
    }

    @Override
    public Project save(String text) throws ValidationErrorException
    {
        validator.validate(text);

        int id = projectDao.saveProject(text);
        return projectDao.findProject(id);

    }

    @Override
    public List<Task> getTasks(Project project)
    {
        return projectDao.findSubProjects(project);
    }
}
