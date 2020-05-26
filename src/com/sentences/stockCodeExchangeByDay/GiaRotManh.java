package com.sentences.stockCodeExchangeByDay;

import java.util.ArrayList;
import java.util.List;

import com.modelDataCK.StockModel;
import com.process.FormatDate;

//So phien dao dich co gia rot manh bang gia san n diem
public class GiaRotManh {
	private List<StockModel> stockModel = new ArrayList<StockModel>();
	private List<String> date = new ArrayList<String>();
	
	public GiaRotManh (List<StockModel> stockModel) {
		this.stockModel = stockModel;
	}
	public int count() {
		for(StockModel stock: stockModel) {
			double floor = stock.getFloor();
			if(stock.getOverBuyingPrice3()==floor || stock.getOverBuyingPrice2()==floor ||
					stock.getOverBuyingPrice1()==floor || stock.getPrice() == floor) {
				date.add(stock.getDate());
			}
		}
		return date.size();
	}
	
	public String createSentence() {
		if (date.size() > 0)
			return "So phien dao dich co gia rot man bang gia san la" + date.size() +
					"nhu trong ngay " + new FormatDate().formatDate(date.get(0)) + ". ";
		else return "";
	}
}
