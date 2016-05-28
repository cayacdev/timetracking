package de.jazhead.timetracking.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mg on 28.05.2016.
 */
abstract public class AbstractDao
{
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }
}
