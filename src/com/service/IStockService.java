package com.service;

import com.modeldatack.StockModel;
import com.modeldatack.TotalDataHNXModel;
import com.modeldatack.TotalDataHOSEModel;

import java.util.List;

public interface IStockService {
    List<StockModel> getDataOneDayOfCode(String date, String floor);

    List<TotalDataHNXModel> getIndexHNXAllDayOfFloor(String floor);

    List<TotalDataHOSEModel> getIndexNotHNXAllDayOfFloor(String floor);

    List<StockModel> getDataAllDayOfStockCode(String code, String floor);
}
