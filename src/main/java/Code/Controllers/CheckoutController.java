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

public class CheckoutController {

    @FXML
    private TextField productName;

    @FXML
    private TextField productPrice;

    @FXML
    private TextField userName;

    @FXML
    private TextField userAddress;

    private Stage stage;
    private Scene scene;

    public void initialize() {

        productName.setText(CustomerHomeController.productName);
        productPrice.setText(CustomerHomeController.productPrice);
        userName.setText(LoginController.username);
        userAddress.setText(LoginController.Address);
    }

    public void onPurchaseButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("purchaseSuccess.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("customerHome.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
