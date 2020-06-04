package com.sentences.exchangeOnDay;

import java.util.List;

import com.modelDataCK.StockModel;

public class TangTruongManh {
	List<StockModel> firstDay;
	List<StockModel> today;
	
	public TangTruongManh(List<StockModel> firstDay, List<StockModel> today) {
		this.firstDay = firstDay;
		this.today = today;
	}
	
	public StockModel findMax() {
		StockModel max = today.get(0);
		double maxDouble = 0;
		for (StockModel s: today) {
			StockModel s1 = firstDay.get(firstDay.indexOf(s));
			double m = s.getPrice() - s1.getPrice();
			if (m > maxDouble) {
				maxDouble = m;
				max = s;
			}
		}
		return max;
	}
	
	public String createSentence() {
		StockModel s = findMax();
		return s.getStockCode() + " là mã chứng khoán có mức tăng trưởng lớn nhất sàn so với đầu tháng. ";
	}
	
}
//Một số mã chứng khoán có mức tăng trưởng lớn so với đầu tháng 
//( từ ngày bđ lấy đến ngày đang xét ; lấy theo giá (cột 12)
