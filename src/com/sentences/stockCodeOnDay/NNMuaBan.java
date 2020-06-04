package com.sentences.stockCodeOnDay;

import com.modelDataCK.StockModel;
import com.process.FormatNumber;

public class NNMuaBan {
	private StockModel stockCode;
	
	public NNMuaBan (StockModel stockCode) {
		this.stockCode = stockCode;
	}
	
	public String createSentence() {
		FormatNumber format = new FormatNumber();
		String NNMua = format.formatNumber(stockCode.getBuyForeign() * 10);
		String NNBan = format.formatNumber(stockCode.getSellForeign() * 10);
		String Sum = format.formatNumber(stockCode.getRoomNN() * 10);
		
		String sentences [] = {
			"Ngày hôm nay, nhà đầu tư nước ngoài đã mua vào " + NNMua + " cổ phiếu " +
			stockCode.getStockCode() + " và bán ra " + NNBan + " cổ phiếu. ",
			"Tổng khối lượng RomNN là " + Sum + " cổ phiếu. "
		};
		int r = (int) (Math.random() * 2);
		return sentences[r];		
	}
}
