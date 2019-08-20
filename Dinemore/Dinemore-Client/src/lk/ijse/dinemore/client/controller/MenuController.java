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
import lk.ijse.dinemore.common.dto.MenuDTO;
import lk.ijse.dinemore.common.dto.OrderDTO;
import lk.ijse.dinemore.common.service.custom.MenuService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MenuController implements Initializable {

    @FXML
    private TextField txtMenuID;

    @FXML
    private TextField txtMenuPrice;

    @FXML
    private TextField txtMenuCategory;

    @FXML
    private TextField txtMenuName;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<MenuDTO> tblMenu;

    @FXML
    private Label lbldate;

    @FXML
    private Label lbltime;

    private MenuService menuService;

    @FXML
    void cancelAction(MouseEvent event) {
        txtMenuID.clear();
        txtMenuName.clear();;
        txtMenuCategory.clear();
        txtMenuPrice.clear();

    }

    @FXML
    void deleteAction(MouseEvent event) throws Exception {
        if(validate()) {
            boolean delete = menuService.deleteMenu(Integer.parseInt(txtMenuID.getText()));
            if (delete) {
                Alert del = new Alert(Alert.AlertType.CONFIRMATION, "Menu Deleted", ButtonType.OK);
                del.show();
                ClearText();
                loadMenu();
            } else {
                Alert eror = new Alert(Alert.AlertType.ERROR, "Menu Not Deleted", ButtonType.OK);
                eror.show();

            }
        }

    }

    @FXML
    void menuCategoryAction(ActionEvent event) {
        String address=txtMenuCategory.getText();
        if(!address.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Menu Category ",ButtonType.OK);
            a.show();
            txtMenuCategory.selectAll();
            txtMenuCategory.requestFocus();
        }else {
            txtMenuPrice.requestFocus();
        }


    }

    @FXML
    void menuIdAction(ActionEvent event) {
        String address=txtMenuID.getText();
        if(!address.matches("[0-9 .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Menu ID ",ButtonType.OK);
            a.show();
            txtMenuID.selectAll();
            txtMenuID.requestFocus();
        }else {
            txtMenuName.requestFocus();
        }



    }

    @FXML
    void menuNameAction(ActionEvent event) {
        String address=txtMenuName.getText();
        if(!address.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Menu Name ",ButtonType.OK);
            a.show();
            txtMenuName.selectAll();
            txtMenuName.requestFocus();
        }else {
            txtMenuCategory.requestFocus();
        }


    }

    @FXML
    void menuPriceAction(ActionEvent event) {
        String address=txtMenuPrice.getText();
        if(!address.matches("[0-9 .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Menu Price ",ButtonType.OK);
            a.show();
            txtMenuPrice.selectAll();
            txtMenuPrice.requestFocus();
        }else {

        }

    }

    public boolean validate() {
        if (txtMenuID.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Menu Id is Empty", ButtonType.OK);
            a.show();
            return false;
        } else {
            if (txtMenuName.getText().trim().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Menu Name is Empty", ButtonType.OK);
                a.show();
                return false;
            } else {
                if (txtMenuPrice.getText().trim().isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.WARNING, "Menu Price Empty", ButtonType.OK);
                    a.show();
                    return false;
                } else {
                    if (txtMenuCategory.getText().trim().isEmpty()) {
                        Alert a = new Alert(Alert.AlertType.WARNING, "Menu Category is Empty", ButtonType.OK);
                        a.show();
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @FXML
    void menuSearchAction(MouseEvent event) throws Exception {
        int menuid=Integer.parseInt(txtMenuID.getText());
        MenuDTO menuDTO =menuService.searchMenu(menuid);
        if(menuDTO!=null){
            txtMenuName.setText(menuDTO.getFoodName());
            txtMenuCategory.setText(menuDTO.getCategory());
            txtMenuPrice.setText(""+menuDTO.getUnitprice());
        }


    }

    public void ClearText(){
        txtMenuID.clear();
        txtMenuName.clear();;
        txtMenuCategory.clear();
        txtMenuPrice.clear();
    }

    @FXML
    void saveAction(MouseEvent event) throws Exception {
        if(validate()) {
            boolean save = menuService.saveMenu(new MenuDTO(Integer.parseInt(txtMenuID.getText()), txtMenuName.getText(), txtMenuCategory.getText(), Double.parseDouble(txtMenuPrice.getText())));
            if (save) {
                Alert add = new Alert(Alert.AlertType.CONFIRMATION, "Menu Was Added", ButtonType.OK);
                add.show();
                ClearText();
                loadMenu();
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR, "Menu Not Added", ButtonType.OK);
                error.show();
            }
        }

    }

    @FXML
    void updateAction(MouseEvent event) throws Exception {
        if(validate()) {
            boolean update = menuService.updateMenu(new MenuDTO(Integer.parseInt(txtMenuID.getText()), txtMenuName.getText(), txtMenuCategory.getText(), Double.parseDouble(txtMenuPrice.getText())));
            if (update) {
                Alert up = new Alert(Alert.AlertType.CONFIRMATION, "Menu Was Updated", ButtonType.OK);
                up.show();
                ClearText();
                loadMenu();
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR, "Menu Not Updated", ButtonType.OK);
                error.show();
            }
        }


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            menuService = (MenuService) Naming.lookup("rmi://localhost:8080/menu");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        setDateTime();

        tblMenu.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("food_id"));
        tblMenu.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("foodName"));
        tblMenu.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("category"));
        tblMenu.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitprice"));
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getAllOrders();
            }
            private void getAllOrders(){
                try {
                    ArrayList<MenuDTO> availabl = menuService.getAllMenus();
                    tblMenu.setItems(FXCollections.observableArrayList(availabl));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Date(), 5000);

        try {
            loadMenuID();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void loadMenuID() throws SQLException, IOException, ClassNotFoundException {
//        String menuID;
//        menuID= IDGenerator.getNewID("Menu", " food_id", "0");
//        txtMenuID.setText(menuID);

    }

    private void loadMenu() throws Exception {
        tblMenu.setItems(FXCollections.observableArrayList(menuService.getAllMenus()));

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
