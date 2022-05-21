package Code.Controllers;

import Code.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerRegisterController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField customerPhoneTextField;

    @FXML
    private TextField personalAddressTextField;

    @FXML
    private Label inputError;

    public String username;
    public String password;
    public String customerPhone;
    public String personalAddress;
    public int valid;

    private Stage stage;
    private Scene scene;

    public void initialize() {
        inputError.setVisible(false);
    }

    public void onRegisterButtonClick(ActionEvent event) throws IOException {

        valid=1;

        username="";
        password="";
        customerPhone ="";
        personalAddress ="";

        username = String.valueOf(usernameTextField.getText());
        password = String.valueOf(passwordTextField.getText());
        customerPhone = String.valueOf(customerPhoneTextField.getText());
        personalAddress = String.valueOf(personalAddressTextField.getText());

        System.out.println(username);
        System.out.println(password);
        System.out.println(customerPhone);
        System.out.println(personalAddress);

        if(username.equals("") || password.equals("") || customerPhone.equals("") || personalAddress.equals("")){
            valid=0;
        }

        if(valid==0){
            inputError.setVisible(true);
        }else {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
            scene = new Scene(fxmlLoader.load());
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        passwordTextField.clear();
    }

    public void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


}
