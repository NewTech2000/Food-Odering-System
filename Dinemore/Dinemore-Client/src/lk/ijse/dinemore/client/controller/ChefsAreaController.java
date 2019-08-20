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
import lk.ijse.dinemore.common.dto.MenuDTO;
import lk.ijse.dinemore.common.dto.OrderDTO;
import lk.ijse.dinemore.common.dto.OrderDetailsDTO;
import lk.ijse.dinemore.common.service.custom.MenuService;
import lk.ijse.dinemore.common.service.custom.OrderDetailsService;
import lk.ijse.dinemore.common.service.custom.OrderService;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ChefsAreaController implements Initializable {

    @FXML
    private AnchorPane chefsAreaPane;


    @FXML
    private ImageView imgLogOut;

    @FXML
    private Label lbldate;

    @FXML
    private Label lbltime;

    @FXML
    private JFXButton btnTakeOrder;

    @FXML
    private TableView<OrderDTO> tblChefs;

    @FXML
    private JFXButton btnFinishOrder;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtUpdateStatus;

    @FXML
    private TextField txtChefID;

    @FXML
    private TextField txtStatus;

    @FXML
    private JFXButton btnUpdate;

    private OrderService orderService;
    private MenuService menuService;
    private OrderDetailsService orderDetailsService;

    @FXML
    private TextField txtmenuID;

    @FXML
    private TextField txtMenuName;

    @FXML
    void chefIdAction(ActionEvent event) {

    }
    @FXML
    void statusAction(ActionEvent event) {

    }

    @FXML
    private TextField txtOrderIDNew;

    @FXML
    void orderidNewAction(ActionEvent event) {

    }

    @FXML
    void menuIdAction(ActionEvent event) throws Exception {

        int menu=Integer.parseInt(txtmenuID.getText());
        MenuDTO menuDTO =menuService.searchMenu(menu);
        if(menuDTO!=null){
            txtMenuName.setText(menuDTO.getFoodName());
        }
    }

    @FXML
    void menuNameAction(ActionEvent event) {

    }




    @FXML
    void updateAction(MouseEvent event) throws Exception {
        boolean update=orderService.CookingUpdate(new OrderDTO(Integer.parseInt(txtOrderId.getText()),txtChefID.getText(),txtStatus.getText(),lbltime.getText()));
        if(update){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Status Updated", ButtonType.OK);
            alert.show();
            cleartext();

        }else{
            Alert error = new Alert(Alert.AlertType.ERROR,"Status Not Updated", ButtonType.OK);
            error.show();

        }

    }


    @FXML
    void fnshOrderAction(MouseEvent event) throws Exception {
        boolean update =orderService.CookingFinished(new OrderDTO(txtChefID.getText(),Integer.parseInt(txtOrderId.getText()),txtUpdateStatus.getText(),lbltime.getText()));
        if(update){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Order Has Cooked",ButtonType.OK);
            alert.show();
            ClearAll();
        }else {
            Alert er = new Alert(Alert.AlertType.ERROR,"Order Has Not Cooked",ButtonType.OK);
            er.show();
        }

    }

    @FXML
    void chefTableAction(MouseEvent event) {
        OrderDTO dto =tblChefs.getSelectionModel().getSelectedItem();
        txtOrderId.setText(""+dto.getOrderid());
        txtmenuID.setText("1");


    }


    public void ClearAll(){
//        txtStatus.clear();
        txtChefID.clear();
//        txtUpdateStatus.clear();
//        txtOrderIDNew.clear();;
        txtOrderId.clear();
    }

    @FXML
    void orderIdAction(ActionEvent event) throws Exception {
        int id =Integer.parseInt(txtOrderId.getText());
        OrderDetailsDTO dto =orderDetailsService.searchByOrderId(id);
        if(dto!=null){
            txtmenuID.setText(""+dto.getFoodid());

        }

    }

    @FXML
    void takeOrderAction(MouseEvent event) throws Exception {
       loadOrders();




    }

    private void loadOrders() throws Exception {
        tblChefs.setItems(FXCollections.observableArrayList(orderService.getAllAvailableOrders()));
    }

    @FXML
    void updateStatusAction(ActionEvent event) {

    }



    @FXML
    void logoutAction(MouseEvent event)throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ChefLogin.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.chefsAreaPane.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("CHEF LOGIN");
        stage.setResizable(false);
        stage.show();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            orderService= (OrderService) Naming.lookup("rmi://localhost:8080/placeorder");
            menuService = (MenuService) Naming.lookup("rmi://localhost:8080/menu");
            orderDetailsService = (OrderDetailsService) Naming.lookup("rmi://localhost:8080/orderDel");

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        setDateTime();

        tblChefs.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderid"));
        tblChefs.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderdate"));
        tblChefs.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("orderTime"));
        tblChefs.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblChefs.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));


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
            ArrayList<OrderDTO> availabl = orderService.getAllAvailableOrders();
            tblChefs.setItems(FXCollections.observableArrayList(availabl));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void cleartext(){
        txtChefID.clear();
//        txtStatus.clear();;
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
