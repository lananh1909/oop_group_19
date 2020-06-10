package com.sentences.stockCodeOnDay;

import com.modeldatack.StockModel;
import com.process.FormatNumber;

public class GiaBanTot {
	private StockModel stockCode;
	
	public GiaBanTot (StockModel stockCode) {
		this.stockCode = stockCode;
	}
	
	public String createSentence () {
		FormatNumber format = new FormatNumber();
		return "Ba giá bán thấp nhất trong ngày " +
				format.formatNumber(stockCode.getOversoldPrice1() * 1000) + " VNĐ (" + format.formatNumber(stockCode.getMassOversold1() * 10) + " cp), " +
				format.formatNumber(stockCode.getOversoldPrice2() * 1000) + " VNĐ (" + format.formatNumber(stockCode.getMassOversold2() * 10) + " cp), " +
				format.formatNumber(stockCode.getOversoldPrice3() * 1000) + " VNĐ (" + format.formatNumber(stockCode.getMassOversold3() * 10) + " cp). ";
	}
}
