package com.sentences.stockCodeOnDay;

import java.util.List;

import com.modelDataCK.StockModel;
import com.process.FormatNumber;
import com.process.SortBySumOrderMatchingMass;

public class KhoiLuongGiaoDichLon extends MaGiaBanCao{
	public KhoiLuongGiaoDichLon(List<StockModel> today) {
		super(today);
	}
	
	@Override
	public String createSentence() {
		sortList(new SortBySumOrderMatchingMass());
		int n = super.getToday().size();
		List<StockModel> lst = super.getToday().subList(n - 5, n);
		String code = "";
		for (int i = 0; i<5; i++) {
			if (i != 4) {
				code += lst.get(i).getStockCode() + ", ";
			} else
				code += lst.get(i).getStockCode();
		}
		return "Các mã cổ phiếu có khối lượng giao dịch lớn nhất trong ngày là " + code +
				", trong đó cao nhất là " + lst.get(lst.size() - 1).getStockCode() +
				" đạt " + new FormatNumber().formatNumber(lst.get(lst.size() - 1).getSumOrderMatchingMass() * 10) + ". ";

	}
}
