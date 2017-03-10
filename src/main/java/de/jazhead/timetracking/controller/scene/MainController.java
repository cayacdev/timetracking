package de.jazhead.timetracking.controller.scene;

import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.Task;
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

@Component
public class MainController implements Initializable {
    public ComboBox<Project> projectComboBox;
    public ComboBox<Task> subProjectComboBox;

    @Autowired
    private ProjectService projectService;
    private ObservableList<Project> list;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        list = FXCollections.observableArrayList(projectService.getAllProjects());

        projectComboBox.setItems(list);
        projectComboBox.setConverter(new ProjectStringConverter());
        subProjectComboBox.setConverter(new SubProjectStringConverter());

        list.addListener((ListChangeListener<? super Project>) e -> System.out.println("changed"));
        //list.addListener();
    }

    public void saveProject(final ActionEvent actionEvent) {
        // TODO: 01.06.16 we dont need it here
        /*String text = textField.getText();
        Project project;
        try
        {
            project = projectService.save(text);
            list.add(project);
            textField.setText("");
        } catch (ValidationErrorException validationErrorException)
        {
            ValidatorNotification.message("Validation error", "The project " + text + " already exists");
        }*/
    }

    public void updateSubProjectSelectionBox(final ActionEvent actionEvent) {
        // TODO: 01.06.16 only if tracking == false

        final Project selectedProject = projectComboBox.getSelectionModel().getSelectedItem();

        final List<Task> taskList = projectService.getTasks(selectedProject);
        final ObservableList<Task> taskObservableList = FXCollections.observableArrayList(taskList);

        subProjectComboBox.setItems(taskObservableList);
    }
}
