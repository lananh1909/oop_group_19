package com.mapper;

import com.modelDataCK.StockModel;

public class StockMapperHNX extends GenericMapper implements IStockMapper{
	@Override
    public StockModel mapper(String line, String date) {
        return getStockModelHNX(line, date);
    }
}
