package com.dao;

import com.modeldatack.StockModel;
import com.modeldatack.TotalDataHNXModel;
import com.modeldatack.TotalDataHOSEModel;

import java.io.IOException;
import java.util.List;

public interface IStockSum {
    List<StockModel> sumList(String date, String floor) throws IOException;
    List<TotalDataHNXModel> sumIndexHNX(String date) throws IOException;
    List<TotalDataHOSEModel> sumIndexNotHNX(String date) throws IOException;
    List<StockModel> sumListOfExchange(String date, String floor);
}
