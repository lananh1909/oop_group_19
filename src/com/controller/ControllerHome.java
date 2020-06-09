package com.controller;

import com.modelDataCK.StockModel;
import com.service_impl.StockService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerHome extends GenericController implements Initializable {
    @FXML
    private TableView<StockModel> stockTable;

    @FXML
    private TableColumn<StockModel, String> stockColumn;

    @FXML
    private TableColumn<StockModel, Double> ceilingColumn;

    @FXML
    private TableColumn<StockModel, Double> floorColumn;

    @FXML
    private TableColumn<StockModel, Double> referenceColumn;

    @FXML
    private TableColumn<StockModel, Double> sumMassColumn;

    @FXML
    private TableColumn<StockModel, Double> priceColumn;

    @FXML
    private TableColumn<StockModel, Double> nnBuyColumn;

    @FXML
    private TableColumn<StockModel, Double> nnSellColumn;

    @FXML
    private TableColumn<StockModel, Double> roomColumn;

    @FXML
    private ComboBox<String> comboBoxDay;

    @FXML
    private ComboBox<String> comboBoxFloor;

    ObservableList<String> listDay = FXCollections.observableArrayList("5/21/2020", "5/22/2020", "5/23/2020",
            "5/24/2020", "5/25/2020", "5/26/2020", "5/27/2020");

    ObservableList<String> list1 = FXCollections.observableArrayList("HNX30", "VN30", "VN100", "VNX50", "HOSE");



    public void handlButoonActionFloor(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/floor.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Floor Table");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handlButoonActionDate(ActionEvent event) {
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("../view/date.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader2.load();
            Stage stage = new Stage();
            stage.setTitle("Floor Table");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboBoxDay.setItems(listDay);
        comboBoxFloor.setItems(list1);

        stockColumn.setCellValueFactory(new PropertyValueFactory<StockModel, String>("stockCode"));
        ceilingColumn.setCellValueFactory(new PropertyValueFactory<StockModel, Double>("ceiling"));
        floorColumn.setCellValueFactory(new PropertyValueFactory<StockModel, Double>("floor"));
        referenceColumn.setCellValueFactory(new PropertyValueFactory<StockModel, Double>("reference"));
        sumMassColumn.setCellValueFactory(new PropertyValueFactory<StockModel, Double>("sumOrderMatchingMass"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<StockModel, Double>("price"));
        nnBuyColumn.setCellValueFactory(new PropertyValueFactory<StockModel, Double>("buyForeign"));
        nnSellColumn.setCellValueFactory(new PropertyValueFactory<StockModel, Double>("sellForeign"));
        roomColumn.setCellValueFactory(new PropertyValueFactory<StockModel, Double>("RoomNN"));

        stockTable.setItems(getStockModel());
    }



    // lấy ra danh sách observableList các đối tượng stockModel
    public ObservableList<StockModel> getStockModel(){
        ObservableList<StockModel> stockModels = FXCollections.observableArrayList();
        List<StockModel> stockModelList = new ArrayList<>();
        stockModelList = new StockService().getDataOneDayOfCode("2105");
        for(StockModel st : stockModelList){
            stockModels.add(st);
        }
        return stockModels;
    }

    public void buttonSearch(ActionEvent event){
        String [] arrayDay = comboBoxDay.getValue().split("/");
        String date = arrayDay[1] + arrayDay[0];
    }
}

