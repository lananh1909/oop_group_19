package com.sentences.exchangeOnDay;

import java.util.List;

import com.modeldatack.GenericTotalModel;
import com.modeldatack.StockModel;
import com.process.FormatDate;

public class ColorOfExchange extends MaGiaBanCao {
	private GenericTotalModel generic;
	
	public ColorOfExchange (List<StockModel> today, GenericTotalModel generic) {
		super(today);
		this.generic = generic;
	}
	
	public int findGreen() {
		int count = 0;
		for (StockModel s: today) {
			if (s.getPercent() > 0) {
				count ++;
			}
		}
		return count;
	}
	
	public int findRed() {
		int count = 0;
		for (StockModel s: today) {
			if (s.getPercent() < 0) {
				count ++;
			}
		}
		return count;
	}
	
	@Override
	public String createSentence () {
		double n = today.size() * 0.67;
		if (findGreen() > (int) n) {
			return "Sàn chứng khoán " + generic.getNameExchange() +
					" được bao phủ bởi chiếc thảm xanh khổng lồ trong phiên giao dịch ngày " +
					new FormatDate().formatDate(generic.getDate()) + ". ";
		}
		
		else {
			return "Ngày " + new FormatDate().formatDate(generic.getDate()) + " sắc đỏ bao trùm trên sàn " + generic.getNameExchange() +". ";
		}
	}
}

