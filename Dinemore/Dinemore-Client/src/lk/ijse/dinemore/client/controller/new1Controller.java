package lk.ijse.dinemore.client.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;

public class new1Controller {

    @FXML
    private Button btnadd;

    @FXML
    void add(ActionEvent event) {

        System.out.println("customer added");
    }

}
