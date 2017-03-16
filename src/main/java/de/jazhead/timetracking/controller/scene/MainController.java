package de.jazhead.timetracking.controller.scene;

import de.jazhead.timetracking.controller.ScreenController;
import de.jazhead.timetracking.controller.TimeTrackingController;
import de.jazhead.timetracking.controller.fragments.ManageProjectsController;
import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.model.Task;
import de.jazhead.timetracking.service.ProjectService;
import de.jazhead.timetracking.utils.FXMLUtils;
import de.jazhead.timetracking.utils.converter.ProjectStringConverter;
import de.jazhead.timetracking.utils.converter.SubProjectStringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class MainController implements TimeTrackingController, Initializable {

    private Stage stage;

    @Autowired
    public ScreenController screenController;

    @Autowired
    private ManageProjectsController manageProjectsController;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private FXMLUtils fxmlUtils;

    public MenuItem menuItemClose;
    public MenuItem menuItemEdit;

    public ComboBox<Project> projectComboBox;
    public ComboBox<Task> subProjectComboBox;

    private ObservableList<Project> list;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        list = FXCollections.observableArrayList(projectService.getAllProjects());

        projectComboBox.setItems(list);
        projectComboBox.setConverter(new ProjectStringConverter());
        subProjectComboBox.setConverter(new SubProjectStringConverter());

        list.addListener((ListChangeListener<? super Project>) e -> System.out.println("changed"));

        menuItemClose.setOnAction(e -> screenController.getMainStage().close());
        menuItemEdit.setOnAction(e -> {
            fxmlUtils.getModalStage(manageProjectsController).showAndWait();
            projectComboBox.setItems(FXCollections.observableList(projectService.getAllProjects()));
        });
    }

    public void updateSubProjectSelectionBox() {
        final Project selectedProject = projectComboBox.getSelectionModel().getSelectedItem();

        final List<Task> taskList = projectService.getTasks(selectedProject);
        final ObservableList<Task> taskObservableList = FXCollections.observableArrayList(taskList);

        subProjectComboBox.setItems(taskObservableList);
    }

    @Override
    public String getView() {
        return "/fxml/scene/main.fxml";
    }

    @Override
    public void setStage(final Stage stage) {
        this.stage = stage;
    }
}
