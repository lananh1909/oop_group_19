package com.sentences.indexOfExChange;

import com.modelDataCK.TotalDataHOSEModel;
import com.process.FormatNumber;

public class IndexSentenceHOSE {
    private TotalDataHOSEModel totalDataHOSEModel;

    public IndexSentenceHOSE(TotalDataHOSEModel dataModel){
        this.totalDataHOSEModel = dataModel;
    }

    public String check(){
        if (totalDataHOSEModel.getIncreaseAndDecrease() > 0 ){
            return " tang ";
        } else
            return " giam ";
    }

    public String createSentence(){
    	String nameOfIndex = "";
    	switch (totalDataHOSEModel.getNameExchange()) {
    	case "HOSE":
    		nameOfIndex = "VN-Index";	break;
    	case "VN30":
    		nameOfIndex = "VN30-Index";	break;    		
    	}

        return "Kết thúc ngày giao dịch, " +  nameOfIndex + check() +
                Math.abs(totalDataHOSEModel.getIncreaseAndDecrease()) + " điểm (" + totalDataHOSEModel.getPercentIncreaseAndDecrease()
                + "%), đạt " + totalDataHOSEModel.getIndex() + ". Giá trị giao dịch trên " +
                totalDataHOSEModel.getNameExchange() + " đạt: " + new FormatNumber().formatNumber(totalDataHOSEModel.getExchangeValue3()) +
                " tỷ đồng, khối lượng đạt: " + new FormatNumber().formatNumber(totalDataHOSEModel.getExchangeMass3()) + " cổ phiếu. ";
    }
}
