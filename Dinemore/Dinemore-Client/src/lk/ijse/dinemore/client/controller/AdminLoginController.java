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

public class AdminLoginController implements Initializable {

    @FXML
    private AnchorPane adminLoginPane;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private ImageView btnNewUser;

    @FXML
    void adminLoginAction(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/AdminPanel.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.adminLoginPane.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("ADMIN FORM");
        stage.setResizable(false);
        stage.show();


    }

    @FXML
    void newUserAction(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/UserAccount.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("USER ACCOUNT");
        stage.show();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
