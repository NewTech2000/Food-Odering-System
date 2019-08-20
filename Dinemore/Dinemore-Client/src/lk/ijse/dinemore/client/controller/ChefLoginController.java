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

import java.net.URL;
import java.util.ResourceBundle;

public class ChefLoginController implements Initializable {

    @FXML
    private AnchorPane chefloginPane;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private ImageView btnNewUser;

    @FXML
    void newUserAction(MouseEvent event)throws Exception {
        Stage stage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/UserAccount.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
//        stage.setTitle("USER ACCOUNT");
        stage.setResizable(false);
        stage.show();


    }


    @FXML
    void chefLoginAction(MouseEvent event)throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ChefsArea.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.chefloginPane.getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("CHEFS FORM");
        stage.show();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
