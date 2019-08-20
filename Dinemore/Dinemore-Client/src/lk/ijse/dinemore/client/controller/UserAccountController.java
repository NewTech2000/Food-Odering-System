package lk.ijse.dinemore.client.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.dinemore.common.dto.UserAccountDTO;
import lk.ijse.dinemore.common.service.custom.UserAccountService;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class UserAccountController implements Initializable {
    @FXML
    private AnchorPane userpane;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField pwsdUser;

    @FXML
    private JFXPasswordField pwsdConfirm;

    @FXML
    private JFXButton btnSave;

    private UserAccountService userAccountService;

    @FXML
    void confirmAction(ActionEvent event) {

    }

    @FXML
    void passwordAction(ActionEvent event) {

    }

    @FXML
    void saveAction(MouseEvent event) throws Exception {
        boolean save = userAccountService.save(new UserAccountDTO(txtUserName.getText(),pwsdUser.getText(),pwsdConfirm.getText()));
        if(save){
            Alert add = new Alert(Alert.AlertType.CONFIRMATION,"User Added", ButtonType.OK);
            add.showAndWait();
            Window window = userpane.getScene().getWindow();
            ((Stage)window).close();
        }else {
            Alert er = new Alert(Alert.AlertType.ERROR,"User Not Add",ButtonType.OK);
            er.show();
        }

    }

    @FXML
    void userNameAction(ActionEvent event) {

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            userAccountService= (UserAccountService) Naming.lookup("rmi://localhost:8080/userAccount");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}
