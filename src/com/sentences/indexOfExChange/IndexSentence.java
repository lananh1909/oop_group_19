package com.sentences.indexOfExChange;

import com.modelDataCK.TotalDataHNXModel;
import com.process.FormatNumber;

public class IndexSentence {
    private TotalDataHNXModel totalDataHNXModel;

    public IndexSentence(TotalDataHNXModel dataHNXModel){
        this.totalDataHNXModel = dataHNXModel;
    }

    public String check(){
        if (totalDataHNXModel.getIncreaseAndDecrease() > 0 ){
            return " tang ";
        } else
            return " giam ";
    }

    public String createSentence(){

        return "ket thuc ngay giao dich, " + totalDataHNXModel.getNameExchange() + check() +
                Math.abs(totalDataHNXModel.getIncreaseAndDecrease()) + "diem (" + totalDataHNXModel.getPercentIncreaseAndDecrease()
                + "%), dat " + totalDataHNXModel.getIndex() + ". Gia tri giao dich tren " +
                totalDataHNXModel.getNameExchange() + " dat : " + totalDataHNXModel.getExchangeValue() +
                " ty dong, khoi luong dat: " + new FormatNumber().formatNumber(totalDataHNXModel.getExchangeMass()) + " co phieu";
    }
}
//Kết thúc tuần giao dịch, VN-Index tăng 25,71 điểm (+3,11%), lên 852,74 điểm. Giá trị giao dịch
// trên HOSE giảm 10,7% xuống 26.534 tỷ đồng, khối lượng giảm 8,4% xuống 1.510 triệu cổ phiếu.