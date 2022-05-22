module com.example.sef__project {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens Code to javafx.fxml;
    exports Code;
    exports Code.Controllers;
    opens Code.Controllers to javafx.fxml;
}