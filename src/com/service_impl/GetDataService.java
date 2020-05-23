package com.service_impl;

import com.mapper.IStockMapper;
import com.mapper.StockMapper;
import com.modelDataCK.StockModel;
import com.modelDataCK.TotalDataModel;
import com.service.IGetDataService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDataService implements IGetDataService {

    private BufferedReader bf;
    private TotalDataModel dataModel;

    public TotalDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(TotalDataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public List<StockModel> getDataToList(File file) {
        List<StockModel> stockList = new ArrayList<>();
        String line;
        IStockMapper stockMapper = null;

        try {
            bf = new BufferedReader(new FileReader(file));
            dataModel = new TotalDataModel();
            int count = 0;
            while ((line = bf.readLine()) != null){
                switch (count){
                    case 0:
                        dataModel.setNameExchange(line);
                        break;
                    case 1:
                        dataModel.setIndex(Double.parseDouble(line));
                        break;
                    case 2:
                        dataModel.setIncreaseAndDecrease(Double.parseDouble(getDataToArray(line)[0]));
                        dataModel.setPercentIncreaseAndDecrease(Double.parseDouble(getDataToArray(line)[1]));
                        break;
                    case 3:
                        dataModel.setIndex1(Double.parseDouble(getDataToArray(line)[0]));
                        dataModel.setIncreAndDecre1(Double.parseDouble(getDataToArray(line)[1]));
                        dataModel.setPercentIncreAndDecre1(Double.parseDouble(getDataToArray(line)[2]));
                        dataModel.setData1(Double.parseDouble(getDataToArray(line)[3]));
                        break;
                    case 4:
                        dataModel.setIndex2(Double.parseDouble(getDataToArray(line)[0]));
                        dataModel.setIncreAndDecre2(Double.parseDouble(getDataToArray(line)[1]));
                        dataModel.setPercentIncreAndDecre2(Double.parseDouble(getDataToArray(line)[2]));
                        dataModel.setData2(Double.parseDouble(getDataToArray(line)[3]));
                        break;
                    case 5:
                        dataModel.setIndex3(Double.parseDouble(getDataToArray(line)[0]));
                        dataModel.setIncreAndDecre3(Double.parseDouble(getDataToArray(line)[1]));
                        dataModel.setPercentIncreAndDecre3(Double.parseDouble(getDataToArray(line)[2]));
                        dataModel.setData3(Double.parseDouble(getDataToArray(line)[3]));
                        break;
                }
                if(count > 5){
                    stockMapper = new StockMapper();
                    stockList.add(stockMapper.mapper(line));
                }
                count ++;
            }
//            System.out.println(stockList.size());
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(bf != null){
                    bf.close();
                }
            } catch (IOException e){
                e.getMessage();
            }
        }
        return stockList;
    }

    @Override
    public String[] getDataToArray(String line) {
        String [] lineArray = line.split("\\t");
        return lineArray;
    }
}
