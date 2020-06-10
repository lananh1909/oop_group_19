package com.process;

import com.modeldatack.TotalDataHNXModel;
import com.modeldatack.TotalDataHOSEModel;
import com.service_impl.StockService;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class ProcessChartIndex {
    XYChart.Series<String, Double> series = new XYChart.Series<>();

    public XYChart.Series<String, Double> drawChartIndex(String floor){

        if(floor.contains("HNX") || floor.contains("UPCOM")){
            List<TotalDataHNXModel> dataHNXModels = new ArrayList<>();
            dataHNXModels = new StockService().getIndexHNXAllDayOfFloor(floor);

            XYChart.Data<String, Double> day1 = new XYChart.Data<>("21", dataHNXModels.get(0).getExchangeValue());
            XYChart.Data<String, Double> day2 = new XYChart.Data<>("22", dataHNXModels.get(1).getExchangeValue());
            XYChart.Data<String, Double> day3 = new XYChart.Data<>("23", dataHNXModels.get(2).getExchangeValue());
            XYChart.Data<String, Double> day4 = new XYChart.Data<>("24", dataHNXModels.get(3).getExchangeValue());
            XYChart.Data<String, Double> day5 = new XYChart.Data<>("25", dataHNXModels.get(4).getExchangeValue());
            XYChart.Data<String, Double> day6 = new XYChart.Data<>("26", dataHNXModels.get(5).getExchangeValue());
            XYChart.Data<String, Double> day7 = new XYChart.Data<>("27", dataHNXModels.get(6).getExchangeValue());

            series.getData().addAll(day1, day2, day3, day4, day5, day6, day7);
            series.setName("Index Chart");
            return series;
        }
        else{
            List<TotalDataHOSEModel> dataModels = new ArrayList<>();
            dataModels = new StockService().getIndexNotHNXAllDayOfFloor(floor);


            XYChart.Data<String, Double> day1 = new XYChart.Data<>("21", dataModels.get(0).getExchangeValue3());
            XYChart.Data<String, Double> day2 = new XYChart.Data<>("22", dataModels.get(1).getExchangeValue3());
            XYChart.Data<String, Double> day3 = new XYChart.Data<>("23", dataModels.get(2).getExchangeValue3());
            XYChart.Data<String, Double> day4 = new XYChart.Data<>("24", dataModels.get(3).getExchangeValue3());
            XYChart.Data<String, Double> day5 = new XYChart.Data<>("25", dataModels.get(4).getExchangeValue3());
            XYChart.Data<String, Double> day6 = new XYChart.Data<>("26", dataModels.get(5).getExchangeValue3());
            XYChart.Data<String, Double> day7 = new XYChart.Data<>("27", dataModels.get(6).getExchangeValue3());

            series.getData().addAll(day1, day2, day3, day4, day5, day6, day7);
            series.setName("Index Chart");
            return series;
        }
    }
}
