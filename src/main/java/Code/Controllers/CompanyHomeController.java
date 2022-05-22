package Code.Controllers;

import Code.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Code.Helpers.Cryptography;
import Code.Helpers.JsonObjHelper;
import Code.Controllers.LoginController;

import java.io.IOException;

public class CompanyHomeController {

    @FXML
    private Label userLabel;

    public void initialize() {
        userLabel.setText(LoginController.username);
    }

    private Stage stage;
    private Scene scene;

    public void onLogoutClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
