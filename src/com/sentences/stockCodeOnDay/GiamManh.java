package com.sentences.stockCodeOnDay;

import java.util.List;

import com.modelDataCK.StockModel;
import com.process.SortByOrderMatchingInOrDe;

public class GiamManh extends MaGiaBanCao{
	
	public GiamManh(List<StockModel> today) {
		super(today);
	}

	@Override
	public String createSentence() {
		sortList(new SortByOrderMatchingInOrDe());
		List<StockModel> lst = super.getToday().subList(0, 5);
		String code = "";
		for (int i = 0; i<5; i++) {
			if (lst.get(i).getOrderMatchingInOrDe() > 0) {
				if (i != 4) {
					code += lst.get(i).getStockCode() + " (" + lst.get(i).getPercent() + "%), ";
				} else
					code += lst.get(i).getStockCode() + " (" + lst.get(i).getPercent() + "%)";
			}
		}
		return " Trái ngược với hàng loạt các mã chứng khoán Blue-chip, một số mã chứng khoán đã bị rớt điểm nghiêm trọng như " +
				code + ". ";
	}
}
