package com.sentences.exchangeOnDay;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.modeldatack.StockModel;
import com.process.FormatDate;
import com.process.SortByPercent;

public class MaGiaBanCao {
	List<StockModel> today;
	
	public MaGiaBanCao (List<StockModel> today) {
		this.today = today;
	}
	
	public List<StockModel> getToday() {
		return today;
	}

	public void setToday(List<StockModel> today) {
		this.today = today;
	}

	public void sortList(Comparator<StockModel> sort) {
		Collections.sort(today, sort);
	}
	
	public String createSentence() {
		sortList(new SortByPercent());
		int n = today.size();
		List<StockModel> lst = today.subList(n - 5, n);
		String code = "";
		for (int i = 0; i<5; i++) {
			if (lst.get(i).getPercent() > 0) {
				if (i != 4) {
					code += lst.get(i).getStockCode() + ", ";
				} else
					code += lst.get(i).getStockCode();
			}
		}
		
		String s [] = {
				"Mở cửa phiên giao dịch ngày " + new FormatDate().formatDate(today.get(0).getDate()) +
				" một số mã cổ phiếu có giá bán cao " + code + ". ",
				"Top các mã chứng khoán có giá cổ phiếu tăng mạnh nhất trong ngày hôm này như " +
				code + ". "
		};
		int m = new Random().nextInt(2);
		return s[m];
	}
}

