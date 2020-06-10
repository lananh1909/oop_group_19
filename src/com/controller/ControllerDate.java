package com.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDate extends GenericController implements Initializable {
    @FXML
    private ComboBox<String> date;

    @FXML
    private ComboBox<String> floor;

    @FXML
    private TextField stockCode;

    @FXML
    private TextArea contentFollowDay;


    public void submitButton(ActionEvent event){

        String day = date.getValue();
        String floor1 = floor.getValue();

        if(day == null && floor1 == null){

        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        date.setItems(listDay);
        floor.setItems(list1);
    }
}
