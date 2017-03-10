package de.jazhead.timetracking.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subProject")
public class Task
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
    private List<TimeRow> timeRows;

    public int getId()
    {
        return id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public Project getProject()
    {
        return project;
    }

    public void setProject(final Project project)
    {
        this.project = project;
    }

    public List<TimeRow> getTimeRows() {
        return timeRows;
    }

    public void setTimeRows(final List<TimeRow> timeRows) {
        this.timeRows = timeRows;
    }
}
