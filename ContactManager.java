import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContactManager extends Application {

    private ObservableList<Contact> contactList;

    @Override
    public void start(Stage primaryStage) {
        contactList = FXCollections.observableArrayList();

        ListView<Contact> listView = new ListView<>(contactList);

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField phoneField = new TextField();
        phoneField.setPromptText("Phone");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String email = emailField.getText().trim();

            if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
                contactList.add(new Contact(name, phone, email));
                nameField.clear();
                phoneField.clear();
                emailField.clear();
            }
        });

        Button editButton = new Button("Edit");
        editButton.setOnAction(e -> {
            Contact selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setName(nameField.getText().trim());
                selected.setPhone(phoneField.getText().trim());
                selected.setEmail(emailField.getText().trim());
                listView.refresh();
            }
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Contact selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                contactList.remove(selected);
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                nameField.setText(newVal.getName());
                phoneField.setText(newVal.getPhone());
                emailField.setText(newVal.getEmail());
            }
        });

        HBox inputBox = new HBox(10, nameField, phoneField, emailField, addButton, editButton, deleteButton);
        inputBox.setPadding(new Insets(10));

        VBox root = new VBox(10, listView, inputBox);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 650, 400);
        primaryStage.setTitle("Simple Contact Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
