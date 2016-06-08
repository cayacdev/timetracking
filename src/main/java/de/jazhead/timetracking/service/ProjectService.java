package de.jazhead.timetracking.service;

import de.jazhead.timetracking.exception.ValidationErrorException;
import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.SubProject;

import java.util.List;

/**
 * @Author jazhead
 */
public interface ProjectService
{
    List<Project> getAllProjects();

    Project saveProject(String text) throws ValidationErrorException;

    List<SubProject> getSubProjectsForProject(Project project);
}
