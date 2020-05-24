package com.mapper;

import com.mapper.IStockMapper;
import com.modelDataCK.StockModel;

public class StockMapper extends GenericMapper implements IStockMapper {
    @Override
    public StockModel mapper(String line) {
        return getStockModel(line);
    }

}
