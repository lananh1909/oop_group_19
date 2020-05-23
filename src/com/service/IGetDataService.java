package com.service;

import com.modelDataCK.StockModel;
import com.modelDataCK.TotalDataModel;

import java.io.File;
import java.util.List;

public interface IGetDataService {
    List<StockModel> getDataToList(File file);
//    TotalDataModel getDataToObject();
    String [] getDataToArray(String line);
}
