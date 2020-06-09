package com.process;

import java.util.Comparator;

import com.modeldatack.StockModel;

public class SortByOrderMatchingInOrDe implements Comparator<StockModel>{
	public int compare (StockModel a, StockModel b) {
		double a1 = a.getOrderMatchingInOrDe();
		double b1 = b.getOrderMatchingInOrDe();
		if (a1-b1 > 0) return 1;
		if (a1-b1 < 0) return -1;
		return 0;
	}
}
