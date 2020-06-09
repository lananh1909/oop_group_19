package com.mapper;

import com.modeldatack.StockModel;

public interface IStockMapper {
    StockModel mapper(String line, String date);
}
