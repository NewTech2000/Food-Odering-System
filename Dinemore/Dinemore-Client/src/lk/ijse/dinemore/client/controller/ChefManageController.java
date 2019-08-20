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
import lk.ijse.dinemore.common.dto.ChefDTO;
import lk.ijse.dinemore.common.service.custom.ChefService;

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

public class ChefManageController implements Initializable {

    @FXML
    private Label lbldate;

    @FXML
    private Label lbltime;

    @FXML
    private TextField txtChefId;

    @FXML
    private TextField txtChefNic;

    @FXML
    private TextField txtChefAddress;

    @FXML
    private TextField txtChefName;

    @FXML
    private TextField txtChefMobile;

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
    private TableView<ChefDTO> tblChef;

    private ChefService chefService;

    @FXML
    void cancelAction(MouseEvent event) {
        ClereText();

    }

    @FXML
    void chefAddressAction(ActionEvent event) {
        String address=txtChefAddress.getText();
        if(!address.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Chef Address ",ButtonType.OK);
            a.show();
            txtChefAddress.selectAll();
            txtChefAddress.requestFocus();
        }else {
            txtChefNic.requestFocus();
        }

    }

    @FXML
    void chefIdAction(ActionEvent event) {
        String id=txtChefId.getText();
        if(!id.matches("[CH]{2}[0-9]{2}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Chef ID",ButtonType.OK);
            a.show();
            txtChefId.selectAll();
            txtChefId.requestFocus();
        }else {
            txtChefName.requestFocus();
        }

    }

    @FXML
    void chefMobileAction(ActionEvent event) {
        String mobile=txtChefMobile.getText();
        if(!mobile.matches("[0-9]{10}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Mobile No",ButtonType.OK);
            a.show();
            txtChefMobile.selectAll();
            txtChefMobile.requestFocus();
        }else {

        }


    }

    @FXML
    void chefNameAction(ActionEvent event) {
        String id=txtChefName.getText();
        if(!id.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Chef Name",ButtonType.OK);
            a.show();
            txtChefName.selectAll();
            txtChefName.requestFocus();
        }else {
            txtChefAddress.requestFocus();
        }


    }

    @FXML
    void chefNicAction(ActionEvent event) {
       String nic =txtChefNic.getText();
       if(!nic.matches("[0-9]{9}[Vv]{1}")){
           Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Chef NIC",ButtonType.OK);
           a.show();
           txtChefNic.selectAll();
           txtChefNic.requestFocus();

       }else{
           txtChefMobile.requestFocus();
       }

    }

    public boolean validate() {
        if (txtChefId.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Chef Id is Empty", ButtonType.OK);
            a.show();
            return false;
        } else {
            if (txtChefName.getText().trim().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Chef Name is Empty", ButtonType.OK);
                a.show();
                return false;
            } else {
                if (txtChefNic.getText().trim().isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.WARNING, "Chef Nicis Empty", ButtonType.OK);
                    a.show();
                    return false;
                } else {
                    if (txtChefMobile.getText().trim().isEmpty()) {
                        Alert a = new Alert(Alert.AlertType.WARNING, "Chef Mobile is Empty", ButtonType.OK);
                        a.show();
                        return false;
                    } else {
                        if (txtChefAddress.getText().trim().isEmpty()) {
                            Alert a = new Alert(Alert.AlertType.WARNING, "Chef Address is Empty", ButtonType.OK);
                            a.show();
                            return false;

                        }
                    }
                }
            }
            return true;
        }
    }


    @FXML
    void deleteAction(MouseEvent event) throws Exception {
        if( validate()) {
            boolean delete = chefService.deleteChef(txtChefId.getText());
            if (delete) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Chef Has Deleted", ButtonType.OK);
                alert.show();
                ClereText();
                loadChef();

            } else {
                Alert error = new Alert(Alert.AlertType.ERROR, "Chef Not Deleted", ButtonType.OK);
                error.show();
            }
        }
    }

    @FXML
    void saveAction(MouseEvent event) throws Exception {
        if( validate()) {
            boolean save = chefService.saveChef(new ChefDTO(txtChefId.getText(), txtChefName.getText(), txtChefAddress.getText(), Integer.parseInt(txtChefMobile.getText()), txtChefNic.getText()));
            if (save) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Chef Has Saved", ButtonType.OK);
                alert.show();
                ClereText();
                loadChef();

            } else {
                Alert error = new Alert(Alert.AlertType.ERROR, "Chef Not Saved", ButtonType.OK);
                error.show();
            }
        }

    }

    public void ClereText(){
        txtChefId.clear();
        txtChefName.clear();;
        txtChefAddress.clear();
        txtChefMobile.clear();
        txtChefNic.clear();

    }

    @FXML
    void searchAction(MouseEvent event) throws Exception {
//        int chefid=Integer.parseInt(txtChefId.getText());
        ChefDTO chefDTO = chefService.searchChef(txtChefId.getText());
        if(chefDTO !=null){
            txtChefName.setText(chefDTO.getChef_name());
            txtChefAddress.setText(chefDTO.getChef_address());
            txtChefNic.setText(chefDTO.getChef_Nic());
            txtChefMobile.setText(""+chefDTO.getChef_mobile());
        }


    }

    @FXML
    void updateAction(MouseEvent event) throws Exception {
        if( validate()) {
            boolean update = chefService.updateChef(new ChefDTO(txtChefId.getText(), txtChefName.getText(), txtChefAddress.getText(), Integer.parseInt(txtChefMobile.getText()), txtChefNic.getText()));
            if (update) {
                Alert up = new Alert(Alert.AlertType.CONFIRMATION, "Chef Has Updated", ButtonType.OK);
                up.show();
                ClereText();
                loadChef();

            } else {
                Alert error = new Alert(Alert.AlertType.ERROR, "Chef Not Updated", ButtonType.OK);
                error.show();
            }
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            chefService= (ChefService) Naming.lookup("rmi://localhost:8080/chef");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        setDateTime();

        tblChef.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("chef_id"));
        tblChef.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("chef_name"));
        tblChef.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("chef_address"));
        tblChef.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("chef_Nic"));
        tblChef.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("chef_mobile"));

        try {
            loadChef();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            loadChefID();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void loadChefID() throws SQLException, IOException, ClassNotFoundException {
//        String chefId;
//        chefId= IDGenerator.getNewID("Chef", " chef_id", "CH");
//        txtChefId.setText(chefId);

    }

    private void loadChef() throws Exception {
        tblChef.setItems(FXCollections.observableArrayList(chefService.getAllChefs()));

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
