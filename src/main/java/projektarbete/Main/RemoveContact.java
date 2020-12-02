package projektarbete.Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projektarbete.Controller.ContactBook;

public class RemoveContact extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("Remove contact");

        GridPane removeGridPane = new GridPane();
        removeGridPane.setMinSize(600, 400);
        removeGridPane.setPadding(new Insets(10, 10, 10, 10));
        removeGridPane.setHgap(2);
        removeGridPane.setVgap(20);
        removeGridPane.setGridLinesVisible(false);


        Text tRemove = new Text("First name: ");
        removeGridPane.add(tRemove, 0, 0);
        TextField tfRemove = new TextField();
        tfRemove.setPromptText("First name");
        removeGridPane.add(tfRemove, 1,0);

        Button removeButton = new Button("Remove");
        removeGridPane.add(removeButton, 2, 0);

        Button backButton = new Button("Back");
        removeGridPane.add(backButton, 0,1);

        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContactBook.removeContact(
                        tfRemove.getText()

                );
                MainMenu mainMenu = new MainMenu();
                mainMenu.start(stage);
            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainMenu mainMenu = new MainMenu();
                mainMenu.start(stage);
            }
        });


        Scene scene = new Scene(removeGridPane);
        stage.setTitle("Remove Contact");
        stage.setScene(scene);
        stage.show();
    }
}
