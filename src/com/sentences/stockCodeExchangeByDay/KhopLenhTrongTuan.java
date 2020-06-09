package com.sentences.stockCodeExchangeByDay;

import java.util.ArrayList;
import java.util.List;

import com.modeldatack.StockModel;
import com.process.FormatDate;
import com.process.FormatNumber;

// Trong tuan qua, tong khoi luong khop lenh dao dong trong khoang ....
public class KhopLenhTrongTuan {
	private List<StockModel> stockModel = new ArrayList<StockModel>();
	private String maxDate;
	private String minDate;
	
	public KhopLenhTrongTuan (List<StockModel> stockModel) {
		this.stockModel = stockModel;
		setMaxDate(this.stockModel.get(0).getDate());
		setMinDate(this.stockModel.get(0).getDate());
	}
		
	public List<StockModel> getStockModel() {
		return stockModel;
	}

	public void setStockModel(List<StockModel> stockModel) {
		this.stockModel = stockModel;
	}

	public String getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}

	public String getMinDate() {
		return minDate;
	}

	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}

	public double findMax() {
		double max = stockModel.get(0).getSumOrderMatchingMass();
		for(int i = 0; i<stockModel.size(); i++) {
			if(stockModel.get(i).getSumOrderMatchingMass()>max) {
				max = stockModel.get(i).getSumOrderMatchingMass();
				maxDate = stockModel.get(i).getDate();
			}
		}
		return max;
	}
	
	public double findMin() {
		double min = stockModel.get(0).getSumOrderMatchingMass();
		for(int i = 0; i<stockModel.size(); i++) {
			if(stockModel.get(i).getSumOrderMatchingMass() < min) {
				min = stockModel.get(i).getSumOrderMatchingMass();
				minDate = stockModel.get(i).getDate();
			}				
		}
		return min;
	}
	
	public String createSentence() {
		String max = new FormatNumber().formatNumber(findMax()*10);
		String min = new FormatNumber().formatNumber(findMin()*10);		
		
		return "Trong thời gian vừa qua, khối lượng khớp lệnh dao động trong khoảng từ "
				+ min + " cổ phiếu đến " + max + " cổ phiếu; nhiều nhất trong ngày "
				+ new FormatDate().formatDate(maxDate) + " và ít nhất trong ngày "
				+ new FormatDate().formatDate(minDate) + ". ";
	}
	
}
