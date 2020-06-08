package com.sentences.stockCodeOnDay;

import com.modelDataCK.StockModel;
import com.process.FormatNumber;

public class DatMuaDatBan {
	StockModel stockCode;
	
	public DatMuaDatBan(StockModel stockCode) { 
		this.stockCode = stockCode;
	}
	
	public String createSentence() {
		double buy = stockCode.getMassOverBuying1() % 1000;
		double sold = stockCode.getMassOversold1() % 1000;
		if (buy > 0 && sold > 0)
			return "Chốt phiên, " + stockCode.getStockCode() +
					" có tới " + new FormatNumber().formatNumber(buy) +
					" vạn cổ phiếu đặt mua với giá cao nhất và " + new FormatNumber().formatNumber(sold) +
					" vạn cổ phiếu đặt bán với giá thấp nhất. ";
		return "";
	}
}
//Trốt phiên, REE có tới 6 vạn cổ phiếu đặt mua với giá cao nhất và 7 vạn cổ phiếu đặt bán với giá thấp nhất. 