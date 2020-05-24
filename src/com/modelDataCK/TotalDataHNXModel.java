package com.modelDataCK;

public class TotalDataHNXModel extends GenericTotalModel {
    private double exchangeMass;  // khối lượng giao dịch
    private double exchangePercent;  // phần trăm giao dịch

    public double getExchangeMass() {
        return exchangeMass;
    }

    public void setExchangeMass(double exchangeMass) {
        this.exchangeMass = exchangeMass;
    }

    public double getExchangePercent() {
        return exchangePercent;
    }

    public void setExchangePercent(double exchangePercent) {
        this.exchangePercent = exchangePercent;
    }
}
