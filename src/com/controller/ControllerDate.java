package com.controller;

import com.dao_impl.StockSum;
import com.modeldatack.StockModel;
import com.sentences.exchangeOnDay.NNmua;
import com.sentences.stockCodeOnDay.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
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

    @FXML
    private Label notify;


    public void submitButton(ActionEvent event){

        StockModel st = new StockModel();

        String day = date.getValue();
        String floor1 = floor.getValue();
        String codest = stockCode.getText();



        StringBuilder stringBuilder = new StringBuilder();


        if(day == null || floor1 == null || codest.equals("")){
            notify.setText("Xin hãy nhập đầy đủ thông tin để hiển thị thông tin chứng khoán!!");
            contentFollowDay.setText("Nothing!!");
        }

        if(day != null && floor1 != null && !codest.equals("")){

            String [] arrayDay =day.split("/");
            String day1 = arrayDay[1] + arrayDay[0];
            List<StockModel> list = new StockSum().sumListOfExchange(day1, floor1);
            for(StockModel stm : list){
                if(stm.getStockCode().equalsIgnoreCase(codest)){
                    st = stm;
                    break;
                }
            }
            if(st.getDate() != null){

                stringBuilder.append(new TranSanThamChieu(st).createSentence()).append("\n");
                stringBuilder.append(new CaoNhatThapNhat(st).createSentence()).append("\n");
                stringBuilder.append(new GiaBanTot(st).createSentence()).append("\n");
                stringBuilder.append(new GiaMuaTot(st).createSentence()).append("\n");
                stringBuilder.append(new DatMuaDatBan(st).createSentence()).append("\n");
                stringBuilder.append(new NNMuaBan(st).createSentence());

                contentFollowDay.setText(stringBuilder.toString());
            } else {
                contentFollowDay.setText("Mã không hợp lệ!!");
            }
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        date.setItems(listDay);
        floor.setItems(list1);
    }
}
