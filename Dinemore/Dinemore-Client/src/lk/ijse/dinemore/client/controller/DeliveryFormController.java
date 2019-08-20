package lk.ijse.dinemore.client.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.dinemore.common.dto.CustomerDTO;
import lk.ijse.dinemore.common.dto.DeliveryDTO;
import lk.ijse.dinemore.common.dto.OrderDTO;
import lk.ijse.dinemore.common.dto.OrderDetailsDTO;
import lk.ijse.dinemore.common.service.custom.CustomerService;
import lk.ijse.dinemore.common.service.custom.OrderService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DeliveryFormController implements Initializable {

    @FXML
    private AnchorPane deliveryPane;
    private CustomerService customerService;

    @FXML
    private ImageView imgLogOut;

    @FXML
    private Label lbldate;

    @FXML
    private Label lbltime;

    @FXML
    private TableView<OrderDTO> tblDelivery;

    @FXML
    private JFXButton btnGerOrder;

    @FXML
    private JFXButton btnDelivery;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtAddress;

    @FXML
    private JFXButton btnCustSearch;

    @FXML
    private TextField txtDeliveryID;

    @FXML
    private TextField txtStatus;

    @FXML
    private TextField txtOrderId;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TextField txtStatusOrderID;

    @FXML
    private TextField txtDeliveringStatus;

    @FXML
    private TextField txtPaid;

    @FXML
    private JFXButton btnDeliveryUpdate;

    private OrderService orderService;

    @FXML
    private TextField txtSearchOrderID;

    @FXML
    private TextField txtMenuId;

    @FXML
    private TextField txtQty;

    @FXML
    void quantityAction(ActionEvent event) {

    }



    @FXML
    void menuIdAction(ActionEvent event) {

    }


    @FXML
    void addressAction(ActionEvent event) {

    }

    @FXML
    void custNameAction(ActionEvent event) {

    }

    @FXML
    private TextField txtOrderSearchID;

    @FXML
    void custSearchAction(MouseEvent event) throws Exception {
        int id=Integer.parseInt(txtOrderSearchID.getText());
        CustomerDTO customerDTO=customerService.searchCustomer(id);
        if(customerDTO!=null){
            txtCustomerID.setText(""+customerDTO.getCustomerId());
            txtCustomerName.setText(customerDTO.getCustomerName());
            txtAddress.setText(customerDTO.getCustomerAddress());
            txtMobile.setText(""+customerDTO.getCustomerMobile());
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR,"No Such Customer",ButtonType.OK);
            a.show();
        }


    }

    @FXML
    void deliveringStatus(ActionEvent event) {

    }

    @FXML
    void deliveryAction(MouseEvent event) throws Exception {
        boolean updateDel=orderService.DeliveryFinished(new OrderDTO(txtPaid.getText(),Integer.parseInt(txtOrderId.getText()),txtDeliveringStatus.getText(),lbltime.getText(),txtDeliveryID.getText()));
        if(updateDel){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Deliverde Sucess",ButtonType.OK);
            a.show();
        }else{
            Alert b = new Alert(Alert.AlertType.ERROR,"Deliverde UnSucess",ButtonType.OK);
            b.show();
        }



    }

    @FXML
    void deliveryUpdate(MouseEvent event) {

    }

    @FXML
    void getOrderAction(MouseEvent event) throws Exception {
        loadAllOrders();

    }

    private void loadAllOrders() throws Exception {
        tblDelivery.setItems(FXCollections.observableArrayList(orderService.getAllCookedOrders()));

    }

    @FXML
    void mobileAction(ActionEvent event) {

    }

    @FXML
    void orderIDAction(ActionEvent event) {

    }

    @FXML
    void paymentStatus(ActionEvent event) {

    }

    @FXML
    void orderIdSearchAction(ActionEvent event) {

    }

    @FXML
    void statusAction(ActionEvent event) {

    }

    @FXML
    void updateAction(MouseEvent event) throws Exception {
        boolean update=orderService.DeliveryUpdate(new OrderDTO(txtStatus.getText(),txtDeliveryID.getText(),lbltime.getText(),Integer.parseInt(txtOrderId.getText())));
        if(update){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Deliver Update Status",ButtonType.OK);
            a.show();
        }else{
            Alert b = new Alert(Alert.AlertType.ERROR,"Delivery Error",ButtonType.OK);
            b.show();
        }


    }

    @FXML
    void deliveryTableClick(MouseEvent event) {
        OrderDTO dto= tblDelivery.getSelectionModel().getSelectedItem();
        txtOrderId.setText(""+dto.getOrderid());
        txtOrderSearchID.setText(""+dto.getOrderid());

    }



    @FXML
    void logoutAction(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/DeliveryLogin.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.deliveryPane.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("DELIVERY LOGIN");
        stage.setResizable(false);
        stage.show();



    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            orderService= (OrderService) Naming.lookup("rmi://localhost:8080/placeorder");
            customerService= (CustomerService) Naming.lookup("rmi://localhost:8080/customer");

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        setDateTime();

        tblDelivery.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderid"));
        tblDelivery.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblDelivery.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
        tblDelivery.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("status"));


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getAllOrders();
            }

        }, new Date(), 5000);

    }

    public void getAllOrders(){
        try {
            ArrayList<OrderDTO> availabl = orderService.getAllCookedOrders();
            tblDelivery.setItems(FXCollections.observableArrayList(availabl));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void setDateTime() {
        Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                lbldate.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
                lbltime.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
            }

        }),new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }
}
