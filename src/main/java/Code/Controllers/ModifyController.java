package Code.Controllers;

import Code.Helpers.JsonObjHelper;
import Code.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyController {
    private Stage stage;
    private Scene scene;

    @FXML
    private Label labelInitial;

    @FXML
    private TextField nameInitial;

    @FXML
    public TextField productName;

    @FXML
    public TextArea productDescription;

    @FXML
    public TextField productPrice;

    @FXML
    private Label labelName;

    @FXML
    private Label labelDescription;

    @FXML
    private Label labelPrice;

    @FXML
    private Button selectButton;

    @FXML
    private Button modifyButton;

    public void initialize() {
        labelName.setVisible(false);
        labelDescription.setVisible(false);
        labelPrice.setVisible(false);
        productDescription.setVisible(false);
        productName.setVisible(false);
        productPrice.setVisible(false);
        modifyButton.setVisible(false);
    }

    @FXML
    public void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("companyHome.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public String[] values;

    @FXML
    public void onSelectButtonClick(ActionEvent event) throws IOException {
        labelName.setVisible(true);
        labelDescription.setVisible(true);
        labelPrice.setVisible(true);
        productDescription.setVisible(true);
        productName.setVisible(true);
        productPrice.setVisible(true);
        modifyButton.setVisible(true);

        nameInitial.setVisible(false);
        labelInitial.setVisible(false);
        selectButton.setVisible(false);

        String Name=nameInitial.getText();

        values=JsonObjHelper.setModifyText(Name);
        productName.setText(values[0]);
        productDescription.setText(values[1]);
        productPrice.setText(values[2]);
    }

    @FXML
    public void onModifyButtonClick(ActionEvent event) throws IOException {
        String newName = productName.getText();
        String newDescription = productDescription.getText();
        String newPrice = productPrice.getText();

        JsonObjHelper.modifyProduct(newName,newDescription,newPrice,values[0]);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("companyHome.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
