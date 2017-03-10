package de.jazhead.timetracking.dao.impl;

import de.jazhead.timetracking.dao.AbstractDao;
import de.jazhead.timetracking.dao.ProjectDao;
import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.Task;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultProjectDao extends AbstractDao implements ProjectDao {
    @Override
    public List<Project> findAllProjects() {
        return getCurrentSession().createCriteria(Project.class).list();
    }

    @Override
    public void saveProject(final String text) {
        final Project project = new Project();
        project.setName(text);

        getCurrentSession().save(project);
    }

    @Override
    public Project findProject(final int id) {
        return (Project) getCurrentSession().createCriteria(Project.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public List<Task> findSubProjects(final Project project) {
        return getCurrentSession().createCriteria(Task.class).add(Restrictions.eq("project", project)).list();
    }
}


