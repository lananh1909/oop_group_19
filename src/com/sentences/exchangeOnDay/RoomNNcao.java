package com.sentences.exchangeOnDay;

import java.util.List;

import com.modelDataCK.StockModel;
import com.process.FormatNumber;
import com.process.SortByRoomNN;
public class RoomNNcao extends MaGiaBanCao{
	public RoomNNcao (List<StockModel> today) {
		super(today);
	}
	
	@Override
	public String createSentence() {
		sortList(new SortByRoomNN());
		int n = super.getToday().size();
		List<StockModel> lst = super.getToday().subList(n - 5, n);
		
		String code = "";
		for (int i = 0; i<5; i++) {
			if (i != 4) {
				code += lst.get(i).getStockCode() + ", ";
			} else
				code += lst.get(i).getStockCode();
		}
		return "Các mã chứng khoán có RoomNN cao: " + code +
				", cao nhất là " + lst.get(lst.size() - 1).getStockCode() +
				" với " + new FormatNumber().formatNumber(lst.get(lst.size() - 1).getRoomNN() * 10) + " cổ phiếu. ";

	}
}