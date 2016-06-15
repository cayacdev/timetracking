package de.jazhead.timetracking.dao;

import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.Task;

import java.util.List;

public interface ProjectDao
{
    List<Project> findAllProjects();

    int saveProject(String text);

    Project findProject(int id);

    List<Task> findSubProjects(Project project);
}
