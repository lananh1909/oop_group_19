package com.mapper;

import com.modelDataCK.StockModel;

public interface IStockMapper {
    StockModel mapper(String line, String date);
}
