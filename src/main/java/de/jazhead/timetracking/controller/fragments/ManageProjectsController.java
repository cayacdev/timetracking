package de.jazhead.timetracking.controller.fragments;

import de.jazhead.timetracking.controller.TimeTrackingController;
import de.jazhead.timetracking.service.ProjectService;
import de.jazhead.timetracking.utils.validation.ProjectValidatorUtils;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ManageProjectsController implements TimeTrackingController, Initializable {

    private Stage stage;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectValidatorUtils projectValidatorUtils;

    public TextField textFieldProjectName;

    private final ValidationSupport validationSupport = new ValidationSupport();

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        validationSupport.registerValidator(textFieldProjectName, false, Validator.createPredicateValidator(projectValidatorUtils::isUniqueProjectName, "Projectname is already in use", Severity.ERROR));
        validationSupport.registerValidator(textFieldProjectName, false, Validator.createPredicateValidator(projectValidatorUtils::isNotEmpty, "Projectname cannot be empty", Severity.ERROR));
        validationSupport.initInitialDecoration();
    }

    public void saveProject() {
        final String text = textFieldProjectName.getText();

        if (!validationSupport.isInvalid()) {
            projectService.save(text);
            this.stage.close();
        }
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
