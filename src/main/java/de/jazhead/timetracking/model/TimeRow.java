package de.jazhead.timetracking.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "timeRow")
public class TimeRow
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "description", length = 1000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    public int getId()
    {
        return id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(final Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(final Date endDate)
    {
        this.endDate = endDate;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public Task getTask()
    {
        return task;
    }

    public void setTask(final Task task)
    {
        this.task = task;
    }
}
