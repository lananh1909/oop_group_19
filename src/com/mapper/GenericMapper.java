package com.mapper;

import com.modelDataCK.StockModel;

public class GernericMapper {

    public StockModel getStockModel(String line) {
        StockModel stock = new StockModel();
        String [] data = line.split("\\t");
        stock.setStockCode(data[0]);
        stock.setCeiling(Double.parseDouble(data[1]));
        stock.setFloor(Double.parseDouble(data[2]));
        stock.setReference(Double.parseDouble(data[3]));
        stock.setOverBuyingPrice3(Double.parseDouble(data[4]));
        stock.setMassOverBuying3(Double.parseDouble(data[5]));
        stock.setOverBuyingPrice2(Double.parseDouble(data[6]));
        stock.setMassOverBuying2(Double.parseDouble(data[7]));
        stock.setOverBuyingPrice1(Double.parseDouble(data[8]));
        stock.setMassOverBuying1(Double.parseDouble(data[9]));
        stock.setOrderMatchingInOrDe(Double.parseDouble(data[10]));
        stock.setPercent(Double.parseDouble(data[11]));
        stock.setPrice(Double.parseDouble(data[12]));
        stock.setMassOrderMatching(Double.parseDouble(data[13]));
        stock.setSumOrderMatchingMass(Double.parseDouble(data[14]));
        stock.setOversoldPrice1(Double.parseDouble(data[15]));
        stock.setMassOversold1(Double.parseDouble(data[16]));
        stock.setOversoldPrice2(Double.parseDouble(data[17]));
        stock.setMassOversold2(Double.parseDouble(data[18]));
        stock.setOversoldPrice3(Double.parseDouble(data[19]));
        stock.setMassOversold3(Double.parseDouble(data[20]));
        stock.setOpenHistory(Double.parseDouble(data[21]));
        stock.setPriceCostlyHistory(Double.parseDouble(data[22]));
        stock.setPriceLowHistory(Double.parseDouble(data[23]));
        stock.setBuyForeign(Double.parseDouble(data[24]));
        stock.setSellForeign(Double.parseDouble(data[25]));
        stock.setRoomNN(Double.parseDouble(data[26]));
        return stock;
    }
}
