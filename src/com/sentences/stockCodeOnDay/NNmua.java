package com.sentences.stockCodeOnDay;

import java.util.List;

import com.modelDataCK.StockModel;
import com.process.FormatNumber;
import com.process.SortByBuyForeign;
public class NNmua extends MaGiaBanCao{
	public NNmua(List<StockModel> today) {
		super(today);
	}
	
	@Override
	public String createSentence() {
		sortList(new SortByBuyForeign());
		int n = super.getToday().size();
		List<StockModel> lst = super.getToday().subList(n - 6, n);
		
		String code = "";
		for (int i = 0; i<6; i++) {
			if (i != 5) {
				code += lst.get(i).getStockCode() + ", ";
			} else
				code += lst.get(i).getStockCode();
		}
		return "Một số mã chứng khoán nhận được sự quan tâm lớn của nhà đầu tư nước ngoài như: " + code +
				", trong đó mã được mua nhiều nhất là " + lst.get(lst.size() - 1).getStockCode() +
				" với " + new FormatNumber().formatNumber(lst.get(lst.size() - 1).getBuyForeign() * 10) + " cổ phiếu. ";

	}
}