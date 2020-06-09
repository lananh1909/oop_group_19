package com.sentences.indexOfExChange;


import com.modeldatack.TotalDataHOSEModel;
import com.process.FormatDate;
import com.process.FormatNumber;

public class phien1 {
   
    TotalDataHOSEModel totalDataModel;

    public phien1(TotalDataHOSEModel dataModel){
        this.totalDataModel = dataModel;
    }

    public String check(){
        if (totalDataModel.getIncreAndDecre1() > 0 ){
            return " tăng ";
        } else
            return " giảm ";
    }
    public String check1(){
        if (totalDataModel.getIncreAndDecre1() > 0 ){
            return " hào hứng";
        } else
            return " nặng trĩu";
    }
    public String check2(){
        if (totalDataModel.getIncreAndDecre1() > 0 ){
            return " giành được thêm ";
        } else
            return " mất đi ";
    }
    public String check3(){
        if (totalDataModel.getIncreAndDecre1() > 0 ){
            return " có tín hiệu lạc quan, tăng nhẹ ";
        } else
            return " mất ổn định, giảm nhẹ ";
    }
    public String nameOfIndex() {
    	if(totalDataModel.getNameExchange().equals("HOSE"))
    		return "VN-Index";
    	return totalDataModel.getNameExchange() + "-Index";
    }
    public String createSentence(){
    	String sentences [] = {
    			"Mở cửa phiên giao dịch, chỉ số của " + nameOfIndex() + check() + 
    			Math.abs(totalDataModel.getIncreAndDecre1()) + " điểm, đạt " + totalDataModel.getExchangeValue1() + " điểm. ",
    			
    			totalDataModel.getNameExchange() + " khởi đầu phiên giao dịch trong không khí " +
    			check1() + "," + check2() + Math.abs(totalDataModel.getIncreAndDecre1()) + " điểm, chốt đợt đầu ở " + totalDataModel.getIndex1() + " điểm. ",
    			
                "Tiếp tục với những chuyển biến phức tạp trong những ngày qua, mở đầu phiên giao dịch, " +
    			nameOfIndex() + check() + Math.abs(totalDataModel.getIncreAndDecre1()) +
    			" điểm, nhận giá trị " + totalDataModel.getIndex1() + ". ",
    			
    			"Mở cửa ngày " + new FormatDate().formatDate(totalDataModel.getDate()) + ", " + nameOfIndex() +
    			check3() + Math.abs(totalDataModel.getIncreAndDecre1()) + " điểm, nhận giá trị tạm thời là " + totalDataModel.getIndex1() + " điểm. ",
    			
    			"Chốt phiên sáng, " + nameOfIndex() + check() + Math.abs(totalDataModel.getIncreAndDecre1()) +
    			" điểm, đạt " + totalDataModel.getIndex1() + " sang tay " + new FormatNumber().formatNumber(totalDataModel.getExchangeMass1())+
    			" cổ phiếu, tương đương " + totalDataModel.getExchangeValue1() + " tỷ đồng. ",
    			
    			"Đợt một, " + nameOfIndex() + check3() + Math.abs(totalDataModel.getIncreAndDecre1()) + 
    			" điểm, đạt " + totalDataModel.getIndex1() + " giao dịch với " + new FormatNumber().formatNumber(totalDataModel.getExchangeMass1())+
    			" cổ phiếu khớp lệnh, tương đương " + totalDataModel.getExchangeValue1() + " tỷ đồng. "

         	};
    int r = (int) (Math.random()*6);
    return sentences[r];
    }
}
