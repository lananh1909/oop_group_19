package com.view;

import com.modelDataCK.TotalDataHNXModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerFX implements Initializable {
    @FXML private TextField date;

    @FXML private TextField content;

    private TotalDataHNXModel dataHNXModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        content.setText("Chứng khoán ngày today");
    }
}
