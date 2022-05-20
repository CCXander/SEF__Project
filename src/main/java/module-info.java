module com.example.sef__project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sef__project to javafx.fxml;
    exports com.example.sef__project;
}