package com.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStockCode extends GenericController implements Initializable {

    @FXML
    private ComboBox<String> comboBoxFloor;

    @FXML
    private TextField code;

    @FXML
    private Label contentNotify;

    @FXML
    private TextArea contentCode;


    public void buttonSearch(ActionEvent event){

        String floor = comboBoxFloor.getValue();
        String stockCode = code.getText();

        if(floor != null && stockCode.equals("")){
            contentCode.setText("Nothing!!");
        }

        if (floor == null && stockCode.equals("")){
            contentNotify.setText("Hãy lựa mã chứng khoán để có được thông tin rõ nhất!");
            StringBuilder stringBuilder = new StringBuilder();
            contentCode.setText(stringBuilder.append("hello").toString());
        }

        if(floor != null && !stockCode.equals("")){

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxFloor.setItems(list1);
    }
}
