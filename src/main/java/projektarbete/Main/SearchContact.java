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

public class SearchContact extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("Search for contact");

        GridPane searchGridPane = new GridPane();
        searchGridPane.setMinSize(600, 400);
        searchGridPane.setPadding(new Insets(10, 10, 10, 10));
        searchGridPane.setHgap(2);
        searchGridPane.setVgap(20);
        searchGridPane.setGridLinesVisible(false);

        Text tSearch = new Text("Phone number: ");
        searchGridPane.add(tSearch, 0, 0);
        TextField tfSearch = new TextField();
        tfSearch.setPromptText("Phone number");
        searchGridPane.add(tfSearch, 1,0);

        Button searchButton = new Button("Search");
        searchGridPane.add(searchButton, 2, 0);

        Button backButton = new Button("Back");
        searchGridPane.add(backButton, 0,1);

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContactBook.searchContact(
                        tfSearch.getText()
                );

                System.out.println(ContactBook.searchContact(
                        tfSearch.getText()
                ));

            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainMenu mainMenu = new MainMenu();
                mainMenu.start(stage);
            }
        });

        Scene scene = new Scene(searchGridPane);
        stage.setScene(scene);
        stage.show();

    }
}
