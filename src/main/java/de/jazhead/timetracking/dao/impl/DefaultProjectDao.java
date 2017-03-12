package de.jazhead.timetracking.dao.impl;

import de.jazhead.timetracking.dao.AbstractDao;
import de.jazhead.timetracking.dao.ProjectDao;
import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.Project_;
import de.jazhead.timetracking.model.Task;
import de.jazhead.timetracking.model.Task_;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class DefaultProjectDao extends AbstractDao implements ProjectDao {

    @Override
    public List<Project> findAllProjects() {
        final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

        final CriteriaQuery<Project> query = builder.createQuery(Project.class);
        final Root<Project> projectRoot = query.from(Project.class);
        query.select(projectRoot);

        return getEntityManager().createQuery(query).getResultList();
    }

    @Override
    public void saveProject(final String text) {
        final Project project = new Project();
        project.setName(text);

        getEntityManager().persist(project);
    }

    @Override
    public Project findProject(final int id) {
        final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

        final CriteriaQuery<Project> query = builder.createQuery(Project.class);
        final Root<Project> projectRoot = query.from(Project.class);
        query.select(projectRoot).where(builder.equal(projectRoot.get(Project_.id), id));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    @Override
    public Project findProject(final String name) {
        final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

        final CriteriaQuery<Project> query = builder.createQuery(Project.class);
        final Root<Project> projectRoot = query.from(Project.class);
        query.select(projectRoot).where(builder.equal(projectRoot.get(Project_.name), name));

        Project result = null;
        try {
            result = getEntityManager().createQuery(query).getSingleResult();
        } catch (final NoResultException ignored) {
            
        }
        return result;
    }

    @Override
    public List<Task> findSubProjects(final Project project) {
        final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

        final CriteriaQuery<Task> query = builder.createQuery(Task.class);
        final Root<Task> taskRoot = query.from(Task.class);
        query.select(taskRoot).where(builder.equal(taskRoot.get(Task_.project), project));

        return getEntityManager().createQuery(query).getResultList();
    }
}


