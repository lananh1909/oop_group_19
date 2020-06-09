package com.sentences.stockCodeOnDay;

import com.modeldatack.StockModel;
import com.process.FormatNumber;

public class TranSanThamChieu {
	private StockModel stockCode;
	
	public TranSanThamChieu (StockModel stockCode) {
		this.stockCode = stockCode;	
	}
	
	public String createSentence() {
		FormatNumber format = new FormatNumber();
		String tran = format.formatNumber(stockCode.getCeiling());
		String san = format.formatNumber(stockCode.getFloor());
		String thamChieu = format.formatNumber(stockCode.getReference());
		
		String sentences [] = {
				stockCode.getStockCode() + " hôm nay, giá tham chiếu " + thamChieu +
				" nghìn đồng, giá trần " + tran + " nghìn đồng, giá sàn " + 
				san + " nghìn đồng. ",
				"Đóng cửa phiên giao dịch hôm qua, " + stockCode.getStockCode() + 
				" có giá " + thamChieu + " nghìn đồng. "
		};
		int r = (int) (Math.random() * 2);
		return sentences[r];		
	}
}
