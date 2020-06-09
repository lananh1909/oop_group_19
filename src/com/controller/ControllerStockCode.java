package com.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStockCode extends GenericController implements Initializable {

    @FXML
    private ComboBox<String> comboBoxFloor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxFloor.setItems(list1);
    }
}
