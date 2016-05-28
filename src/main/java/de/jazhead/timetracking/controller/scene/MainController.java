package de.jazhead.timetracking.controller.scene;

import de.jazhead.timetracking.model.Project;
import de.jazhead.timetracking.service.ProjectService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author jazhead
 */
@Component
public class MainController implements Initializable {
    public ComboBox<Project> comboBox;

    @Autowired
    private ProjectService projectService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<Project> list = FXCollections.observableArrayList(projectService.getAllProjects());

        comboBox.setItems(list);

        System.out.println("test");
    }

}
