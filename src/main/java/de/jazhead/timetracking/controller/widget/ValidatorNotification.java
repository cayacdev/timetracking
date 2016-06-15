package de.jazhead.timetracking.controller.widget;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ValidatorNotification
{

    public static void message(String title, String message)
    {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);

        Label messageLabel = new Label();
        messageLabel.setText(message);

        Button button = new Button();
        button.setText("Ok");
        button.setOnAction(event -> stage.close());

        VBox layout = new VBox();
        layout.getChildren().addAll(messageLabel, button);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
