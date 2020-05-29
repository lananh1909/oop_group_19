package com.sentences.stockCodeExchangeByDay;

import java.util.ArrayList;
import java.util.List;

import com.modelDataCK.StockModel;
import com.process.FormatDate;

public class DungGiaThamChieu {
	private List<StockModel> stockModel = new ArrayList<StockModel>();
	private List<String> date = new ArrayList<String>();
	
	public DungGiaThamChieu (List<StockModel> stockModel) {
		this.stockModel = stockModel;
	}
	public int count() {
		for(StockModel stock: stockModel) {
			double reference = stock.getReference();
			if(stock.getOverBuyingPrice3()==reference || stock.getOverBuyingPrice2()==reference ||
					stock.getOverBuyingPrice1()==reference || stock.getPrice() == reference) {
				date.add(stock.getDate());
			}
		}
		return date.size();
	}
	
	public String createSentence() {
		int n = count();
		if (date.size() > 0)
			return "Số phiên giao dịch đứng giá tham chiếu là " + n +
					", như trong ngày " + new FormatDate().formatDate(date.get(0)) + ". ";
		else return "";
	}
}
