package com.mapper;

import com.mapper.IStockMapper;
import com.modelDataCK.StockModel;

public class StockMapper extends GenericMapper implements IStockMapper {
    @Override
    public StockModel mapper(String line, String date) {
        return getStockModel(line, date);
    }
}
