package de.jazhead.timetracking;

import de.jazhead.timetracking.config.SpringConfiguration;
import de.jazhead.timetracking.controller.ScreenController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ScreenController controller = context.getBean(ScreenController.class);
        controller.init(primaryStage);
    }
}
