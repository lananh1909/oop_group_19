package com.sentences.stockCodeExchangeByDay;

import java.util.ArrayList;
import java.util.List;

import com.modelDataCK.StockModel;
import com.process.FormatDate;

public class TangLienTiep {
	List<StockModel> stockModel = new ArrayList<StockModel>();
	StockModel startModel;
	StockModel endModel;
	final int MAX = 10000;
	
	public TangLienTiep (List<StockModel> stockModel) {
		this.stockModel = stockModel;
	}
	
	public int count() {
		int [] start = new int[MAX];
		int [] s = new int[MAX];
		
		s[0] = 1;
		start[0] = 0;
		for (int i = 1; i < stockModel.size(); i++) {
			double now = stockModel.get(i).getPrice();
			double before = stockModel.get(i-1).getPrice();
			if (now > before) {
				s[i] = s[i-1] + 1;
				start[i] = start[i-1];
			} else {
				s[i] = 1;
				start[i] = i;
			} 
		}
		
		int max = 0;
		for (int i = 0; i < stockModel.size(); i++) {
			if (s[i] > max) {
				max = s[i];
				startModel = stockModel.get(start[i]);
				endModel = stockModel.get(i);
			}
		}
		return max;
	}
	
	public String createSentence() {
		int n = count();
		if (n>3) {
			if (endModel.equals(stockModel.get(stockModel.size() - 1))) {
				return "";
			} else {
				String endDate = new FormatDate().formatDate(endModel.getDate());
				return "Trải qua chuỗi " + n + " ngày tăng liên tiếp, tại phiên ngày " + 
						new FormatDate().formatDate(stockModel.get(stockModel.indexOf(endModel)+1).getDate()) +
						" cổ phiếu " + stockModel.get(0).getStockCode() + 
						" đã bị chấm dứt tạm thời khỏi chuỗi đèn xanh. ";
			}
		} else {
			return "";
		}
		
	}
}
