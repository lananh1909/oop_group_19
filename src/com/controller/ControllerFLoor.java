package com.controller;

import com.dao_impl.StockSum;
<<<<<<< HEAD
import com.modeldatack.StockModel;
import com.modeldatack.TotalDataHNXModel;
=======
import com.modelDataCK.StockModel;
import com.modelDataCK.TotalDataHNXModel;
import com.modelDataCK.TotalDataHOSEModel;
>>>>>>> f0bf2a621e3247872b63e46b4e500a1dc8c9a1ef
import com.process.ProcessChartIndex;
import com.sentences.exchangeOnDay.*;
import com.sentences.indexOfExChange.HNXmodau;
import com.sentences.indexOfExChange.phien1;
import com.service_impl.ProcessSentence;
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
    private Button upcomButton;

    @FXML
    private ComboBox<String> comboBoxDate;

    @FXML
    private TextArea contentFloor;

    @FXML
    LineChart<String, Double> lineChart;

//    ObservableList<String> list = FXCollections.observableArrayList("05/21/2020", "05/22/2020", "05/23/2020",
//            "05/24/2020", "05/25/2020", "05/26/2020", "05/27/2020");

    private String day = null;

    public void SubmitButtonHNX(ActionEvent event){

        StringBuilder sentences = new StringBuilder();
        contentFloor.clear();
        String floor = hnxButton.getText();


        // delete before chart
        lineChart.getData().clear();

        lineChart.setCreateSymbols(false);

        lineChart.getData().add(new ProcessChartIndex().drawChartIndex(floor));
        if(comboBoxDate.getValue() != null){
            String [] arrayDay = comboBoxDate.getValue().split("/");
            day = arrayDay[1] + arrayDay[0];
            sentences.append(new ProcessSentence().listSentence(day, floor)).toString();
            try {

                TotalDataHNXModel dataHNXModel = new TotalDataHNXModel(day);

                List<StockModel> stockModelList = new StockSum().sumListOfExchange(day, floor);

                dataHNXModel = new StockSum().sumIndexHNX(day).get(0);

                sentences.append(new HNXmodau (dataHNXModel).createSentence());

                sentences.append("\n");

                sentences.append(new ColorOfExchange(stockModelList, dataHNXModel).createSentence());

                sentences.append(new DiemSang(stockModelList).createSentence()).toString();

                sentences.append(new TangVotGiamManh(stockModelList, dataHNXModel).createSentence()).toString();
                 sentences.append(new KhoiLuongGiaoDichLon(stockModelList).createSentence()).toString();

                sentences.append(new MaGiaBanCao(stockModelList).createSentence()).toString();
                sentences.append(new TDGiaCaoNhat(stockModelList).createSentence());
                sentences.append("\n");
                String cont = sentences.append(new NNBan(stockModelList).createSentence()).append(new NNmua(stockModelList).createSentence()).append(new RoomNNcao(stockModelList).createSentence()).toString();
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
        String floor = hnx30Button.getText();

        // delete before chart
        lineChart.getData().clear();

        lineChart.getData().add(new ProcessChartIndex().drawChartIndex(floor));
        if(comboBoxDate.getValue() != null){
            String [] arrayDay = comboBoxDate.getValue().split("/");
            day = arrayDay[1] + arrayDay[0];
            sentences.append(new ProcessSentence().listSentence(day, floor));
            
            TotalDataHNXModel dataHNX30Model = new TotalDataHNXModel(day);
            List<StockModel> stockModelList = new StockSum().sumListOfExchange(day, floor);

            try {
				dataHNX30Model = new StockSum().sumIndexHNX(day).get(1);
				
				sentences.append(new HNXmodau (dataHNX30Model).createSentence());

	            sentences.append("\n");

	            sentences.append(new ColorOfExchange(stockModelList, dataHNX30Model).createSentence());

	            sentences.append(new DiemSang(stockModelList).createSentence()).toString();

	            sentences.append(new TangVotGiamManh(stockModelList, dataHNX30Model).createSentence()).toString();
	             sentences.append(new KhoiLuongGiaoDichLon(stockModelList).createSentence()).toString();

	            sentences.append(new MaGiaBanCao(stockModelList).createSentence()).toString();
	            sentences.append(new TDGiaCaoNhat(stockModelList).createSentence());
	            sentences.append("\n");
	            String cont = sentences.append(new NNBan(stockModelList).createSentence()).append(new NNmua(stockModelList).createSentence()).append(new RoomNNcao(stockModelList).createSentence()).toString();
	                    contentFloor.setText(cont);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
            String [] arrayDay = comboBoxDate.getValue().split("/");
            day = arrayDay[1] + arrayDay[0];
<<<<<<< HEAD
            sentences.append(new ProcessSentence().listSentence(day, floor));
            
            TotalDataHOSEModel dataModel = new TotalDataHOSEModel(day);
            
            try {
				dataModel = new StockSum().sumIndexNotHNX(day).get(1);

	            sentences.append(new phien1(dataModel).createSentence());
	            contentFloor.setText(sentences.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
=======
            sentences.append(new ProcessSentence().listSentence(day, floor)).toString();
            contentFloor.setText(sentences.toString());
>>>>>>> cf4a09c231d731de00f42434432183bb83e323ba
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
            String [] arrayDay = comboBoxDate.getValue().split("/");
            day = arrayDay[1] + arrayDay[0];
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
            String [] arrayDay = comboBoxDate.getValue().split("/");
            day = arrayDay[1] + arrayDay[0];
            sentences.append(new ProcessSentence().listSentence(day, floor));
            contentFloor.setText(sentences.toString());
        }
        else {
            contentFloor.setText("Nothing!!!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxDate.setItems(listDay);
    }
}
