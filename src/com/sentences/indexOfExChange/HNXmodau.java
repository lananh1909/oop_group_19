package com.sentences.indexOfExChange;

import com.modelDataCK.TotalDataHNXModel;
import com.process.FormatDate;
import com.process.FormatNumber;

public class HNXmodau {
    private TotalDataHNXModel totalDataHNXModel;

    public HNXmodau(TotalDataHNXModel dataHNXModel){
        this.totalDataHNXModel = dataHNXModel;
    }

    public String check(){
        if (totalDataHNXModel.getIncreaseAndDecrease() > 0 ){
            return " tăng ";
        } else
            return " giảm ";
    }
    public String check1(){
        if (totalDataHNXModel.getIncreaseAndDecrease() > 0 ){
            return " đi lên ";
        } else
            return " đi xuống ";
    }
    public String check2(){
        if (totalDataHNXModel.getIncreaseAndDecrease() > 0 ){
            return " lên ";
        } else
            return " rớt ";
    }
    public String check3(){
        if (totalDataHNXModel.getIncreaseAndDecrease() > 0 ){
            return " tiến lên ";
        } else
            return " lùi về ";
    }
    public String check4(){
        if (totalDataHNXModel.getIncreaseAndDecrease() > 0 ){
            return " nhiều mã chứng khoán được giá";
        } else
            return " nhiều mã chứng khoán mất giá";
    }
    public String check5(){
        if (totalDataHNXModel.getIncreaseAndDecrease() > 0 ){
            return " Được nhiều lực nâng đỡ ";
        } else
            return " Thiếu lực nâng đỡ ";
    }
    public String createSentence(){
    	String sentences [] = {
    		"Cuối phiên giao dịch ngày " + new FormatDate().formatDate(totalDataHNXModel.getDate()) + ", " + totalDataHNXModel.getNameExchange() + "-Index" +
    		check() + Math.abs(totalDataHNXModel.getIncreaseAndDecrease()) + " điểm, đạt " + totalDataHNXModel.getIndex() + " điểm, chuyển nhượng "
    		+ new FormatNumber().formatNumber(totalDataHNXModel.getExchangeMass()*10) +" cổ phiếu, đạt " 
    		+ new FormatNumber().formatNumber(totalDataHNXModel.getExchangeValue()) + " tỷ đồng. ",
    		
    		"Đóng cửa, " + totalDataHNXModel.getNameExchange() + " chốt phiên giao dịch ngày " +
    		new FormatDate().formatDate(totalDataHNXModel.getDate()) + " ở " + totalDataHNXModel.getIndex()
    		+ " điểm," + check() + Math.abs(totalDataHNXModel.getIncreaseAndDecrease()) + " điểm, chuyển nhượng " + new FormatNumber().formatNumber(totalDataHNXModel.getExchangeMass()*10)
    		+ " cổ phiếu, tương đương " + totalDataHNXModel.getExchangeValue() + " tỷ đồng. ",
    		
    		"Chốt những giây giao dịch cuối cùng của ngày " + new FormatDate().formatDate(totalDataHNXModel.getDate()) 
    		+ ", " + totalDataHNXModel.getNameExchange() + "-Index" 
    		+ check1() + Math.abs(totalDataHNXModel.getIncreaseAndDecrease()) + " điểm," + check3() +
    		+ totalDataHNXModel.getIndex() + " điểm, giao dịch " + new FormatNumber().formatNumber(totalDataHNXModel.getExchangeMass()) +
    		" cổ phiếu, ứng với " + totalDataHNXModel.getExchangeValue() + " tỷ đồng. ",
    		
    		"Cuối ngày " + new FormatDate().formatDate(totalDataHNXModel.getDate()) + check4() 
    		+ "khiến " + totalDataHNXModel.getNameExchange() + "-Index" + check() + Math.abs(totalDataHNXModel.getIncreaseAndDecrease()) +
    		" điểm," + check1() + totalDataHNXModel.getIndex() + " điểm, sang tay " + new FormatNumber().formatNumber(totalDataHNXModel.getExchangeMass()*10) +" cổ phiếu, tương đương " +
    				totalDataHNXModel.getExchangeValue() + " tỷ đồng. ",
    				
    		"Đóng cửa giao dịch," + check4() + ", " + totalDataHNXModel.getNameExchange() + "-Index" 
    		+ check2() + Math.abs(totalDataHNXModel.getIncreaseAndDecrease()) + " điểm, tạm dừng lại ở vùng " +
    		totalDataHNXModel.getIndex() + " điểm, mua bán " + new FormatNumber().formatNumber(totalDataHNXModel.getExchangeMass()) + " cổ phiếu, trị giá " + totalDataHNXModel.getExchangeValue() +
    		" tỷ đồng. ",
    		
    		check5() + "chốt phiên cuối " + totalDataHNXModel.getNameExchange() + check() + Math.abs(totalDataHNXModel.getIncreaseAndDecrease()) +
    		" điểm," + check3() + totalDataHNXModel.getIndex() + " điểm, giao dịch " + new FormatNumber().formatNumber(totalDataHNXModel.getExchangeMass()) + " cổ phiếu, trị giá " +
    		totalDataHNXModel.getExchangeValue() + " tỷ đồng. "	
    		
   	};
    	int r = (int) (Math.random()*6);
        return sentences[r];
        }
}
