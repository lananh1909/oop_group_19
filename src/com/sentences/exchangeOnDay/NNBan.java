package com.sentences.exchangeOnDay;

import java.util.List;

import com.modeldatack.StockModel;
import com.process.FormatNumber;
import com.process.SortBySellForeign;
public class NNBan extends MaGiaBanCao{
	public NNBan(List<StockModel> today) {
		super(today);
	}
	
	@Override
	public String createSentence() {
		sortList(new SortBySellForeign());
		int n = super.getToday().size();
		List<StockModel> lst = super.getToday().subList(n - 6, n);
		
		String code = "";
		for (int i = 0; i<6; i++) {
			if (i != 5) {
				code += lst.get(i).getStockCode() + ", ";
			} else
				code += lst.get(i).getStockCode();
		}
		return "Các nhà đầu tư nước ngoài đã bán một lượng cổ phiếu lớn của một số mã chứng khoán " + code +
				", trong đó " + lst.get(lst.size() - 1).getStockCode() +
				" bán ra " + new FormatNumber().formatNumber(lst.get(lst.size() - 1).getSellForeign() * 10) + " cổ phiếu. ";

	}
}
