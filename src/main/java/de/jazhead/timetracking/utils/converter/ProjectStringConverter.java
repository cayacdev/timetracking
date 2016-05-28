package de.jazhead.timetracking.utils.converter;

import de.jazhead.timetracking.model.Project;
import javafx.util.StringConverter;

/**
 * @Author jazhead
 */
public class ProjectStringConverter extends StringConverter<Project>
{
    @Override
    public String toString(Project object)
    {
        return object.getName();
    }

    @Override
    public Project fromString(String string)
    {
        return null;
    }
}
