package projektarbete.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import projektarbete.Controller.ContactBook;

public class UpdateAlertBox {

    public static void display(String name, String value) {
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Update");

        GridPane updateGridPane = new GridPane();
        updateGridPane.setMinSize(300, 100);
        updateGridPane.setPadding(new Insets(10, 10, 10, 10));
        updateGridPane.setHgap(2);
        updateGridPane.setVgap(20);
        updateGridPane.setGridLinesVisible(false);

        Text tName = new Text("New " + value + " for " + name + ": ");

        TextField textField = new TextField();
        //textField.setPromptText();
        Button closeButton = new Button("close");
        Button updateButton = new Button("Update");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int choice;
                System.out.println(textField.getText());
                switch (value) {
                    case "Company":
                        choice = 1;
                        break;
                    case "Title":
                        choice = 2;
                        break;
                    case "Job phone number":
                        choice = 3;
                        break;
                    case "First name":
                        choice = 4;
                        break;
                    case "Last name":
                        choice = 5;
                        break;
                    case "Phone number":
                        choice = 6;
                        break;
                    case "Email":
                        choice = 7;
                        break;
                    default:
                        choice = 9;
                        System.out.println("ERROR");
                        break;
                }
                System.out.println(choice);
                System.out.println(choice + name + value);
                ContactBook.updateContactBook(choice, name, textField.getText());
                ContactBook.searchContact(name);
                ContactBook.printContactBook();
                stage.close();


            }
        });


        updateGridPane.add(tName,0,0);
        updateGridPane.add(textField,1,0);
        updateGridPane.add(closeButton,0,1);
        updateGridPane.add(updateButton,2,0);


        Scene scene = new Scene(updateGridPane);
        stage.setScene(scene);
        stage.showAndWait();

    }
}
