package com.modeldatack;

public class GenericTotalModel {
	private String date;
    private String nameExchange;
    private double index;
    private double increaseAndDecrease;
    private double percentIncreaseAndDecrease;

    public GenericTotalModel (String date) {
    	this.date = date;
    }
    
    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNameExchange() {
        return nameExchange;
    }

    public void setNameExchange(String nameExchange) {
        this.nameExchange = nameExchange;
    }

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    public double getIncreaseAndDecrease() {
        return increaseAndDecrease;
    }

    public void setIncreaseAndDecrease(double increaseAndDecrease) {
        this.increaseAndDecrease = increaseAndDecrease;
    }

    public double getPercentIncreaseAndDecrease() {
        return percentIncreaseAndDecrease;
    }

    public void setPercentIncreaseAndDecrease(double percentIncreaseAndDecrease) {
        this.percentIncreaseAndDecrease = percentIncreaseAndDecrease;
    }
}
