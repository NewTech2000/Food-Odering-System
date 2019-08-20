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
import lk.ijse.dinemore.common.dto.ReciptionDTO;
import lk.ijse.dinemore.common.service.custom.ReciptionService;

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

public class ReceptionManageController implements Initializable {

    @FXML
    private TextField txtReciptionId;

    @FXML
    private TextField txtReciptionNic;

    @FXML
    private TextField txtReciptionAddress;

    @FXML
    private TextField txtReciptionName;

    @FXML
    private TextField txtReciptionMobile;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnCancell;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnSave;

    @FXML
    private TableView<ReciptionDTO> tblReciption;

    @FXML
    private Label lbldate;

    @FXML
    private Label lbltime;

    private ReciptionService reiptionService;

    @FXML
    void cancelAction(MouseEvent event) {
        ClearText();

    }

    @FXML
    void deleteAction(MouseEvent event) throws Exception {
        if(validate()) {
            boolean delete = reiptionService.deleteReciption(Integer.parseInt(txtReciptionId.getText()));
            if (delete) {
                Alert del = new Alert(Alert.AlertType.CONFIRMATION, "Reciption Deleted ", ButtonType.OK);
                del.show();
                ClearText();
                loadReciption();
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR, "Reciption Not Deleted ", ButtonType.OK);
                error.show();
            }
        }
    }

    @FXML
    void reciptionIdAction(ActionEvent event) {
        String id=txtReciptionId.getText();
        if(!id.matches("[0-9 .]+" )){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Reciption ID",ButtonType.OK);
            a.show();
            txtReciptionId.selectAll();
            txtReciptionId.requestFocus();
        }else {
            txtReciptionName.requestFocus();
        }


    }

    @FXML
    void reciptionMobileAction(ActionEvent event) {
        String mobile=txtReciptionMobile.getText();
        if(!mobile.matches("[0-9]{10}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Reciption Mobile No",ButtonType.OK);
            a.show();
            txtReciptionMobile.selectAll();
            txtReciptionMobile.requestFocus();
        }else {

        }


    }

    @FXML
    void reciptionNameAction(ActionEvent event) {
        String id=txtReciptionName.getText();
        if(!id.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Reciption Name",ButtonType.OK);
            a.show();
            txtReciptionName.selectAll();
            txtReciptionName.requestFocus();
        }else {
            txtReciptionAddress.requestFocus();
        }

    }

    @FXML
    void reciptionNicAction(ActionEvent event) {
        String nic =txtReciptionNic.getText();
        if(!nic.matches("[0-9]{9}[Vv]{1}")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Reciption NIC",ButtonType.OK);
            a.show();
            txtReciptionNic.selectAll();
            txtReciptionNic.requestFocus();

        }else{
            txtReciptionMobile.requestFocus();
        }

    }

    @FXML
    void rectionAddressAction(ActionEvent event) {
        String address=txtReciptionAddress.getText();
        if(!address.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Reciption Address ",ButtonType.OK);
            a.show();
            txtReciptionAddress.selectAll();
            txtReciptionAddress.requestFocus();
        }else {
            txtReciptionNic.requestFocus();
        }

    }

    public boolean validate() {
        if (txtReciptionId.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Reciption Id is Empty", ButtonType.OK);
            a.show();
            return false;
        } else {
            if (txtReciptionName.getText().trim().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Reciption Name is Empty", ButtonType.OK);
                a.show();
                return false;
            } else {
                if (txtReciptionNic.getText().trim().isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.WARNING, "Reciption Nicis Empty", ButtonType.OK);
                    a.show();
                    return false;
                } else {
                    if (txtReciptionMobile.getText().trim().isEmpty()) {
                        Alert a = new Alert(Alert.AlertType.WARNING, "Reciption Mobile is Empty", ButtonType.OK);
                        a.show();
                        return false;
                    } else {
                        if (txtReciptionAddress.getText().trim().isEmpty()) {
                            Alert a = new Alert(Alert.AlertType.WARNING, "Reciption Address is Empty", ButtonType.OK);
                            a.show();
                            return false;

                        }
                    }
                }
            }
            return true;
        }
    }

    public void ClearText(){
        txtReciptionId.clear();
        txtReciptionName.clear();
        txtReciptionAddress.clear();
        txtReciptionMobile.clear();
        txtReciptionNic.clear();
    }

    @FXML
    void saveAction(MouseEvent event) {
        if(validate()) {
            int mobile = Integer.parseInt(txtReciptionMobile.getText());
            int id = Integer.parseInt(txtReciptionId.getText());
            try {
                boolean save = reiptionService.saveReciption(new ReciptionDTO(id, txtReciptionName.getText(), txtReciptionAddress.getText(), txtReciptionNic.getText(), mobile));
                if (save) {
                    Alert add = new Alert(Alert.AlertType.CONFIRMATION, "Reciption Saved ", ButtonType.OK);
                    add.show();
                    ClearText();
                    loadReciption();
                } else {
                    Alert error = new Alert(Alert.AlertType.ERROR, "Reciption Not Saved ", ButtonType.OK);
                    error.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void searchAction(MouseEvent event) throws Exception {
        int reciption_id= Integer.parseInt(txtReciptionId.getText());
        ReciptionDTO reciptionDTO = reiptionService.searchReciption(reciption_id);
        if(reciptionDTO!=null){
            txtReciptionName.setText(reciptionDTO.getReciption_name());
            txtReciptionAddress.setText(reciptionDTO.getReciption_address());
            txtReciptionMobile.setText(""+reciptionDTO.getReciption_mobile());
            txtReciptionNic.setText(reciptionDTO.getReciption_nic());

        }

    }

    @FXML
    void updateAction(MouseEvent event) {
        if(validate()) {
            int mobile = Integer.parseInt(txtReciptionMobile.getText());
            int id = Integer.parseInt(txtReciptionId.getText());
            try {
                boolean update = reiptionService.updateReciption(new ReciptionDTO(id, txtReciptionName.getText(), txtReciptionAddress.getText(), txtReciptionNic.getText(), mobile));
                if (update) {
                    Alert add = new Alert(Alert.AlertType.CONFIRMATION, "Reciption Updated ", ButtonType.OK);
                    add.show();
                    ClearText();
                    loadReciption();
                } else {
                    Alert error = new Alert(Alert.AlertType.ERROR, "Reciption Not Updated ", ButtonType.OK);
                    error.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            reiptionService= (ReciptionService) Naming.lookup("rmi://localhost:8080/reciption");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        setDateTime();

        tblReciption.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("reciption_id"));
        tblReciption.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("reciption_name"));
        tblReciption.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("reciption_address"));
        tblReciption.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("reciption_nic"));
        tblReciption.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("reciption_mobile"));

        try {
            loadReciption();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            loadReciptionID();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void loadReciptionID() throws SQLException, IOException, ClassNotFoundException {
//        String menuID;
//        menuID= IDGenerator.getNewID("  reciption", " reciption_id", "");
//        txtReciptionId.setText(menuID);
    }

    private void loadReciption() throws Exception {
        tblReciption.setItems(FXCollections.observableArrayList(reiptionService.getAllReciptions()));

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
