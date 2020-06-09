package com.controller;

import com.sun.org.apache.xml.internal.security.Init;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDate extends GenericController implements Initializable {
    @FXML
    private ComboBox<String> date;

    @FXML
    private ComboBox<String> floor;

    @FXML
    private TextArea stockCode;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        date.setItems(listDay);
        floor.setItems(list1);
    }
}
