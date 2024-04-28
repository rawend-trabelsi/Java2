package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddBookControlor implements Initializable {
@FXML
private TextField tfLastName;
@FXML
private TextField tfFirstName;
@FXML
private TextField tfEmail;
@FXML
private Button addBtn;
@FXML
private Button exportBtn;
@FXML
private Button importBtn;
@FXML
private Button removeBtn;
@FXML
private Button quitBtn;
private DataClass data;


@FXML
private TableView<Person> table;
@FXML
private TableColumn<Person, String> emailCol;
@FXML
private TableColumn<Person, String> firstNameCol;
@FXML
private TableColumn<Person, String> lastNameCol;
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
    data = new DataClass();
    
    table.setItems(FXCollections.observableArrayList());
    table.getItems().addAll(data.getImportList());	
	   
    }
@FXML
private void addBtnAction(ActionEvent event) {
    if (tfFirstName.getText().isEmpty() || tfLastName.getText().isEmpty() || tfEmail.getText().isEmpty()) {
    	showAlert("All fields must be filled.");
        return;	
    }
    if (!isEmailAdress(tfEmail.getText())) {
        showAlert("Invalid email address.");
        return;
    }
    
    Person person = new Person(tfFirstName.getText(), tfLastName.getText(), tfEmail.getText());
        table.getItems().add(person);
    
    
}

@FXML
private void removeBtnAction(ActionEvent event) {
    Person selectedPerson = table.getSelectionModel().getSelectedItem();
    table.getItems().remove(selectedPerson);
}

@FXML
private void importBtnAction(ActionEvent event) {
    ObservableList<Person> importedData = FXCollections.observableArrayList(data.getImportList());
    table.setItems(importedData);
}
@FXML
private void exportBtnAction(ActionEvent event) {
   
    data.setExportList(table.getItems());
}

@FXML
private void quitBtnAction(ActionEvent event) {
    
    System.exit(0);
}
public static boolean isEmailAdress(String email){
    Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
    Matcher m = p.matcher(email.toUpperCase());
    return m.matches();
}
private void showAlert(String message) {
    Alert alert = new Alert(AlertType.WARNING);
    alert.setContentText(message);
    alert.showAndWait();
}
	

}
