package de.jazhead.timetracking.service;

import de.jazhead.timetracking.exception.ValidationErrorException;
import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.Task;

import java.util.List;

public interface ProjectService
{
    List<Project> getAllProjects();

    Project save(String text) throws ValidationErrorException;

    List<Task> getTasks(Project project);
}
