package de.jazhead.timetracking.utils.validation;

import de.jazhead.timetracking.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectValidatorUtils {

    @Autowired
    private ProjectService projectService;

    public boolean isUniqueProjectName(final Object projectName) {

        return projectName instanceof String &&
                projectService.getProject((String) projectName) == null;
    }
}
