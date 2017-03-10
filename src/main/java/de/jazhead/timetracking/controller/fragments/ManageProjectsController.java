package de.jazhead.timetracking.controller.fragments;

import de.jazhead.timetracking.controller.TimeTrackingController;
import de.jazhead.timetracking.service.ProjectService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ManageProjectsController implements TimeTrackingController, Initializable {

    private Stage stage;

    @Autowired
    private ProjectService projectService;

    public TextField textFieldProjectName;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

    }

    public void saveProject(final ActionEvent actionEvent) {
        final String text = textFieldProjectName.getText();

        projectService.save(text);

        this.stage.close();
    }

    @Override
    public String getView() {
        return "/fxml/fragment/manageProjects.fxml";
    }

    @Override
    public void setStage(final Stage stage) {
        this.stage = stage;
    }
}
