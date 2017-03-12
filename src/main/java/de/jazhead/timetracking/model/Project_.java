package de.jazhead.timetracking.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Project.class)
public class Project_ {
    public static volatile SingularAttribute<Project, Integer> id;
    public static volatile SingularAttribute<Project, String> name;
    public static volatile ListAttribute<Project, Task> taks;
}
