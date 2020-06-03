package com.sentences.stockCodeExchangeByDay;

import java.util.ArrayList;
import java.util.List;

import com.modelDataCK.StockModel;
import com.process.FormatDate;

public class GiaTangManh {
	private List<StockModel> stockModel = new ArrayList<StockModel>();
	private List<String> date = new ArrayList<String>();
	
	public GiaTangManh (List<StockModel> stockModel) {
		this.stockModel = stockModel;
	}
	public int count() {
		for(StockModel stock: stockModel) {
			double ceiling = stock.getCeiling();
			if( stock.getPrice() == ceiling) {
				date.add(stock.getDate());
			}
		}
		return date.size();
	}
	
	public String createSentence() {
		int n = count();
		if (n>0)
			return " Đặc biệt có" + n +
					" ngày giá cổ phiếu đã tăng mạnh đạt ngưỡng giá trần đã làm các nhà đầu tư vui mừng với khoản lợi nhuận lớn";
				
		else return "";
	}
}
