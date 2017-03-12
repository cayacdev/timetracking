package de.jazhead.timetracking.dao;

import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.Task;

import java.util.List;

public interface ProjectDao {
    List<Project> findAllProjects();

    void saveProject(String text);

    Project findProject(int id);

    Project findProject(String name);

    List<Task> findSubProjects(Project project);
}
