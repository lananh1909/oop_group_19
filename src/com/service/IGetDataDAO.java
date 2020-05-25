package com.service;

import com.modelDataCK.StockModel;

import java.util.List;

public interface IGetDataDAO {
    List<StockModel> getDataToList(String file);

    String [] getDataToArray(String line);

}
