package de.jazhead.timetracking.utils.converter;

import de.jazhead.timetracking.model.SubProject;
import javafx.util.StringConverter;

/**
 * Created by philipp.mueller on 01.06.16.
 */
public class SubProjectStringConverter extends StringConverter<SubProject>
{
    @Override
    public String toString(SubProject object)
    {
        return object.getName();
    }

    @Override
    public SubProject fromString(String string)
    {
        return null;
    }
}
