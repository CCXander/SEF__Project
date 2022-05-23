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

public class CheckoutController {

    @FXML
    private TextField productName;

    @FXML
    private TextField productPrice;

    @FXML
    private TextField userName;

    @FXML
    private TextField userAddress;
}
