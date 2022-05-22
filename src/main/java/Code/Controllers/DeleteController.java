package Code.Controllers;

import Code.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Code.Helpers.JsonObjHelper;

import java.io.IOException;

public class DeleteController {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField deleteName;

    @FXML
    public void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("companyHome.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onDeleteButtonClick(ActionEvent event) throws IOException {

        String name=deleteName.getText();

        JsonObjHelper.deleteProducts(name);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("companyHome.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
