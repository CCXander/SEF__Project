module com.example.sef__project {
    requires javafx.controls;
    requires javafx.fxml;


    opens Code to javafx.fxml;
    exports Code;
    exports Code.Controllers;
    opens Code.Controllers to javafx.fxml;
}