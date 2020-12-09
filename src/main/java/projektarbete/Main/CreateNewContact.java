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

public class CreateNewContact extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("Add contact");

        GridPane addGridPane = new GridPane();
        addGridPane.setMinSize(600, 400);
        addGridPane.setPadding(new Insets(10, 10, 10, 10));
        addGridPane.setHgap(2);
        addGridPane.setVgap(20);
        addGridPane.setGridLinesVisible(false);

        Text tFirstName = new Text("First Name:");
        addGridPane.add(tFirstName,0,0);
        TextField tfAddFirstName = new TextField();
        tfAddFirstName.setPromptText("First name");
        addGridPane.add(tfAddFirstName,1,0);

        Text tLastName = new Text("Last Name:");
        addGridPane.add(tLastName,0,1);
        TextField tfAddLastName = new TextField();
        tfAddLastName.setPromptText("Last name");
        addGridPane.add(tfAddLastName,1,1);

        Text tCompany = new Text("Company:");
        addGridPane.add(tCompany,0,2);
        TextField tfAddCompany = new TextField();
        tfAddCompany.setPromptText("Company");
        addGridPane.add(tfAddCompany,1,2);

        Text tTitle = new Text("Title:");
        addGridPane.add(tTitle,0,3);
        TextField tfAddTitle = new TextField();
        tfAddTitle.setPromptText("Title");
        addGridPane.add(tfAddTitle,1,3);

        Text tPhone = new Text("Phone number:");
        addGridPane.add(tPhone,0,4);
        TextField tfAddPhone = new TextField();
        tfAddPhone.setPromptText("Job phone number");
        addGridPane.add(tfAddPhone,1,4);

        Text tJobPhone = new Text("Job phone number:");
        addGridPane.add(tJobPhone,0,5);
        TextField tfAddJobPhone = new TextField();
        tfAddJobPhone.setPromptText("Job phone number");
        addGridPane.add(tfAddJobPhone,1,5);

        Text tEmail = new Text("Email:");
        addGridPane.add(tEmail,0,6);
        TextField tfAddEmail = new TextField();
        tfAddEmail.setPromptText("Email");
        addGridPane.add(tfAddEmail,1,6);

        Button addButton = new Button("Add new Contact");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)  {
                try {
                    ContactBook.addWorkContactToContactBook(
                            tfAddFirstName.getText(),
                            tfAddLastName.getText(),
                            tfAddPhone.getText(),
                            tfAddEmail.getText(),
                            tfAddCompany.getText(),
                            tfAddTitle.getText(),
                            tfAddJobPhone.getText());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                ContactBook.printContactBook();
                MainMenu mainMenu = new MainMenu();
                mainMenu.start(stage);
            }

        });
        addGridPane.add(addButton,0,7);

        Button backButton = new Button("Back");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainMenu mainMenu = new MainMenu();
                mainMenu.start(stage);
            }
        });
        addGridPane.add(backButton,1,7);

        Scene scene = new Scene(addGridPane);
        stage.setTitle("Create New Contact");
        stage.setScene(scene);
        stage.show();
    }
}
