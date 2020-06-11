package com.controller;

import com.dao_impl.StockSum;
import com.modeldatack.StockModel;
import com.modeldatack.TotalDataHNXModel;
import com.modeldatack.TotalDataHOSEModel;
import com.process.ProcessChartIndex;
import com.sentences.AppendSentences;
import com.service_impl.StockService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerFLoor extends GenericController implements Initializable {
    @FXML
    private Button hnxButton;

    @FXML
    private Button vn30Button;

    @FXML
    private Button hnx30Button;

    @FXML
    private Button hoseButton;

    @FXML
    private ComboBox<String> comboBoxDate;

    @FXML
    private TextArea contentFloor;

    @FXML
    LineChart<String, Double> lineChart;

    private String day = null;

    public void SubmitButtonHNX(ActionEvent event){

        contentFloor.clear();
        String floor = hnxButton.getText();

        // delete before chart
        lineChart.getData().clear();

        lineChart.setCreateSymbols(false);

        lineChart.getData().add(new ProcessChartIndex().drawChartIndex(floor));
        if(comboBoxDate.getValue() != null){
            String [] arrayDay = comboBoxDate.getValue().split("/");
            day = arrayDay[1] + arrayDay[0];
            try {

                TotalDataHNXModel dataHNXModel = new TotalDataHNXModel(day);

                List<StockModel> stockModelList = new StockService().getDataOneDayOfExchange(day, floor);

                dataHNXModel = new StockSum().sumIndexHNX(day).get(0);

                contentFloor.setText(new AppendSentences(dataHNXModel, stockModelList).addSentencesToHNXSB());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            contentFloor.setText("Bạn chưa chọn ngày!");
        }
    }

    public void SubmitButtonHnx30(ActionEvent event){

        String floor = hnx30Button.getText();

        // delete before chart
        lineChart.getData().clear();
        lineChart.setCreateSymbols(false);

        lineChart.getData().add(new ProcessChartIndex().drawChartIndex(floor));
        if(comboBoxDate.getValue() != null){
            String [] arrayDay = comboBoxDate.getValue().split("/");
            day = arrayDay[1] + arrayDay[0];

            TotalDataHNXModel dataHNX30Model = new TotalDataHNXModel(day);
            List<StockModel> stockModelList = new StockService().getDataOneDayOfExchange(day, floor);

            try {
                dataHNX30Model = new StockSum().sumIndexHNX(day).get(1);

                contentFloor.setText(new AppendSentences(dataHNX30Model, stockModelList).addSentencesToHNXSB());

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else {
            contentFloor.setText("Bạn chưa chọn ngày!");
        }
    }

    public void SubmitButtonVn30(ActionEvent event){

        String floor = vn30Button.getText();

        // delete before chart
        lineChart.getData().clear();
        lineChart.setCreateSymbols(false);

        lineChart.getData().add(new ProcessChartIndex().drawChartIndex(floor));
        if(comboBoxDate.getValue() != null){
            String [] arrayDay = comboBoxDate.getValue().split("/");
            day = arrayDay[1] + arrayDay[0];

            TotalDataHOSEModel dataModel = new TotalDataHOSEModel(day);
            List<StockModel> stockModelList = new StockService().getDataOneDayOfExchange(day, floor);

            try {
                dataModel = new StockSum().sumIndexNotHNX(day).get(1);
                contentFloor.setText(new AppendSentences(dataModel, stockModelList).addSentencesToHoseSB());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            contentFloor.setText("Bạn chưa chọn ngày!");
        }
    }

    public void SubmitButtonHose(ActionEvent event){

        contentFloor.clear();

        String floor = hoseButton.getText();

        // delete before chart
        lineChart.getData().clear();
        lineChart.setCreateSymbols(false);

        lineChart.getData().add(new ProcessChartIndex().drawChartIndex(floor));
        if(comboBoxDate.getValue() != null){
            String [] arrayDay = comboBoxDate.getValue().split("/");
            day = arrayDay[1] + arrayDay[0];

            TotalDataHOSEModel dataModel = new TotalDataHOSEModel(day);
            List<StockModel> stockModelList = new StockService().getDataOneDayOfExchange(day, floor);

            try {
                dataModel = new StockSum().sumIndexNotHNX(day).get(0);

                contentFloor.setText(new AppendSentences(dataModel, stockModelList).addSentencesToHoseSB());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            contentFloor.setText("Bạn chưa chọn ngày!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxDate.setItems(listDay);
    }
}