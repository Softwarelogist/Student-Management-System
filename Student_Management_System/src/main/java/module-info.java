module org.taas_tech.student_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.taas_tech.student_management_system to javafx.fxml;
    exports org.taas_tech.student_management_system;
}