package com.sentences.exchangeOnDay;

import java.util.ArrayList;
import java.util.List;

import com.modelDataCK.GenericTotalModel;
import com.modelDataCK.StockModel;

public class TangVotGiamManh extends MaGiaBanCao {
	private GenericTotalModel generic;
	
	public TangVotGiamManh (List<StockModel> today, GenericTotalModel generic) {
		super(today);
		this.generic = generic;
	}
	
	public List<StockModel> findCeiling () {
		List<StockModel> lst = new ArrayList<StockModel>();
		for (StockModel s: today) {
			if (s.getPrice() == s.getCeiling())
				lst.add(s);
		}
		return lst;
	}
	
	public List<StockModel> findFloor () {
		List<StockModel> lst = new ArrayList<StockModel>();
		for (StockModel s: today) {
			if (s.getPrice() == s.getFloor())
				lst.add(s);
		}
		return lst;
	}
	
	@Override
	public String createSentence () {
		String nameOfIndex = "";
    	if (generic.getNameExchange().equals("HOSE")) {
    		nameOfIndex = "VN-Index";
    	} else {
    		nameOfIndex = generic.getNameExchange() + "-Index";
    	}
    	
		List<StockModel> lst = findCeiling();
		if (lst.size() >= 3 && generic.getIncreaseAndDecrease() > 0) {
			String code = "";
			for (int i = 0; i<lst.size(); i++) {
				code += lst.get(i).getStockCode() + ", ";
				if (i==3 || i == (lst.size() - 2)) {
					code += lst.get(i+1).getStockCode();
					break;
				}
			}
			return "Tiêu biểu nhất trong ngày là các mã cổ phiếu có mức tăng vọt " + code +
					" lần lượt dựng trần và tạo ra lực đẩy lớn giúp chỉ số " + nameOfIndex +
					" tăng dốc. ";
		}
		
		List<StockModel> lst1 = findFloor();
		
		if (lst1.size() >= 3 && generic.getIncreaseAndDecrease() < 0) {
			String code1 = "";
			for (int i = 0; i<lst1.size(); i++) {
				code1 += lst1.get(i).getStockCode() + " (" + lst.get(i).getOrderMatchingInOrDe() + " điểm), ";
				if (i==3 || i == (lst1.size() - 2)) {
					code1 += lst1.get(i+1).getStockCode() + " (" + lst.get(i).getOrderMatchingInOrDe() + " điểm)";
					break;
				}
			}
			return lst1.size() + " cổ phiếu có tác động giảm điểm lớn nhất tới " + nameOfIndex +
					" xuống " + Math.abs(generic.getIncreaseAndDecrease()) + " điểm, trong đó "
					+ code1 + " là những mã có tác động mạnh nhất. ";
		}
		return "";
	}
}
//Tiêu biểu nhất trong ngày là các mã cổ phiếu có mức tăng vọt (cột 1 = cột 12);
//( BVH, ITA, KBC, OGC, REE, SAM, SSI… lần lượt dựng trần và tạo ra lực đẩy lớn giúp Vn-Index tăng tốc )