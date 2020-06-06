package com.sentences.stockCodeOnDay;

import com.modelDataCK.StockModel;

public class CaoNhatThapNhat {
	StockModel stockCode;
	public CaoNhatThapNhat(StockModel stockCode) {
		this.stockCode=stockCode;
	}
	
	public String createSentence() {
		System.out.println(stockCode.getPriceCostlyHistory() + "-" + stockCode.getPriceLowHistory() + "-" + stockCode.getOrderMatchingInOrDe());
		if (stockCode.getPriceCostlyHistory() > stockCode.getPriceLowHistory()) {
			if (stockCode.getOrderMatchingInOrDe() >0) {
				return  stockCode.getStockCode() +
						" có mức dao động giá trong khoảng " + stockCode.getPriceLowHistory()+ " đến "+ stockCode.getPriceCostlyHistory() +
						" điểm trong ngày nhưng đến cuối ngày đã chốt lại ở con số " + stockCode.getPrice() +
						" tăng " + stockCode.getOrderMatchingInOrDe() + " điểm. ";
			} else {
				if (stockCode.getOrderMatchingInOrDe() < 0) {
					return "Một ngày đầy biến động đối với "+ stockCode.getStockCode() +
							" có mức giá dao động từ " + stockCode.getPriceLowHistory() + " đến " + stockCode.getPriceCostlyHistory() +
							" điểm trong ngày nhưng đến cuối ngày vẫn chỉ dừng lại ở con số " + stockCode.getPrice() +
							" giảm " + stockCode.getOrderMatchingInOrDe() + " điểm so với ngày hôm qua. ";
				} else {
					return "Một ngày có nhiều biến đổi thăng trầm đối với " + stockCode.getStockCode() +
							", trong ngày đã có thời điểm giá cổ phiếu đạt " + stockCode.getPriceCostlyHistory() +
							" nghìn đồng/1cp, cũng đã có thời điểm giá xuống đến " + stockCode.getPriceLowHistory() +
							" nghìn đồng/1cp, nhưng trốt phiên giá cổ phiếu đã dừng lại ở mốc " + stockCode.getPrice() +
							" bằng với giá chốt phiên ngày hôm qua. ";
				}
			}
		}
		if (stockCode.getPriceCostlyHistory() == stockCode.getPriceLowHistory() && stockCode.getPriceCostlyHistory() == stockCode.getFloor())
			return stockCode.getStockCode() + " hôm nay có giá thấp kỉ lục chỉ bằng giá sàn ở mức " + stockCode.getPrice() +
					" nghìn đồng/1cp. ";
		if (stockCode.getPriceCostlyHistory() == stockCode.getPriceLowHistory() && stockCode.getPriceCostlyHistory() == stockCode.getCeiling())
			return stockCode.getStockCode() + " có giá bán cao vượt trội bằng với giá trần đạt " + stockCode.getPrice() +
					" nghìn đồng/1cp. ";

		if (stockCode.getPriceCostlyHistory() == stockCode.getPriceLowHistory() && stockCode.getPriceCostlyHistory() == stockCode.getReference())
			return "Trước sự biến động của sàn và các mã chứng khoán khác, " + stockCode.getStockCode() +
					" là một trong số các mã đứng giá tham chiếu ở mức " + stockCode.getPrice() + " nghìn đồng/1cp. ";
		return "";
	}
}
