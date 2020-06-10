package com.sentences.stock_code_on_day;

import com.modeldatack.StockModel;
import com.process.FormatNumber;

public class GiaMuaTot {
	private StockModel stockCode;
	
	public GiaMuaTot (StockModel stockCode) {
		this.stockCode = stockCode;
	}
	
	public String createSentence () {
		FormatNumber format = new FormatNumber();
		return "Một số giá tốt được các nhà đầu tư đặt mua cổ phiếu như " +
				format.formatNumber(stockCode.getOverBuyingPrice1() * 1000) + " VNĐ (" + format.formatNumber(stockCode.getMassOverBuying1() * 10) + " cp), " +
				format.formatNumber(stockCode.getOverBuyingPrice2() * 1000) + " VNĐ (" + format.formatNumber(stockCode.getMassOverBuying2() * 10) + " cp), " +
				format.formatNumber(stockCode.getOverBuyingPrice3() * 1000) + " VNĐ (" + format.formatNumber(stockCode.getMassOverBuying3() * 10) + " cp). ";
	}
}
