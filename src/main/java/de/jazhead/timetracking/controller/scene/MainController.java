package de.jazhead.timetracking.controller.scene;

import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.SubProject;
import de.jazhead.timetracking.service.ProjectService;
import de.jazhead.timetracking.utils.converter.ProjectStringConverter;
import de.jazhead.timetracking.utils.converter.SubProjectStringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author jazhead
 */
@Component
public class MainController implements Initializable
{
    public ComboBox<Project> projectComboBox;
    public ComboBox<SubProject> subProjectComboBox;

    @Autowired
    private ProjectService projectService;
    private ObservableList<Project> list;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        list = FXCollections.observableArrayList(projectService.getAllProjects());

        projectComboBox.setItems(list);
        projectComboBox.setConverter(new ProjectStringConverter());
        subProjectComboBox.setConverter(new SubProjectStringConverter());

        list.addListener((ListChangeListener<? super Project>) e -> System.out.println("changed"));
        //list.addListener();
    }

    public void saveProject(ActionEvent actionEvent)
    {
        // TODO: 01.06.16 we dont need it here
        /*String text = textField.getText();
        Project project;
        try
        {
            project = projectService.saveProject(text);
            list.add(project);
            textField.setText("");
        } catch (ValidationErrorException validationErrorException)
        {
            ValidatorNotification.message("Validation error", "The project " + text + " already exists");
        }*/
    }

    public void updateProject(ActionEvent actionEvent)
    {
        // TODO: 01.06.16 only if tracking == false

        Project selectedProject = projectComboBox.getSelectionModel().getSelectedItem();

        List<SubProject> subProjectList = projectService.getSubProjectsForProject(selectedProject);
        ObservableList<SubProject> subProjectObservableList = FXCollections.observableArrayList(subProjectList);

        subProjectComboBox.setItems(subProjectObservableList);

    }
}
