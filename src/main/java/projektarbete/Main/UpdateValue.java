package projektarbete.Main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UpdateValue extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("Update contact");

        GridPane updateGridPane = new GridPane();
        updateGridPane.setMinSize(600, 400);
        updateGridPane.setPadding(new Insets(10, 10, 10, 10));
        updateGridPane.setHgap(2);
        updateGridPane.setVgap(20);
        updateGridPane.setGridLinesVisible(false);

        //Text text = new Text("Enter new " + UpdateContact.);

        Scene scene = new Scene(updateGridPane);
        stage.setScene(scene);
        stage.show();
    }
}
