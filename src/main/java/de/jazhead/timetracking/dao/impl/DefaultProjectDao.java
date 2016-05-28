package de.jazhead.timetracking.dao.impl;

import de.jazhead.timetracking.dao.ProjectDao;
import de.jazhead.timetracking.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @Author jazhead
 */
@Repository
public class DefaultProjectDao implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Project> findAllProjects() {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        transaction.begin();
        List list = session.createCriteria(Project.class).list();
        transaction.commit();

        return list;
    }

    @Override
    public int saveProject(String text) {
        Project project = new Project();
        project.setName(text);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        transaction.begin();
        Serializable save = session.save(project);
        transaction.commit();

        return (int) save;
    }

    @Override
    public Project findProject(int id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        transaction.begin();

        return (Project) session.createCriteria(Project.class).add(Restrictions.eq("id", id)).uniqueResult();
    }
}


