package de.jazhead.timetracking.utils;

import de.jazhead.timetracking.controller.TimeTrackingController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FXViewUtils {

    @Autowired
    private FXMLUtils fxmlUtils;

    public Stage getModalStage(final TimeTrackingController controller) {
        final Parent viewNode;
        try {
            viewNode = fxmlUtils.getFxmlLoader(controller.getView()).load();
        } catch (final IOException e) {
            throw new IllegalArgumentException("Cannot load node for: " + controller.getView(), e);
        }
        final Stage stage = new Stage();
        controller.setStage(stage);

        final Scene scene = new Scene(viewNode);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        return stage;
    }
}
