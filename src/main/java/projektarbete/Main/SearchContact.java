package projektarbete.Main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projektarbete.Controller.ContactBook;

import java.util.ArrayList;

public class SearchContact extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("Search for contact");

        BorderPane searchBorderPane = new BorderPane();
        GridPane searchGridPane = new GridPane();
        TextArea searchTextArea = new TextArea();
//        ArrayList<String> searchArrayList = new ArrayList<String>();

//        ObservableList<String> searhFromHashMap =
//                FXCollections.observableArrayList(
//                        searchArrayList
//                );
        searchTextArea.setMaxWidth(200);
        searchBorderPane.setMinSize(600,400);

        searchGridPane.setMinSize(300, 400);
        searchGridPane.setPadding(new Insets(10, 10, 10, 10));
        searchGridPane.setHgap(2);
        searchGridPane.setVgap(20);
        searchGridPane.setGridLinesVisible(false);

        Text tSearch = new Text("First name: ");

        TextField tfSearch = new TextField();
        tfSearch.setPromptText("Phone number");

        Button searchButton = new Button("Search");
        Button backButton = new Button("Back");
        Button testPrintButton = new Button("Test print");

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

//                ObservableList<String> searhFromHashMap =
//                        FXCollections.observableArrayList(
//                                ContactBook.searchContact(
//                                        tfSearch.getText())
//                        );
                searchTextArea.setText(ContactBook.searchContact(
                        tfSearch.getText()));
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
        testPrintButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });



        searchGridPane.add(tSearch, 0, 0);
        searchGridPane.add(tfSearch, 1,0);
        searchGridPane.add(searchButton, 2, 0);
        searchGridPane.add(backButton, 0,1);

        searchBorderPane.setLeft(searchGridPane);
        searchBorderPane.setRight(searchTextArea);

        Scene scene = new Scene(searchBorderPane);
        stage.setScene(scene);
        stage.show();

    }
}
