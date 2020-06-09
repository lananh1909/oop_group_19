package com.sentences.stockCodeExchangeByDay;

import java.util.ArrayList;
import java.util.List;

import com.modeldatack.StockModel;
import com.process.FormatDate;
public class CacNgayGiam {
	private List<StockModel> stockModel = new ArrayList<StockModel>();
	private List<String> date = new ArrayList<String>();
	private List<String> date1 = new ArrayList<String>();
	
	public CacNgayGiam (List<StockModel> stockModel) {
		this.stockModel = stockModel;
	}
	
	public int count() {
		for(StockModel stock: stockModel) {
			double reference = stock.getReference();
			if(stock.getPrice() < reference) {
				date.add(stock.getDate());
			}
		}
		return date.size();
	}
	
	public StockModel findMin() {
		StockModel min = stockModel.get(0);
		for (StockModel stock: stockModel) {
			if (stock.getPercent() < 0) {
				if (stock.getPercent() < min.getPercent())
					min = stock;
			}
		}
		return min;
	}
	
	public int count1() {
		for(StockModel stock: stockModel) {
			double reference = stock.getReference();
			if(stock.getPrice() == reference) {
				date1.add(stock.getDate());
			}
		}
		return date1.size();
	}
	
	public String createSentence() {
		int i = count();
		int j = count1();
		int n = stockModel.size();
		StockModel min = findMin();
		if (i == n)
			return "Đây là quãng thời gian khá buồn của " + stockModel.get(0).getStockCode() + 
					" tính đến ngày hôm nay đã là ngày thứ " + n +
					" bị giảm giá cổ phiếu liên tiếp trên sàn chứng khoán. ";
		if (i > 0 && i < n && j == 0)
			return "Từ ngày " + new FormatDate().formatDate(stockModel.get(0).getDate()) +
					" đến ngày hôm nay, mã " + stockModel.get(0).getStockCode() + " có " +
					i +" ngày bị giảm giá cổ phiếu. ";
		if (i > 0 && j > 0)
			return "Từ ngày " + new FormatDate().formatDate(stockModel.get(0).getDate()) +
					" đến ngày hôm nay, mã " + stockModel.get(0).getStockCode() + " có " +
					j + " ngày cổ phiếu đứng giá, " + i +" ngày bị giảm giá cổ phiếu, điển hình như trong ngày " +
					new FormatDate().formatDate(min.getDate()) + ". ";
		if (i == 0 && j == 0)
			return "Đây là chuỗi ngày tăng trưởng lớn nhất của "+ stockModel.get(0).getStockCode() + " với tất cả các"
				+ " ngày giao dịch đều có giá cổ phiếu tăng đáng kể. ";
		if (i == 0 && j > 0)
			return "Đây là chuỗi ngày bình yên của " + stockModel.get(0).getStockCode() +
					", giá cổ phiếu tăng trưởng ổn định. ";
		return "";
	}
}