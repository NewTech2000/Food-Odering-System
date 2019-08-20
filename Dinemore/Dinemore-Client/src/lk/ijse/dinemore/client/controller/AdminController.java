package lk.ijse.dinemore.client.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private ImageView imgHome;

    @FXML
    private ImageView imgLogOut;

    @FXML
    private ImageView imgUser;

    @FXML
    private ImageView imgMenu;

    @FXML
    private ImageView imgChef;

    @FXML
    private ImageView imgDelivery;

    @FXML
    private AnchorPane loadingPane;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private JFXButton btnUser;

    @FXML
    private JFXButton btnMenu;

    @FXML
    private JFXButton btnDelivery;

    @FXML
    private JFXButton btnChef;



    @FXML
    void chefAction(MouseEvent event)throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/Chef.fxml"));
        loadingPane.getChildren().setAll(anchorPane);

    }

    @FXML
    void deliveryAction(MouseEvent event)throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/Delivery.fxml"));
        loadingPane.getChildren().setAll(anchorPane);

    }

    @FXML
    void foodAction(MouseEvent event)throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/Food.fxml"));
        loadingPane.getChildren().setAll(anchorPane);

    }

    @FXML
    void homeAction(MouseEvent event)throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
        loadingPane.getChildren().setAll(anchorPane);

    }

    @FXML
    void logoutAction(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/AdminLogin.fxml"));
        Scene scene = new Scene(parent);
        Stage stage= (Stage) this.loadingPane.getScene().getWindow();
        stage.setTitle("ADMIN LOGIN");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }

    @FXML
    void userAction(MouseEvent event) throws Exception{
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/Reception.fxml"));
        loadingPane.getChildren().setAll(anchorPane);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDateTime();

    }

    private void setDateTime() {
        Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
                lblTime.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
            }

        }),new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();

    }
}
