package com.dao;

import com.modelDataCK.StockModel;

import java.io.IOException;
import java.util.List;

public interface IStockSum {
    List<StockModel> sumList(String date) throws IOException;
}
