package com.sentences.stockCodeExchangeByDay;

import java.util.ArrayList;
import java.util.List;

import com.modelDataCK.StockModel;
import com.process.FormatDate;
import com.process.FormatNumber;

// Trong tuan qua, tong khoi luong khop lenh dao dong trong khoang ....
public class KhopLenhTrongTuan {
	private List<StockModel> stockModel = new ArrayList<StockModel>();
	private String maxDate;
	private String minDate;
	
	public KhopLenhTrongTuan (List<StockModel> stockModel) {
		this.stockModel = stockModel;
	}
	
	public double findMax() {
		double max = 0;
		for(int i = 0; i<stockModel.size(); i++) {
			if(stockModel.get(i).getSumOrderMatchingMass()>max) {
				max = stockModel.get(i).getSumOrderMatchingMass();
				maxDate = stockModel.get(i).getDate();
			}
		}
		return max;
	}
	
	public double findMin() {
		double min = -999999;
		for(int i = 0; i<stockModel.size(); i++) {
			if(stockModel.get(i).getSumOrderMatchingMass()<min) {
				min = stockModel.get(i).getSumOrderMatchingMass();
				minDate = stockModel.get(i).getDate();
			}				
		}
		return min;
	}
	
	public String createSentence() {
		String max = new FormatNumber().formatNumber(findMax()*10);
		String min = new FormatNumber().formatNumber(findMin()*10);		
		
		return "Trong tuan vua qua, khoi luong khop lenh dao dong trong khoang tu "
				+ min + " co phieu den " + max + " co phieu; nhieu nhat trong ngay "
				+ new FormatDate().formatDate(maxDate) + " va it nhat trong ngay "
				+ new FormatDate().formatDate(minDate) + ".";
	}
	
}
