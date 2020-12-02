package projektarbete.Main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projektarbete.Controller.ContactBook;

import java.util.ArrayList;

public class UpdateContact extends Application {

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

        Text tName = new Text("Enter name: ");
        TextField tfName = new TextField();
        tfName.setPromptText("First name");


        ArrayList<String> firstNamesArrayList = new ArrayList<String>(MainMenu.workContactHashMap.keySet());

        ObservableList<String> updateName =
                FXCollections.observableArrayList(firstNamesArrayList);

        ObservableList<String> updateChoice =
                FXCollections.observableArrayList(
                        "First name", "Last name", "Phone number", "Email", "Company", "Title", "Job phone number"
                );

        final ComboBox comboBoxName = new ComboBox(updateName);
        final ComboBox comboBoxUpdate = new ComboBox(updateChoice);

        Button aBack = new Button("Back");
        Button updateButton = new Button("Update");

        aBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainMenu mainMenu = new MainMenu();
                mainMenu.start(stage);
            }
        });
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(comboBoxName.getValue());
                System.out.println(comboBoxUpdate.getValue());
                UpdateAlertBox.display((String) comboBoxName.getValue(), (String) comboBoxUpdate.getValue());

            }
        });

        updateGridPane.add(tName,0,0);
        updateGridPane.add(comboBoxName,1,0);
        updateGridPane.add(updateButton,3,0);
        updateGridPane.add(comboBoxUpdate, 2, 0);
        updateGridPane.add(aBack,1,7);

        Scene scene = new Scene(updateGridPane);
        stage.setScene(scene);
        stage.show();
    }
}
