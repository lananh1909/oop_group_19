package com.sentences.stock_code_by_day;

import java.util.ArrayList;
import java.util.List;

import com.modeldatack.StockModel;
import com.process.FormatDate;
import com.process.FormatNumber;

public class DaoDongGia {
	private List<StockModel> stockModel = new ArrayList<StockModel>();
	private String maxDay;
	private String minDay;
	
	public DaoDongGia (List<StockModel> stockModel) {
		this.stockModel = stockModel;
		maxDay = this.stockModel.get(0).getDate();
		minDay = this.stockModel.get(0).getDate();
	}
	
	public double findMax() {
		double max = stockModel.get(0).getPrice();
		for (StockModel stock: stockModel) {
			if (stock.getPrice() > max) {
				max = stock.getPrice();
				maxDay = stock.getDate();
			};
		}
		return max;
	}
	
	public double findMin() {
		double min = stockModel.get(0).getPrice();
		for (StockModel stock: stockModel) {
			if (stock.getPrice() < min) {
				min = stock.getPrice();
				minDay = stock.getDate();
			};
		}
		return min;
	}
	
	public String createSentence() {
		FormatNumber format = new FormatNumber();
		double max = findMax();
		double min = findMin();
		String sMax = format.formatNumber(max * 1000);
		String sMin = format.formatNumber(min * 1000);
		String diff = format.formatNumber((max - min) * 1000);
		String maxDay = new FormatDate().formatDate(this.maxDay);
		String minDay = new FormatDate().formatDate(this.minDay);
		return "Giá cổ phiếu dao động trong thời gian từ ngày " + new FormatDate().formatDate(stockModel.get(0).getDate()) +
				" đến ngày " + new FormatDate().formatDate(stockModel.get(stockModel.size()-1).getDate()) +
				" rơi vào khoảng " + diff + " VNĐ; trong đó cao nhất là " + sMax + " VNĐ vào ngày " +
				maxDay + ", thấp nhất là " + sMin + " VNĐ vào ngày " + minDay + ". ";
	}
}
