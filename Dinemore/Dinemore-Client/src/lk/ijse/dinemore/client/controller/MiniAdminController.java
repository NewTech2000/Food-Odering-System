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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class MiniAdminController implements Initializable {

    @FXML
    private AnchorPane miniPane;


    @FXML
    private JFXButton btnUser;

    @FXML
    private JFXButton btnMenu;

    @FXML
    private JFXButton btnDelivery;

    @FXML
    private JFXButton btnChef;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    @FXML
    void userAction(MouseEvent event) throws Exception{
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/Reception.fxml"));
        miniPane.getChildren().setAll(anchorPane);

    }


    @FXML
    void chefAction(MouseEvent event)throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/Chef.fxml"));
        miniPane.getChildren().setAll(anchorPane);

    }

    @FXML
    void deliveryAction(MouseEvent event)throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/Delivery.fxml"));
        miniPane.getChildren().setAll(anchorPane);

    }

    @FXML
    void foodAction(MouseEvent event)throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/Food.fxml"));
        miniPane.getChildren().setAll(anchorPane);

    }

    @FXML
    void homeAction(MouseEvent event)throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
        miniPane.getChildren().setAll(anchorPane);

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
