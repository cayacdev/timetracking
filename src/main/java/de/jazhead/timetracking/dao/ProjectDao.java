package de.jazhead.timetracking.dao;

import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.SubProject;

import java.util.List;

/**
 * @Author jazhead
 */
public interface ProjectDao
{
    List<Project> findAllProjects();

    int saveProject(String text);

    Project findProject(int id);

    List<SubProject> findSubProjects(Project project);
}
