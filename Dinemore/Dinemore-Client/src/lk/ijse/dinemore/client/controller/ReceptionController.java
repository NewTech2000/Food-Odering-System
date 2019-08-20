package lk.ijse.dinemore.client.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import lk.ijse.dinamore.IDGenerator.IDGenerator;
import lk.ijse.dinamore.db.DBConnection;
import lk.ijse.dinemore.common.dto.*;
import lk.ijse.dinemore.common.service.custom.CustomerService;
import lk.ijse.dinemore.common.service.custom.MenuService;
import lk.ijse.dinemore.common.service.custom.OrderService;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceptionController implements Initializable {

    private MenuService menuService;
    private OrderService orderService;
    private CustomerService customerService;

    @FXML
    private AnchorPane orderPane;

    @FXML
    private ImageView imgLogOut;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Label lbldate;

    @FXML
    private Label lbltime;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtCustomerNic;

    @FXML
    private TextField txtCustomerAddress;

    @FXML
    private TextField txtCustomerMobile;

    @FXML
    private JFXButton btnCustomerSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXComboBox<String> cmbMenuCode;

    @FXML
    private TextField txtMenuCategory;

    @FXML
    private TextField txtMenuName;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtOrderQty;

    @FXML
    private TextField txtAmmount;

    @FXML
    private DatePicker orderDate;

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private JFXButton btnAddToCartCancel;

    @FXML
    private TableView<PlaceOrderDTO> tblOrder;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private JFXButton btnPlaceCancel;
    private OrderDTO orderDTO;

    @FXML
    private TableView<CustomerDTO> tblCustomer;

    @FXML
    private Label lblDate1;

    @FXML
    private Label lblTime1;

    @FXML
    private TextField txtStatusOrderID;

    @FXML
    private Label lblStatus;



    @FXML
    private TableView<MenuDTO> tblMenus;

    @FXML
    private TableView<OrderDTO> tblOrderNew;

    @FXML
    private TextField txtReciption;

    @FXML
    private JFXButton btnOrderSearch;

    @FXML
    private TextField txtSearchStatus;

    @FXML
    void searchStatusAction(ActionEvent event) {

    }

    @FXML
    void menuCodeAction(ActionEvent event) {

    }

    @FXML
    private TextField txtMenuCode;



    @FXML
    void addToCartAction(MouseEvent event) throws Exception {
        int custid=Integer.parseInt(txtCustomerId.getText());
        String custname=txtCustomerName.getText();
        String custAddress=txtCustomerAddress.getText();
        String custNic=txtCustomerNic.getText();
        int custMobile=Integer.parseInt(txtCustomerMobile.getText());
        int menuid=Integer.parseInt(txtMenuCode.getText());
        int orderid=Integer.parseInt(txtOrderId.getText());
        int orderqty=Integer.parseInt(txtOrderQty.getText());
        double price=Double.parseDouble(txtTotalAmmount.getText());
        String date=orderDate.getValue().toString();
        String time =lbltime.getText();
        String status=txtStatus.getText();
        CustomerDTO customerDTO = new CustomerDTO(custid,custname,custAddress,custNic,custMobile);
        ArrayList<OrderDetailsDTO> orderDetailsDTOS=new ArrayList <>(10);
        orderDetailsDTOS.add(new OrderDetailsDTO(orderid,menuid,orderqty,price));
        int recip=Integer.parseInt(txtReciption.getText());


        boolean save =orderService.save(new OrderDTO(orderid,date,time,price,orderqty,recip,status,customerDTO,orderDetailsDTOS));
        if(save){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Order Was Added",ButtonType.OK);
            a.show();


        }else {
            Alert b = new Alert(Alert.AlertType.ERROR,"Order dosent Save",ButtonType.OK);
            b.show();
        }


    }

    @FXML
    void addToCartCancelAction(MouseEvent event) {
        txtCustomerId.clear();
        txtCustomerName.clear();
        txtCustomerAddress.clear();
        txtCustomerNic.clear();
        txtCustomerMobile.clear();
        txtOrderId.clear();
        txtOrderQty.clear();
        txtAmmount.clear();



    }


    @FXML
    void statusOrderIdAction(ActionEvent event) throws Exception {
        int odid=Integer.parseInt(txtStatusOrderID.getText());
        OrderDTO orderDTO=orderService.searchOrder(odid);
        if (orderDTO!=null){
            txtSearchStatus.setText(orderDTO.getStatus());
        }else {
            txtSearchStatus.setText("No Such Order...!");
        }

    }


    @FXML
    void addressAction(ActionEvent event) {


    }

    @FXML
    void reciptionAction(ActionEvent event) {

    }

    @FXML
    void ammountAction(ActionEvent event) {
        double tot=0;
        int qty=Integer.parseInt(txtOrderQty.getText());
        double unit=Double.parseDouble(txtUnitPrice.getText());
        tot=qty*unit;
        txtAmmount.setText(tot+"");

    }

    @FXML
    void cancelAction(MouseEvent event) {
        txtCustomerId.clear();
        txtCustomerName.clear();
        txtCustomerAddress.clear();
        txtCustomerNic.clear();
        txtCustomerMobile.clear();
        txtOrderId.clear();
        txtOrderQty.clear();
        txtAmmount.clear();


    }

    @FXML
    void categoryAction(ActionEvent event) {

    }

    @FXML
    void custIdAction(ActionEvent event) {

    }

    @FXML
    void custSearchAction(MouseEvent event) throws Exception {
        int custid=Integer.parseInt(txtCustomerId.getText());
        CustomerDTO customerDTO = customerService.searchCustomer(custid);
        if(customerDTO!=null){
            txtCustomerName.setText(customerDTO.getCustomerName());
            txtCustomerAddress.setText(customerDTO.getCustomerAddress());
            txtCustomerNic.setText(customerDTO.getCustomerNic());
            txtCustomerMobile.setText(""+customerDTO.getCustomerMobile());
        }

    }

    @FXML
    void deleteAction(MouseEvent event) {

    }



    @FXML
    void mennuCodeAction(ActionEvent event) throws Exception {
        String menuid=cmbMenuCode.getSelectionModel().getSelectedItem();
        MenuDTO menuDTO = menuService.searchMenuName(menuid);
        if(menuDTO!=null){
            txtMenuCode.setText(""+menuDTO.getFood_id());
            txtMenuCategory.setText(menuDTO.getCategory());
            txtUnitPrice.setText(menuDTO.getUnitprice()+"");
        }

    }

    @FXML
    void menuNameAction(ActionEvent event) {

    }

    @FXML
    void mobileAction(ActionEvent event) {

    }

    @FXML
    void nameAction(ActionEvent event) {

    }

    @FXML
    void nicAction(ActionEvent event) throws Exception {
        String nic =txtCustomerNic.getText();
        CustomerDTO customerDTO= customerService.searchByNIC(nic);
        if(customerDTO!=null){
            txtCustomerId.setText(""+customerDTO.getCustomerId());
            txtCustomerName.setText(customerDTO.getCustomerName());
            txtCustomerAddress.setText(customerDTO.getCustomerAddress());
            txtCustomerMobile.setText(""+customerDTO.getCustomerMobile());

        }

    }

    @FXML
    void orderDateAction(ActionEvent event) {

    }

    @FXML
    void orderIdAction(ActionEvent event) throws Exception {
        int od=Integer.parseInt(txtOrderId.getText());
        OrderDTO orderDTO = orderService.searchOrder(od);
        if (orderDTO!=null){
            txtStatus.setText(orderDTO.getStatus());
        }

    }

    @FXML
    void placeOrderCancel(MouseEvent event) {

    }

    @FXML
    void placeOrderCancelAction(MouseEvent event) {

    }

    @FXML
    void qtyAction(ActionEvent event) {

    }

    @FXML
    void unitPriceAction(ActionEvent event) {

    }

    @FXML
    void orderSearchAction(MouseEvent event) {

    }

    @FXML
    private JFXButton customerReports;

    @FXML
    private JFXButton orderReports;

    @FXML
    private JFXButton btnItemReports;


    @FXML
    private TextField txtStatus;

    @FXML
    void statusAction(ActionEvent event) {

    }

    @FXML
    private TextField txtTotalAmmount;

    @FXML
    void totalAmmountAction(ActionEvent event) {

    }


    @FXML
    void orderReportAction(MouseEvent event) {

    }

    @FXML
    void customerReportAction(MouseEvent event) {
//        try {
//            InputStream inputStream=getClass().getResourceAsStream("../src/lk/ijse/dinemore/client/reports/Customer.jasper");
//            HashMap map=new HashMap();
//
//            JasperPrint jasperPrint= JasperFillManager.fillReport(inputStream, map, DBConnection.getInstance().getConnection());
//            JasperViewer.viewReport(jasperPrint );
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ReceptionController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException | IOException ex) {
//            Logger.getLogger(ReceptionController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (JRException ex) {
//           Logger.getLogger(ReceptionController.class.getName()).log(Level.SEVERE, null, ex);
//        }



    }

    @FXML
    void itemReportAction(MouseEvent event) {


    }

    @FXML
    void placeOrderAction(MouseEvent event) {
        int id =Integer.parseInt(txtMenuCode.getText());
        String name=cmbMenuCode.getSelectionModel().getSelectedItem();
        double uprice=Double.parseDouble(txtUnitPrice.getText());
        int qty=Integer.parseInt(txtOrderQty.getText());
        String odate=orderDate.getValue().toString();
        double ammount =Double.parseDouble(txtAmmount.getText());

        PlaceOrderDTO placeOrderDTO =new PlaceOrderDTO(id,name,uprice,ammount,odate,qty);

        tblOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("menucode"));
        tblOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("menuname"));
        tblOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblOrder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("total"));



        tblOrder.getItems().add(placeOrderDTO);
        ObservableList<PlaceOrderDTO> items = tblOrder.getItems();
        double total = 0;
        for(PlaceOrderDTO one : items){
            total += one.getTotal();
        }
        txtTotalAmmount.setText("" + total);



    }






    @FXML
    void updateAction(MouseEvent event) throws Exception {
        int id=Integer.parseInt(txtCustomerId.getText());
        int mobile=Integer.parseInt(txtCustomerMobile.getText());
        boolean update = customerService.updateCustomer(new CustomerDTO(id,txtCustomerName.getText(),txtCustomerAddress.getText(),txtCustomerNic.getText(),mobile));
        if (update){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Customer Updated",ButtonType.OK);
            a.show();

        }else {
            Alert b = new Alert(Alert.AlertType.ERROR, "Customer Not Updated",ButtonType.OK);
            b.show();
        }

    }



    @FXML
    void logOutAction(MouseEvent event)throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ReceptionLogin.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.orderPane.getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            menuService= (MenuService) Naming.lookup("rmi://localhost:8080/menu");
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
        try {
            loadMenuName();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        tblOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderid"));
//        tblOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerid"));
//        tblOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("menuid"));
//        tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
//        tblOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));
//        tblOrder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("orderdate"));

        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("customerNic"));
        tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        tblCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("customerMobile"));

        tblMenus.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("food_id"));
        tblMenus.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("category"));
        tblMenus.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("foodName"));
        tblMenus.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitprice"));

        try {
            loadCustomers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            loadAllMenus();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            loadOrders();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            loadCustomerId();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        try {
//            loadOrderId();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


    }

//    private void loadOrderId() throws SQLException, IOException, ClassNotFoundException {
//        String od;
//        od= IDGenerator.getNewID("Orders", " orderid", "0");
//        txtOrderId.setText(od);
//    }

//    private void loadCustomerId() throws SQLException, IOException, ClassNotFoundException {
//        String CustID;
//        CustID= IDGenerator.getNewID("Customer", " customerId", "0");
//        txtCustomerId.setText(CustID);
//    }

    private void loadAllMenus() throws Exception {
        tblMenus.setItems(FXCollections.observableArrayList(menuService.getAllMenus()));

    }

    private void loadCustomers() throws Exception {
        tblCustomer.setItems(FXCollections.observableArrayList(customerService.getAllCustomers()));

    }

    private void loadOrders() throws Exception {
//        tblOrder.setItems(FXCollections.observableArrayList(orderService.getAllOrders()));

    }

    private void loadMenuName() throws Exception {
        ArrayList<String> strings=menuService.getMenuNames();
        cmbMenuCode.getItems().clear();
        for(String s : strings){
            cmbMenuCode.getItems().add(s);
        }
    }

    private void setDateTime() {
        Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
                lblTime.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
                lbldate.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
                lbltime.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
                lblDate1.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
                lblTime1.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
            }

        }),new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }
}
