package com.sentences.exchangeOnDay;

import java.util.List;

import com.modelDataCK.StockModel;
import com.process.SortByOrderMatchingInOrDe;

public class DiemSang extends MaGiaBanCao{
	
	public DiemSang(List<StockModel> today) {
		super(today);
	}

	@Override
	public String createSentence() {
		sortList(new SortByOrderMatchingInOrDe());
		int n = super.getToday().size();
		List<StockModel> lst = super.getToday().subList(n - 5, n);
		String code = "";
		for (int i = 0; i<5; i++) {
			if (lst.get(i).getOrderMatchingInOrDe() > 0) {
				if (i != 4) {
					code += lst.get(i).getStockCode() + " (" + lst.get(i).getPercent() + "%), ";
				} else
					code += lst.get(i).getStockCode() + " (" + lst.get(i).getPercent() + "%)";
			}
		}
		return "Điểm sáng trong ngày hôm nay thuộc về các mã cổ phiếu tiêu biểu, giao dịch sôi động như " +
				code + ". ";
	}
}
