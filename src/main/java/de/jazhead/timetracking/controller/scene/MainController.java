package de.jazhead.timetracking.controller.scene;

import de.jazhead.timetracking.controller.widget.ValidatorNotification;
import de.jazhead.timetracking.exception.ValidationErrorException;
import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.service.ProjectService;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author jazhead
 */
@Component
public class MainController implements Initializable
{
    public ComboBox<Project> comboBox;
    public TextField textField;

    @Autowired
    private ProjectService projectService;
    private ObservableList<Project> list;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        list = FXCollections.observableArrayList(projectService.getAllProjects());

        comboBox.setItems(list);
        comboBox.setConverter(new StringConverter<Project>()
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
        });

        list.addListener((ListChangeListener<? super Project>) e -> System.out.println("changed"));

        System.out.println("test");
    }

    public void saveProject(ActionEvent actionEvent)
    {
        String text = textField.getText();
        Project project;
        try
        {
            project = projectService.saveProject(text);
            list.add(project);
            textField.setText("");
        } catch (ValidationErrorException validationErrorException)
        {
            ValidatorNotification.message("Validation error", "The project " + text + " already exists");
        }
    }
}
