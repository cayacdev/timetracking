package de.jazhead.timetracking.controller;

import de.jazhead.timetracking.controller.scene.MainController;
import de.jazhead.timetracking.utils.FXMLUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author jazhead
 */
@Service
public class ScreenController implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private Stage stage;

    public void init(Stage stage) {
        this.stage = stage;
        String fxmlPath = "/scene/main.fxml";

        Parent root = getRoot(fxmlPath);

        this.stage.setScene(new Scene(root));
        this.stage.show();
    }

    private Parent getRoot(final String fxmlPath) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            loader.setControllerFactory(aClass -> loadScreenController(fxmlPath));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    private MainController loadScreenController(String fxmlPath) {
        Class controllerClass = FXMLUtils.getControllerClass(fxmlPath);
        return (MainController) applicationContext.getBean(controllerClass);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
