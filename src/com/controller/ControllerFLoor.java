package com.controller;

import com.dao_impl.StockSum;
import com.process.ProcessChartIndex;
import com.sentences.indexOfExChange.HNXmodau;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFLoor implements Initializable {
    @FXML
    private Button hnxButton;

    @FXML
    private Button vn30Button;

    @FXML
    private Button hnx30Button;

    @FXML
    private Button hoseButton;

    @FXML
    private Button upcomButton;

    @FXML
    private ComboBox<String> comboBoxDate;

    @FXML
    private TextArea contentFloor;

    @FXML
    LineChart<String, Double> lineChart;

    ObservableList<String> list = FXCollections.observableArrayList("5/21/2020", "5/22/2020", "5/23/2020",
            "5/24/2020", "5/25/2020", "5/26/2020", "5/27/2020");

    private String day = null;

    public void SubmitButtonHNX(ActionEvent event){

        StringBuilder sentences = new StringBuilder();
        contentFloor.clear();
        String floor = hnxButton.getText();


        // delete before chart
        lineChart.getData().clear();

        lineChart.getData().add(new ProcessChartIndex().drawChartIndex(floor));
        if(comboBoxDate.getValue() != null){
            day = comboBoxDate.getValue().split("/")[1];
            sentences.append(new ProcessSentence().listSentence(day, floor)).toString();
            try {
                String cont =  sentences.append(new HNXmodau( (new StockSum().sumIndexHNX(day)).get(0)).createSentence()).toString();
                contentFloor.setText(cont);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            contentFloor.setText("Nothing!!!");
        }
    }

    public void SubmitButtonHnx30(ActionEvent event){


        StringBuilder sentences = new StringBuilder();
        String floor = vn30Button.getText();

        // delete before chart
        lineChart.getData().clear();

        lineChart.getData().add(new ProcessChartIndex().drawChartIndex(floor));
        if(comboBoxDate.getValue() != null){
            day = comboBoxDate.getValue().split("/")[1];
            sentences.append(new ProcessSentence().listSentence(day, floor));
            contentFloor.setText(sentences.toString());

        }
        else {
            contentFloor.setText("Nothing!!!");
        }
    }

    public void SubmitButtonVn30(ActionEvent event){


        StringBuilder sentences = new StringBuilder();
        String floor = vn30Button.getText();

        // delete before chart
        lineChart.getData().clear();

        lineChart.getData().add(new ProcessChartIndex().drawChartIndex(floor));
        if(comboBoxDate.getValue() != null){
            day = comboBoxDate.getValue().split("/")[1];
            sentences.append(new ProcessSentence().listSentence(day, floor));
            contentFloor.setText(sentences.toString());
        }
        else {
            contentFloor.setText("Nothing!!!");
        }
    }

    public void SubmitButtonHose(ActionEvent event){


        StringBuilder sentences = new StringBuilder();
        contentFloor.clear();

        String floor = hoseButton.getText();

        // delete before chart
        lineChart.getData().clear();

        lineChart.getData().add(new ProcessChartIndex().drawChartIndex(floor));
        if(comboBoxDate.getValue() != null){
            day = comboBoxDate.getValue().split("/")[1];
            sentences.append(new ProcessSentence().listSentence(day, floor));
            contentFloor.setText(sentences.toString());
        }
        else {
            contentFloor.setText("Nothing!!!");
        }
    }

    public void SubmitButtonUpcom(ActionEvent event){

        String floor = upcomButton.getText();


        StringBuilder sentences = new StringBuilder();
        // delete before chart
        lineChart.getData().clear();

        lineChart.getData().add(new ProcessChartIndex().drawChartIndex(floor));
        if(comboBoxDate.getValue() != null){
            day = comboBoxDate.getValue().split("/")[1];
            sentences.append(new ProcessSentence().listSentence(day, floor));
            contentFloor.setText(sentences.toString());
        }
        else {
            contentFloor.setText("Nothing!!!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxDate.setItems(list);
    }
}
