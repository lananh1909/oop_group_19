package com.dao_impl;

import com.mapper.IStockMapper;
import com.mapper.StockMapper;
import com.modeldatack.StockModel;
import com.modeldatack.TotalDataHNXModel;
import com.modeldatack.TotalDataHOSEModel;
import com.dao.IGetDataDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDataDAO implements IGetDataDAO {

    private BufferedReader bf;
    
    @Override
    public List<StockModel> getDataToList(String file) {
        int start = file.indexOf("-") + 1;
        int end = file.indexOf(".");
        String date = file.substring(start, end);
        List<StockModel> stockList = new ArrayList<>();
        String line;
        IStockMapper stockMapper = null;

        try {
            bf = new BufferedReader(new FileReader(file));
            int count = 0;

            if(file.contains("HNX")) {
                while ((line = bf.readLine()) != null) {
                    if(count > 3){
                        stockMapper = new StockMapper();
                        stockList.add(stockMapper.mapper(line, date));
                    }
                    count++;
                }
            }
            else {
                while ((line = bf.readLine()) != null){
                    if(count > 5){
                        stockMapper = new StockMapper();
                        stockList.add(stockMapper.mapper(line, date));
                    }
                    count ++;
                }
            }
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

    @Override
    public TotalDataHNXModel getDataToHNX(String file) throws IOException {
    	int start = file.indexOf("-") + 1;
        int end = file.indexOf(".");
        String date = file.substring(start, end);
        TotalDataHNXModel dataHNXModel = new TotalDataHNXModel(date);
        String line;
        int count = 0;
        try{
            bf = new BufferedReader(new FileReader(file));
            if(file.contains("HNX") || file.contains("UPCOM")){
                while ((line = bf.readLine()) != null){
                    switch (count) {
                        case 0:
                            dataHNXModel.setNameExchange(line);
                            break;
                        case 1:
                            dataHNXModel.setIndex(Double.parseDouble(line));
                            break;
                        case 2:
                            dataHNXModel.setIncreaseAndDecrease(Double.parseDouble(getDataToArray(line)[0]));
                            dataHNXModel.setPercentIncreaseAndDecrease(Double.parseDouble(getDataToArray(line)[1]));
                            break;
                        case 3:
                            dataHNXModel.setExchangeValue(Double.parseDouble(getDataToArray(line)[1]));
                            dataHNXModel.setExchangeMass(Double.parseDouble(getDataToArray(line)[0]));
                            break;
//                        default: bf.close();
                    }
                    count ++;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            bf.close();
        }
        return dataHNXModel;
    }

    @Override
    public TotalDataHOSEModel getDataToModel(String file) throws IOException {
    	int start = file.indexOf("-") + 1;
        int end = file.indexOf(".");
        String date = file.substring(start, end);
        TotalDataHOSEModel dataModel = new TotalDataHOSEModel(date);
        String line;
        int count = 0;
        try{
            bf = new BufferedReader(new FileReader(file));
            if(!file.contains("HNX")){
                while ((line = bf.readLine()) != null){
                    switch (count) {
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
                            dataModel.setExchangeMass1(Double.parseDouble(getDataToArray(line)[2]));
                            dataModel.setExchangeValue1(Double.parseDouble(getDataToArray(line)[3]));
                            break;
                        case 4:
                            dataModel.setIndex2(Double.parseDouble(getDataToArray(line)[0]));
                            dataModel.setIncreAndDecre2(Double.parseDouble(getDataToArray(line)[1]));
                            dataModel.setExchangeMass2(Double.parseDouble(getDataToArray(line)[2]));
                            dataModel.setExchangeValue2(Double.parseDouble(getDataToArray(line)[3]));
                            break;
                        case 5:
                            dataModel.setIndex3(Double.parseDouble(getDataToArray(line)[0]));
                            dataModel.setIncreAndDecre3(Double.parseDouble(getDataToArray(line)[1]));
                            dataModel.setExchangeMass3(Double.parseDouble(getDataToArray(line)[2]));
                            dataModel.setExchangeValue3(Double.parseDouble(getDataToArray(line)[3]));
                            break;
                    }
                    count ++;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            bf.close();
        }
        return dataModel;
    }
}
