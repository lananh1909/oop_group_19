package com.controller;

import com.dao_impl.StockSum;
import com.modelDataCK.StockModel;
import com.process.ProcessChart;
import com.sentences.DayFollowSentence;
import com.service.IProcessSentence;
import com.service_impl.ProcessSentence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.*;


public class ControllerFX implements Initializable {
    @FXML private TextField stockCode;

    @FXML private TextArea content;

    @FXML private Button choiceBox;

    @FXML
    ComboBox<String> comboBoxDate;

    @FXML
    ComboBox<String> comboBoxFloor;

    @FXML
    ComboBox<String> comboBoxVocation;

    @FXML
    LineChart<String, Double> lineChart;

    ObservableList<String> list = FXCollections.observableArrayList("5/21/2020", "5/22/2020", "5/23/2020",
            "5/24/2020", "5/25/2020", "5/26/2020", "5/27/2020");

    ObservableList<String> list1 = FXCollections.observableArrayList("HNX30","HNXCON","HNXFIN", "HNXLCAP",
            "HNXMAN", "HNXMSCAP", "VN30", "VN100", "VNALL", "VNMID", "VNSI", "VNSML", "VNX50", "HOSE");

    ObservableList<String> list2 = FXCollections.observableArrayList("TOP 10 cổ phiếu", "Tăng cao nhất",
            "Giảm sâu nhất", "Đứng giá", "Giao dịch lớn nhất");

    public void Submit(ActionEvent event){
        lineChart.getData().clear();
        if(!stockCode.getText().equals("")){
            lineChart.getData().add(new ProcessChart().drawChart(stockCode.getText()));
        }

        String code = stockCode.getText();
        String floor = comboBoxFloor.getValue();
        String date = comboBoxDate.getValue();
        String day = null;
        StringBuilder sentences = new StringBuilder();
        if(date != null){
            String [] arrayDate = date.split("/");
            day = arrayDate[1];
            List<StockModel> stocList = new ArrayList<>();
            stocList = new StockSum().sumList(day);
            Set<StockModel> stockModelSet = new HashSet<>(stocList);
            for(StockModel para : stockModelSet){
                if (para.getStockCode().equalsIgnoreCase(code)){
                    sentences.append(new DayFollowSentence(para).createSentence(date));
                }
            }
        }

        if(date != null && floor != null){
            IProcessSentence processSentence = new ProcessSentence();
            String listSentence;
            listSentence = processSentence.listSentence(day, floor);

          {
              content.setText(sentences.toString());
            }
        }
        else content.setText("NOTHING");
    }


    public void onKeyPress(KeyEvent keyEvent){
        choiceBox.setRotate(choiceBox.getRotate() + 1);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxDate.setItems(list);
        comboBoxFloor.setItems(list1);
        comboBoxVocation.setItems(list2);
    }
}
