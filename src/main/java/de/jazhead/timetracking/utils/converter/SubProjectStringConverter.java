package de.jazhead.timetracking.utils.converter;

import de.jazhead.timetracking.model.Task;
import javafx.util.StringConverter;

public class SubProjectStringConverter extends StringConverter<Task>
{
    @Override
    public String toString(Task object)
    {
        return object.getName();
    }

    @Override
    public Task fromString(String string)
    {
        return null;
    }
}
