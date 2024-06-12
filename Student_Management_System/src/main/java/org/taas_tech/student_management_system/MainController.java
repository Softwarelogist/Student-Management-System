package org.taas_tech.student_management_system;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Integer> idColumn;
    @FXML
    private TableColumn<Student, String> rollnumColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, Integer> ageColumn;
    @FXML
    private TableColumn<Student, String> gradeColumn;

    @FXML
    private TextField rollnumField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField gradeField;

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        rollnumColumn.setCellValueFactory(new PropertyValueFactory<>("rollnum"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        loadStudents(); // Load students when the application starts
    }

    private void loadStudents() {
        tableView.setItems(FXCollections.observableArrayList(DatabaseHandler.getStudents()));
    }

    @FXML
    protected void onAddButtonClick() {
        String rollnum = rollnumField.getText();
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String grade = gradeField.getText();
        DatabaseHandler.addStudent(rollnum, name, age, grade);
        loadStudents(); // Refresh the table view
        clearFields(); // Clear input fields
    }

    @FXML
    protected void onUpdateButtonClick() {
        Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            String rollnum = rollnumField.getText();
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String grade = gradeField.getText();
            DatabaseHandler.updateStudent(selectedStudent.getId(), rollnum, name, age, grade);
            loadStudents(); // Refresh the table view
            clearFields(); // Clear input fields
        }
    }

    @FXML
    protected void onDeleteButtonClick() {
        Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            DatabaseHandler.deleteStudent(selectedStudent.getId());
            loadStudents(); // Refresh the table view
            clearFields(); // Clear input fields
        }
    }

    private void clearFields() {
        rollnumField.clear();
        nameField.clear();
        ageField.clear();
        gradeField.clear();
    }
}
