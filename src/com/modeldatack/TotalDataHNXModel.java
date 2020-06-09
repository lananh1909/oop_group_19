package com.modeldatack;

public class TotalDataHNXModel extends GenericTotalModel {
    private double exchangeMass;  // khối lượng giao dịch
    private double exchangeValue;  // phần trăm giao dịch

    public TotalDataHNXModel (String date) {
    	super(date);
    }
    
    public double getExchangeMass() {
        return exchangeMass;
    }

    public void setExchangeMass(double exchangeMass) {
        this.exchangeMass = exchangeMass;
    }

    public double getExchangeValue() {
        return exchangeValue;
    }

    public void setExchangeValue(double exchangeValue) {
        this.exchangeValue = exchangeValue;
    }
}
//Khánh ơi à rồi, ok
// đúng chỗ này rồi, nãy có ghé qua mà ko thấy =))
