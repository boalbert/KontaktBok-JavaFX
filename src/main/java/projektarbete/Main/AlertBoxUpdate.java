package projektarbete.Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

public class AlertBoxUpdate extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("Update");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(250, 270);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(20);
        gridPane.setHgap(2);
        gridPane.setGridLinesVisible(false);

        stage.initModality(Modality.APPLICATION_MODAL);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });

        gridPane.add(closeButton,0,0);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.showAndWait();

    }
}
