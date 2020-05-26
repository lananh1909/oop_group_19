package com.sentences.stockCodeExchangeByDay;

import java.util.ArrayList;
import java.util.List;

import com.modelDataCK.StockModel;
import com.process.FormatDate;
import com.process.FormatNumber;

public class RoomNN {
	private List<StockModel> stockModel = new ArrayList<StockModel>();
	private String maxDate;
	private String minDate;
	
	public RoomNN (List<StockModel> stockModel) {
		this.stockModel = stockModel;
		maxDate = this.stockModel.get(0).getDate();
		minDate = this.stockModel.get(0).getDate();
	}
	
	public double findMax() {
		double max = stockModel.get(0).getRoomNN();
		for (StockModel stock: stockModel) {
			if (stock.getRoomNN() > max) {
				max = stock.getRoomNN();
				maxDate = stock.getDate();
			}
		}
		return max;
	}
	
	public double findMin() {
		double min = stockModel.get(0).getRoomNN();
		for (StockModel stock: stockModel) {
			if (stock.getRoomNN() < min) {
				min = stock.getRoomNN();
				minDate = stock.getDate();
			}
		}
		return min;
	}
	
	public String createSentence() {
		String sMax = new FormatNumber().formatNumber(findMax() * 10);
		String sMin = new FormatNumber().formatNumber(findMin() * 10);
		String sMaxDate = new FormatDate().formatDate(maxDate);
		String sMinDate = new FormatDate().formatDate(minDate);
		return "Room NN dat gia tri cao nhat la " + sMax + " vao ngay " + sMaxDate +
				" va thap nhat la " + sMin + " vao ngay " + sMinDate + ". ";
	}
}
