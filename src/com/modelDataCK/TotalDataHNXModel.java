package com.modelDataCK;

public class TotalDataHNXModel extends GenericTotalModel {
    private double exchangeMass;  // khối lượng giao dịch
    private double exchangeValue;  // phần trăm giao dịch

    public double getExchangeMass() {
        return exchangeMass;
    }

    public void setExchangeMass(double exchangeMass) {
        this.exchangeMass = exchangeMass;
    }

    public double getExchangeValue() {
        return exchangeValue;
    }

    public void setExchangeValue(double exchangePercent) {
        this.exchangeValue = exchangeValue;
    }
}
