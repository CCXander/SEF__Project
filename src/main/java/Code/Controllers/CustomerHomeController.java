package Code.Controllers;

import Code.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import Code.Helpers.Cryptography;
import Code.Helpers.JsonObjHelper;
import Code.Controllers.LoginController;

import java.io.IOException;

public class CustomerHomeController {

    @FXML
    private Label loggedUser;

    @FXML
    private Label searchErr;

    @FXML
    private TextField searchField;

    @FXML
    private TextArea productArea;

    @FXML
    private Button CheckOutButton;

    @FXML
    private Button SearchButton;


    public void initialize() {
        loggedUser.setText(LoginController.username);
        productArea.setVisible(false);
        CheckOutButton.setVisible(false);
        searchErr.setVisible(false);
    }

    private Stage stage;
    private Scene scene;

    public void onLogoutButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void onCheckOutButtonClick(){

    }

    public void onSearchButtonClick(){
        String name=productArea.getText();
        if(JsonObjHelper.productExists(name)){
            productArea.setVisible(true);
            CheckOutButton.setVisible(true);
            searchErr.setVisible(false);
            productArea.setText(JsonObjHelper.printProduct(name));
        }else{
            productArea.setVisible(false);
            CheckOutButton.setVisible(false);
            searchErr.setVisible(true);

        }

    }
}
