package de.jazhead.timetracking.controller;

import de.jazhead.timetracking.controller.scene.MainController;
import de.jazhead.timetracking.utils.FXMLUtils;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ScreenController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Stage mainStage;

    @Autowired
    private MainController mainController;

    @Autowired
    private FXMLUtils fxmlUtils;

    public void init(final Stage stage) {
        this.mainStage = stage;
        mainController.setStage(stage);

        final Parent root = getRoot(mainController.getView());

        this.mainStage.setScene(new Scene(root));
        this.mainStage.show();
    }

    private Parent getRoot(final String fxmlPath) {
        final Parent root;
        try {
            root = fxmlUtils.getFxmlLoader(fxmlPath).load();
        } catch (final IOException e) {
            throw new IllegalArgumentException("Cannot load: " + fxmlPath, e);
        }
        return root;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
