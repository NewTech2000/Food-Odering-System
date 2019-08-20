package lk.ijse.dinemore.client.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeliveryLoginController implements Initializable {

    @FXML
    private AnchorPane deliveryLoginPane;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private ImageView btnNewUser;

    @FXML
    void deliveryLoginAction(MouseEvent event)throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/DeliveryForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.deliveryLoginPane.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("DELIVERY FORM");
        stage.setResizable(false);
        stage.show();


    }

    @FXML
    void newUserAction(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/UserAccount.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("USER ACCOUNT");
        stage.setResizable(false);
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
