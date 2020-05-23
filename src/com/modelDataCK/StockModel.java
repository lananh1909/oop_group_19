package com.modelDataCK;

import java.io.File;
import java.io.Serializable;

public class StockModel implements Serializable {

    private String stockCode;
    private double ceiling;
    private double floor;
    private double reference;
    private double overBuyingPrice3;
    private double massOverBuying3;
    private double overBuyingPrice2;
    private double massOverBuying2;
    private double overBuyingPrice1;
    private double massOverBuying1;
    private double orderMatchingInOrDe;
    private double percent;
    private double price;
    private double massOrderMatching;
    private double sumOrderMatchingMass;
    private double oversoldPrice1;
    private double massOversold1;
    private double oversoldPrice2;
    private double massOversold2;
    private double oversoldPrice3;
    private double massOversold3;
    private double openHistory;
    private double priceCostlyHistory;
    private double priceLowHistory;
    private double buyForeign;
    private double sellForeign;
    private double RoomNN;

    public double getRoomNN() {
        return RoomNN;
    }

    public void setRoomNN(double roomNN) {
        RoomNN = roomNN;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public double getCeiling() {
        return ceiling;
    }

    public void setCeiling(double ceiling) {
        this.ceiling = ceiling;
    }

    public double getFloor() {
        return floor;
    }

    public void setFloor(double floor) {
        this.floor = floor;
    }

    public double getReference() {
        return reference;
    }

    public void setReference(double reference) {
        this.reference = reference;
    }

    public double getOverBuyingPrice3() {
        return overBuyingPrice3;
    }

    public void setOverBuyingPrice3(double overBuyingPrice3) {
        this.overBuyingPrice3 = overBuyingPrice3;
    }

    public double getMassOverBuying3() {
        return massOverBuying3;
    }

    public void setMassOverBuying3(double massOverBuying3) {
        this.massOverBuying3 = massOverBuying3;
    }

    public double getOverBuyingPrice2() {
        return overBuyingPrice2;
    }

    public void setOverBuyingPrice2(double overBuyingPrice2) {
        this.overBuyingPrice2 = overBuyingPrice2;
    }

    public double getMassOverBuying2() {
        return massOverBuying2;
    }

    public void setMassOverBuying2(double massOverBuying2) {
        this.massOverBuying2 = massOverBuying2;
    }

    public double getOverBuyingPrice1() {
        return overBuyingPrice1;
    }

    public void setOverBuyingPrice1(double overBuyingPrice1) {
        this.overBuyingPrice1 = overBuyingPrice1;
    }

    public double getMassOverBuying1() {
        return massOverBuying1;
    }

    public void setMassOverBuying1(double massOverBuying1) {
        this.massOverBuying1 = massOverBuying1;
    }

    public double getOrderMatchingInOrDe() {
        return orderMatchingInOrDe;
    }

    public void setOrderMatchingInOrDe(double orderMatchingInOrDe) {
        this.orderMatchingInOrDe = orderMatchingInOrDe;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMassOrderMatching() {
        return massOrderMatching;
    }

    public void setMassOrderMatching(double massOrderMatching) {
        this.massOrderMatching = massOrderMatching;
    }

    public double getSumOrderMatchingMass() {
        return sumOrderMatchingMass;
    }

    public void setSumOrderMatchingMass(double sumOrderMatchingMass) {
        this.sumOrderMatchingMass = sumOrderMatchingMass;
    }

    public double getOversoldPrice1() {
        return oversoldPrice1;
    }

    public void setOversoldPrice1(double oversoldPrice1) {
        this.oversoldPrice1 = oversoldPrice1;
    }

    public double getMassOversold1() {
        return massOversold1;
    }

    public void setMassOversold1(double massOversold1) {
        this.massOversold1 = massOversold1;
    }

    public double getOversoldPrice2() {
        return oversoldPrice2;
    }

    public void setOversoldPrice2(double oversoldPrice2) {
        this.oversoldPrice2 = oversoldPrice2;
    }

    public double getMassOversold2() {
        return massOversold2;
    }

    public void setMassOversold2(double massOversold2) {
        this.massOversold2 = massOversold2;
    }

    public double getOversoldPrice3() {
        return oversoldPrice3;
    }

    public void setOversoldPrice3(double oversoldPrice3) {
        this.oversoldPrice3 = oversoldPrice3;
    }

    public double getMassOversold3() {
        return massOversold3;
    }

    public void setMassOversold3(double massOversold3) {
        this.massOversold3 = massOversold3;
    }

    public double getOpenHistory() {
        return openHistory;
    }

    public void setOpenHistory(double openHistory) {
        this.openHistory = openHistory;
    }

    public double getPriceCostlyHistory() {
        return priceCostlyHistory;
    }

    public void setPriceCostlyHistory(double priceCostlyHistory) {
        this.priceCostlyHistory = priceCostlyHistory;
    }

    public double getPriceLowHistory() {
        return priceLowHistory;
    }

    public void setPriceLowHistory(double priceLowHistory) {
        this.priceLowHistory = priceLowHistory;
    }

    public double getBuyForeign() {
        return buyForeign;
    }

    public void setBuyForeign(double buyForeign) {
        this.buyForeign = buyForeign;
    }

    public double getSellForeign() {
        return sellForeign;
    }

    public void setSellForeign(double sellForeign) {
        this.sellForeign = sellForeign;
    }

}
