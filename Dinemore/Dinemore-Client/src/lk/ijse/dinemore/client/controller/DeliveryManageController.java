package lk.ijse.dinemore.client.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.dinamore.IDGenerator.IDGenerator;
import lk.ijse.dinemore.common.dto.DeliveryDTO;
import lk.ijse.dinemore.common.service.custom.DeliveryService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DeliveryManageController implements Initializable {

    @FXML
    private TextField txtDeliveryId;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnSave;

    @FXML
    private TableView<DeliveryDTO> tblDelivery;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtBikeNo;

    @FXML
    private Label lbldate;

    @FXML
    private Label lbltime;

    private DeliveryService deliveryService;

    @FXML
    void addressAction(ActionEvent event) {
        String address=txtAddress.getText();
        if(!address.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Deliver Address ",ButtonType.OK);
            a.show();
            txtAddress.selectAll();
            txtAddress.requestFocus();
        }else {
            txtContact.requestFocus();
        }


    }

    @FXML
    void bikeNoAction(ActionEvent event) {
        String id=txtBikeNo.getText();
        if(!id.matches("[B]{1}[0-9]{3}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Bike ID",ButtonType.OK);
            a.show();
            txtBikeNo.selectAll();
            txtBikeNo.requestFocus();
        }else {
            txtName.requestFocus();
        }


    }

    @FXML
    void cancelAction(MouseEvent event) {
        txtDeliveryId.clear();
        txtName.clear();
        txtAddress.clear();
        txtNic.clear();
        txtContact.clear();
        txtBikeNo.clear();

    }

    @FXML
    void contactAction(ActionEvent event) {
        String mobile=txtContact.getText();
        if(!mobile.matches("[0-9]{10}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Mobile No",ButtonType.OK);
            a.show();
            txtContact.selectAll();
            txtContact.requestFocus();
        }else {
            txtNic.requestFocus();

        }



    }

    @FXML
    void deleteAction(MouseEvent event) throws Exception {
        if(validate()) {
            boolean delete = deliveryService.deleteDelivery(txtDeliveryId.getText());
            if (delete) {
                Alert del = new Alert(Alert.AlertType.CONFIRMATION, "Deliver Has Deleted", ButtonType.OK);
                del.show();
                ClearText();
                loadDeliver();
            } else {
                Alert er = new Alert(Alert.AlertType.ERROR, "Error In Delete", ButtonType.OK);
                er.show();
            }
        }

    }

    @FXML
    void deliveryIdAction(ActionEvent event) {
        String id=txtDeliveryId.getText();
        if(!id.matches("[D]{1}[0-9]{3}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Deliver ID",ButtonType.OK);
            a.show();
            txtDeliveryId.selectAll();
            txtDeliveryId.requestFocus();
        }else {
            txtBikeNo.requestFocus();
        }


    }

    @FXML
    void nameAction(ActionEvent event) {
        String id=txtName.getText();
        if(!id.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Deliver Name",ButtonType.OK);
            a.show();
            txtName.selectAll();
            txtName.requestFocus();
        }else {
            txtAddress.requestFocus();
        }


    }

    @FXML
    void nicAction(ActionEvent event) {
        String nic=txtNic.getText();
        if(!nic.matches("[0-9]{9}[Vv]{1}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Deliver NIC",ButtonType.OK);
            a.show();
            txtNic.selectAll();
            txtNic.requestFocus();

        }else{
        }

    }

    @FXML
    void saveAction(MouseEvent event) throws Exception {
        if(validate() ){
            boolean save = deliveryService.saveDelivery(new DeliveryDTO(txtDeliveryId.getText(), txtName.getText(), txtNic.getText(), txtAddress.getText(), Integer.parseInt(txtContact.getText()), txtBikeNo.getText()));
            if (save) {
                Alert add = new Alert(Alert.AlertType.CONFIRMATION, "Deliver Has Saved", ButtonType.OK);
                add.show();
                ClearText();
                loadDeliver();
            } else {
                Alert er = new Alert(Alert.AlertType.ERROR, "Error In Saved", ButtonType.OK);
                er.show();
            }
        }
    }

    public boolean validate() {
        if (txtDeliveryId.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Deliver Id is Empty", ButtonType.OK);
            a.show();
            return false;
        } else {
            if (txtName.getText().trim().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Deliver Name is Empty", ButtonType.OK);
                a.show();
                return false;
            } else {
                if (txtNic.getText().trim().isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.WARNING, "Deliver Nicis Empty", ButtonType.OK);
                    a.show();
                    return false;
                } else {
                    if (txtContact.getText().trim().isEmpty()) {
                        Alert a = new Alert(Alert.AlertType.WARNING, "Deliver Mobile is Empty", ButtonType.OK);
                        a.show();
                        return false;
                    } else {
                        if (txtAddress.getText().trim().isEmpty()) {
                            Alert a = new Alert(Alert.AlertType.WARNING, "Deliver Address is Empty", ButtonType.OK);
                            a.show();
                            return false;

                        } else {
                            if (txtBikeNo.getText().trim().isEmpty()) {
                                Alert a = new Alert(Alert.AlertType.WARNING, "Deliver Bike ID is Empty", ButtonType.OK);
                                a.show();
                                return false;

                            }
                        }
                    }
                }
                return true;
            }
        }
    }



    @FXML
    void searchAction(MouseEvent event) throws Exception {
        DeliveryDTO deliveryDTO=deliveryService.searchDelivery(txtDeliveryId.getText());
        if(deliveryDTO!=null){
            txtName.setText(deliveryDTO.getName());
            txtAddress.setText(deliveryDTO.getAddress());
            txtNic.setText(deliveryDTO.getDel_Nic());
            txtContact.setText(""+deliveryDTO.getMobileNo());
            txtBikeNo.setText(""+deliveryDTO.getBikeNo());
        }

    }

    @FXML
    void updateAction(MouseEvent event) throws Exception {
        if(validate()) {
            boolean update = deliveryService.updateDelivery(new DeliveryDTO(txtDeliveryId.getText(), txtName.getText(), txtNic.getText(), txtAddress.getText(), Integer.parseInt(txtContact.getText()), txtBikeNo.getText()));
            if (update) {
                Alert up = new Alert(Alert.AlertType.CONFIRMATION, "Deliver Has Updated", ButtonType.OK);
                up.show();
                ClearText();
                loadDeliver();
            } else {
                Alert er = new Alert(Alert.AlertType.ERROR, "Error In Update", ButtonType.OK);
                er.show();
            }
        }
    }

    public void ClearText(){
        txtDeliveryId.clear();
        txtName.clear();
        txtAddress.clear();
        txtNic.clear();
        txtContact.clear();
        txtBikeNo.clear();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            deliveryService= (DeliveryService) Naming.lookup("rmi://localhost:8080/delivery");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        setDateTime();

        tblDelivery.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("delivery_id"));
        tblDelivery.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDelivery.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblDelivery.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("mobileNo"));
        tblDelivery.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("del_Nic"));
        tblDelivery.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("bikeNo"));

        try {
            loadDeliver();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            loadDeliveryID();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void loadDeliveryID() throws SQLException, IOException, ClassNotFoundException {
//        String delID;
//        delID= IDGenerator.getNewID("delivery", " delivery_id", "D0");
//        txtDeliveryId.setText(delID);

    }

    private void loadDeliver() throws Exception {
        tblDelivery.setItems(FXCollections.observableArrayList(deliveryService.getAllDeliveries()));

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
