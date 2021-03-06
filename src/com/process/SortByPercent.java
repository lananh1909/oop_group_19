package com.process;

import java.util.Comparator;

import com.modeldatack.StockModel;

public class SortByPercent implements Comparator<StockModel> {
	public int compare (StockModel a, StockModel b) {
		double a1 = a.getPercent();
		double b1 = b.getPercent();
		if (a1-b1 > 0) return 1;
		if (a1-b1 < 0) return -1;
		return 0;
	}
}
