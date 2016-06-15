package de.jazhead.timetracking.dao.impl;

import de.jazhead.timetracking.dao.AbstractDao;
import de.jazhead.timetracking.dao.ProjectDao;
import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.Task;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultProjectDao extends AbstractDao implements ProjectDao
{
    @Override
    public List<Project> findAllProjects()
    {
        return getCurrentSession().createCriteria(Project.class).list();
    }

    @Override
    public int saveProject(String text)
    {
        Project project = new Project();
        project.setName(text);

        return (int) getCurrentSession().save(project);
    }

    @Override
    public Project findProject(int id)
    {
        return (Project) getCurrentSession().createCriteria(Project.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public List<Task> findSubProjects(Project project)
    {
        return getCurrentSession().createCriteria(Task.class).add(Restrictions.eq("project", project)).list();
    }
}


