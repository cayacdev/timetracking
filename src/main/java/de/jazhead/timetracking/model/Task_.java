package de.jazhead.timetracking.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Task.class)
public class Task_ {
    public static volatile SingularAttribute<Task, Integer> id;
    public static volatile SingularAttribute<Task, String> name;
    public static volatile SingularAttribute<Task, Project> project;
    public static volatile ListAttribute<Task, TimeRow> timeRows;
}
