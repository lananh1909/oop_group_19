package com.mapper;

import com.mapper.IStockMapper;
import com.modelDataCK.StockModel;

public class StockMapper extends GernericMapper implements IStockMapper {
    @Override
    public StockModel mapper(String line) {
        return getStockModel(line);
    }

}
