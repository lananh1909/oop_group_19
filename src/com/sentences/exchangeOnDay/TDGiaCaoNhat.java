package com.sentences.exchangeOnDay;

import java.util.List;

import com.modelDataCK.StockModel;
import com.process.FormatNumber;
import com.process.SortByPriceCostlyHistory;
import com.process.SortByPriceLowHistory;
public class TDGiaCaoNhat extends MaGiaBanCao{
	public TDGiaCaoNhat (List<StockModel> today) {
		super(today);
	}
	
	@Override
	public String createSentence() {
		sortList(new SortByPriceCostlyHistory());
		int n = super.getToday().size();
		List<StockModel> lst = super.getToday().subList(n - 5, n);
		StockModel max = lst.get(4);
		String code = "";
		for (int i = 0; i<5; i++) {
			if (i != 4) {
				code += lst.get(i).getStockCode() + ", ";
			} else
				code += lst.get(i).getStockCode();
		  }
		
		sortList(new SortByPriceLowHistory());
		int index = 0;
		for (StockModel s: super.getToday()) {
			if (s.getPriceLowHistory() > 0) {
				index = super.getToday().indexOf(s);
				break;
			}
		}
        List<StockModel> lst1 = super.getToday().subList(index, index + 5);
		
		String code1 = "";
		for (int i = 0; i<5; i++) {
			if (i != 4) {
				code1 += lst1.get(i).getStockCode() + ", ";
			} else
				code1 += lst1.get(i).getStockCode();
		  }
		return "Một số mã chứng khoán trong ngày có thời điểm giá cổ phiếu cao nhất sàn: " + code +
				" tiêu biểu như " + max.getStockCode() +
				" với " + new FormatNumber().formatNumber(max.getPriceCostlyHistory() * 1000) + " VNĐ/1cp. " +
     			"Mã có giá thấp nhất sàn: " + code1 +
				" thấp là " + lst1.get(0).getStockCode() +
				" với " + new FormatNumber().formatNumber(lst1.get(0).getPriceLowHistory() * 1000) + " VNĐ/1cp. ";

	}
}