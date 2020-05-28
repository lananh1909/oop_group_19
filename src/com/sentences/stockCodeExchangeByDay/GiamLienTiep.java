package com.sentences.stockCodeExchangeByDay;

import java.util.List;

import com.modelDataCK.StockModel;
import com.process.FormatDate;

public class GiamLienTiep extends TangLienTiep {
	public GiamLienTiep (List<StockModel> stockModel) {
		super(stockModel);
	}
	
	@Override
	public int count() {
		int [] start = new int[MAX];
		int [] s = new int[MAX];
		
		s[0] = 1;
		start[0] = 0;
		for (int i = 1; i < stockModel.size(); i++) {
			double now = stockModel.get(i).getPrice();
			int j = i - 1;
			double before = stockModel.get(j).getPrice();
			if (now < before) {
				s[i] = s[i-1] + 1;
				start[i] = start[i-1];
			} else {
				s[i] = 1;
				start[i] = i;
			} 
		}
		
		int min = 99999;
		for (int i = 0; i < stockModel.size(); i++) {
			if (s[i] < min) {
				min = s[i];
				startModel = stockModel.get(start[i]);
				endModel = stockModel.get(i);
			}
		}
		return min;
	}
	
	@Override
	public String createSentence() {
		int n = count();
		if (n>3) {
			if (endModel.equals(stockModel.get(stockModel.size() - 1))) {
				return "";
			} else {
				String endDate = new FormatDate().formatDate(endModel.getDate());
				return "Chấm dứt chuỗi " + n + " ngày đèn đỏ, tại phiên ngày " + 
						new FormatDate().formatDate(stockModel.get(stockModel.indexOf(endModel)+1).getDate()) +
						" cổ phiếu " + stockModel.get(0).getStockCode() + 
						" đã có tín hiệu khởi sắc từ đỏ thành xanh, giá cổ phiếu bắt đầu có tín hiệu tăng trở lại. ";
			}
		} else {
			return "";
		}
		
	}
}
