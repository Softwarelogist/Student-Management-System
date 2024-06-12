package org.taas_tech.student_management_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/org/taas_tech/student_management_system/main-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Student Management System");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load FXML file.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
