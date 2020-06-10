package com.sentences.stock_code_on_day;

import com.modeldatack.StockModel;
import com.process.FormatDate;
import com.process.FormatNumber;

public class NNMuaBan {
	private StockModel stockCode;
	
	public NNMuaBan (StockModel stockCode) {
		this.stockCode = stockCode;
	}
	
	public String createSentence() {
		FormatNumber format = new FormatNumber();
		String nnMua = format.formatNumber(stockCode.getBuyForeign() * 10);
		String nnBan = format.formatNumber(stockCode.getSellForeign() * 10);
		String sum = format.formatNumber(stockCode.getRoomNN() * 10);
		double sMua = stockCode.getBuyForeign() * 10 * stockCode.getPrice();
		double sBan = stockCode.getSellForeign() * 10 * stockCode.getPrice();
		
		String sentences [] = {
			"Ngày hôm nay, nhà đầu tư nước ngoài đã mua vào " + nnMua + " cổ phiếu " +
			stockCode.getStockCode() + " và bán ra " + nnBan + " cổ phiếu. ",
			"Tổng khối lượng RomNN là " + sum + " cổ phiếu. ",
			"Trong ngày " + new FormatDate().formatDate(stockCode.getDate()) +
			" nhà đầu tư nước ngoài đã đầu tư thêm vào " + stockCode.getStockCode() +
			" một lượng cổ phiếu là " + nnMua + ", tương đương với " + 
			format.formatNumber(sMua) + " nghìn đồng. ",
			"Nhà đầu tư nước ngoài đã bán ra một lượng cổ phiếu với khối lượng là " +
			nnBan + ", tương đương với " + format.formatNumber(sBan) + " nghìn đồng. " 
		};
		int r = (int) (Math.random() * 4);
		return sentences[r];		
	}
}
