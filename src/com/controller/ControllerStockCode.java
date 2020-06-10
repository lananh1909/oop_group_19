package com.controller;

import com.modeldatack.StockModel;
import com.sentences.stockCodeExchangeByDay.*;
import com.service.IStockService;
import com.service_impl.StockService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

            List<StockModel> list = new ArrayList<>();
            list = new StockService().getDataAllDayOfStockCode(stockCode, floor);

            StringBuilder stringBuilder = new StringBuilder();

            if(list != null){

                stringBuilder.append(new CacNgayGiam(list).createSentence());
                stringBuilder.append(new DaoDongGia(list).createSentence());
                stringBuilder.append(new GiaTangManh(list).createSentence());
                stringBuilder.append(new GiaRotManh(list).createSentence());
                stringBuilder.append(new DungGiaThamChieu(list).createSentence());
                stringBuilder.append(new TangLienTiep(list).createSentence());
                stringBuilder.append(new GiamLienTiep(list).createSentence());
                stringBuilder.append(new KhopLenhTrongTuan(list).createSentence());
                stringBuilder.append(new RoomNN(list).createSentence());

                contentCode.setText(stringBuilder.toString());

            }
            else {
                contentCode.setText("nothing!");
            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxFloor.setItems(list1);
    }
}
