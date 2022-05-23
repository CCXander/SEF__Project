package Code.Controllers;

import Code.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Code.Helpers.JsonObjHelper;

import java.io.IOException;

public class AddController {
    private Stage stage;
    private Scene scene;

    @FXML
    public TextField productName;

    @FXML
    public TextArea productDescription;

    @FXML
    public TextField productPrice;

    @FXML
    public void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("companyHome.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public String name;
    public String description;
    public String price;

    @FXML
    public void onAddButtonClick(ActionEvent event) throws IOException {

        name ="";
        description ="";
        price ="";

        name = String.valueOf(productName.getText());
        description = String.valueOf(productDescription.getText());
        price = String.valueOf(productPrice.getText());

        JsonObjHelper.createProduct(name,description,price);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("companyHome.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
