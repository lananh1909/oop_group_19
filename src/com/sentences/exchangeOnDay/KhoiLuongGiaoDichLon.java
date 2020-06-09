package com.sentences.exchangeOnDay;

import java.util.List;

import com.modeldatack.StockModel;
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
		String code1 = "";
		for (int i = 0; i<5; i++) {
			if (i != 4) {
				code += lst.get(i).getStockCode() + ", ";
				code1 += lst.get(i).getStockCode() + " " + new FormatNumber().formatNumber(lst.get(i).getSumOrderMatchingMass()) + ", ";
			} else {
				code += lst.get(i).getStockCode();
				code1 += lst.get(i).getStockCode() + " " + new FormatNumber().formatNumber(lst.get(i).getSumOrderMatchingMass()) + " cổ phiếu";
			}
		}
		
		
		
		String [] sentences = {
				"Các mã cổ phiếu có khối lượng giao dịch lớn nhất trong ngày là " + code +
				", trong đó cao nhất là " + lst.get(lst.size() - 1).getStockCode() +
				" đạt " + new FormatNumber().formatNumber(lst.get(lst.size() - 1).getSumOrderMatchingMass() * 10) + ". ",
				
				"Khối lượng giao dịch của phiên tập trung vào các cổ phiếu như " + code1 +
				", số còn lại đều có lượng giao dịch dưới " + new FormatNumber().formatNumber((int) (lst.get(0).getSumOrderMatchingMass() / 1000) * 1000)
				+ " cổ phiếu. "
		};
		
		int r = (int) (Math.random() * 2);
		return sentences[r];

	}
}
