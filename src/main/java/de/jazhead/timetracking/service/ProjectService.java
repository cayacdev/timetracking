package de.jazhead.timetracking.service;

import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.Task;

import java.util.List;

public interface ProjectService
{
    List<Project> getAllProjects();

    void save(String text);

    List<Task> getTasks(Project project);
}
