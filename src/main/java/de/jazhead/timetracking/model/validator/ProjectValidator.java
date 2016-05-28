package de.jazhead.timetracking.model.validator;

import de.jazhead.timetracking.dao.ProjectDao;
import de.jazhead.timetracking.exception.ValidationErrorException;
import de.jazhead.timetracking.model.Project;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author jazhead
 */
@Component
public class ProjectValidator
{
    @Autowired
    private ProjectDao projectDao;

    public void validate(String newProjectName) throws ValidationErrorException
    {
        List<Project> allProjects = projectDao.findAllProjects();

        boolean noneMatch = allProjects.stream().noneMatch(p -> StringUtils.equals(p.getName(), newProjectName));

        if (!noneMatch)
        {
            throw new ValidationErrorException();
        }
    }
}
