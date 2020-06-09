package com.service;

import com.modelDataCK.StockModel;
import com.modelDataCK.TotalDataHNXModel;
import com.modelDataCK.TotalDataHOSEModel;

import java.util.List;

public interface IStockService {
    List<StockModel> getDataOneDayOfCode(String date, String floor);

    List<TotalDataHNXModel> getIndexHNXAllDayOfFloor(String floor);

    List<TotalDataHOSEModel> getIndexNotHNXAllDayOfFloor(String floor);
}
