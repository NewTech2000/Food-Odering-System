package lk.ijse.dinemore.client.controller;

//import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
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

public class LoginController implements Initializable {

    @FXML
    private AnchorPane loginPane;

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
        stage.setTitle("USER ACCOUNT");
        stage.setResizable(false);
        stage.show();


    }

    @FXML
    void receptionLoginAction(MouseEvent event)throws Exception {
//        Stage stage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/PlaceOrders.fxml"));
        Scene scene = new Scene(parent);
        Stage stage=(Stage)this.loginPane.getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("PLACE ORDER");
        stage.show();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void userNameAction(ActionEvent actionEvent) {
    }

    public void passwordAction(ActionEvent actionEvent) {
    }
}
