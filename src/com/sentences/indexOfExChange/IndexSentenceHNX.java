package com.sentences.indexOfExChange;

import com.modelDataCK.TotalDataHNXModel;
import com.process.FormatNumber;

public class IndexSentenceHNX {
    private TotalDataHNXModel totalDataHNXModel;

    public IndexSentenceHNX(TotalDataHNXModel dataHNXModel){
        this.totalDataHNXModel = dataHNXModel;
    }

    public String check(){
        if (totalDataHNXModel.getIncreaseAndDecrease() > 0 ){
            return " tang ";
        } else
            return " giam ";
    }

    public String createSentence(){

        return "Kết thúc ngày giao dịch, " + totalDataHNXModel.getNameExchange() + "-Index"+ check() +
                Math.abs(totalDataHNXModel.getIncreaseAndDecrease()) + " điểm (" + totalDataHNXModel.getPercentIncreaseAndDecrease()
                + "%), đạt " + totalDataHNXModel.getIndex() + ". Giá trị giao dịch trên " +
                totalDataHNXModel.getNameExchange() + " đạt: " + new FormatNumber().formatNumber(totalDataHNXModel.getExchangeValue()) +
                " tỷ đồng, khối lượng đạt: " + new FormatNumber().formatNumber(totalDataHNXModel.getExchangeMass()) + " cổ phiếu. ";
    }
}
//Kết thúc tuần giao dịch, VN-Index tăng 25,71 điểm (+3,11%), lên 852,74 điểm. Giá trị giao dịch
// trên HOSE giảm 10,7% xuống 26.534 tỷ đồng, khối lượng giảm 8,4% xuống 1.510 triệu cổ phiếu.