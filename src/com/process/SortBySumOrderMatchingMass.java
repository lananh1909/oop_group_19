package com.process;

import java.util.Comparator;

import com.modelDataCK.StockModel;

public class SortBySumOrderMatchingMass implements Comparator<StockModel> {
	@Override
	public int compare (StockModel a, StockModel b) {
		double a1 = a.getSumOrderMatchingMass();
		double b1 = b.getSumOrderMatchingMass();
		if (a1-b1 > 0) return 1;
		if (a1-b1 < 0) return -1;
		return 0;
	}
}
