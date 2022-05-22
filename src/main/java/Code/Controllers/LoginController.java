package Code.Controllers;

import Code.Helpers.JsonObjHelper;
import Code.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label inputError;

    @FXML
    private Label loginError;

    public static String username;
    public String password;
    public int valid;
    public int offset;

    public void initialize() {
        inputError.setVisible(false);
        loginError.setVisible(false);
    }

    @FXML
    public void onLoginClick(ActionEvent event) throws IOException {

        valid=1;
        offset=4;

        username="";
        password="";

        username = String.valueOf(usernameTextField.getText());
        password = String.valueOf(passwordTextField.getText());

        if(username.equals("") || password.equals("")){
            valid=0;
        }

        if(valid==0){
            inputError.setVisible(true);
        }else {

            int userType = JsonObjHelper.readUser(username, password);

            if(userType==1){
                loginError.setVisible(true);
            }else if(userType==2){
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("customerHome.fxml"));
                scene = new Scene(fxmlLoader.load());
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }else if(userType==3){
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("companyHome.fxml"));
                scene = new Scene(fxmlLoader.load());
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }

        }
        passwordTextField.clear();
    }

    @FXML
    public void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
