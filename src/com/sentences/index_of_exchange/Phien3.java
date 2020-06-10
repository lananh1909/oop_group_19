package com.sentences.index_of_exchange;


import com.modeldatack.TotalDataHOSEModel;
import com.process.FormatDate;
import com.process.FormatNumber;

public class Phien3 extends Phien1 {

    public Phien3(TotalDataHOSEModel dataModel){
    	super(dataModel);
    }
    
    @Override
    public String check(){
        if (totalDataModel.getIncreAndDecre3() > 0 ){
            return " tăng ";
        } else
            return " giảm ";
    }
    
    @Override
    public String check1(){
        if (totalDataModel.getIncreAndDecre3() > 0 ){
            return " hào hứng";
        } else
            return " nặng trĩu";
    }
    
    @Override
    public String check2(){
        if (totalDataModel.getIncreAndDecre3() > 0 ){
            return " giành được thêm ";
        } else
            return " mất đi ";
    }
    
    @Override
    public String check3(){
        if (totalDataModel.getIncreAndDecre3() > 0 ){
            return " vọt lên ";
        } else
            return " hạ xuống ";
    }
    
    public String check4(){
        if (totalDataModel.getIncreAndDecre3() > 0 ){
            return " nhờ lực đẩy của Blue-chip, ";
        } else
            return " nhờ lực kéo của Red-chip, ";
    }
    public String createSentence(){
    	String sentences [] = {
    			"Đóng cửa phiên, " + nameOfIndex() + check() + 
    			Math.abs(totalDataModel.getIncreAndDecre3()) + " điểm, đạt " + totalDataModel.getIndex1() + " điểm. ",
    			
    			"Kết thúc phiên giao dịch cuối ngày " + new FormatDate().formatDate(totalDataModel.getDate()) + " trong không khí" +
    			check1() + " của phiên giao dịch cuối cùng trong ngày, " + nameOfIndex()
    			+ check3() + "chốt đợt 3 ở " + totalDataModel.getIndex3() + " điểm. ",
    			
                "Chốt phiên chiều, " + nameOfIndex() + check() + Math.abs(totalDataModel.getIncreAndDecre3()) +
    			" điểm," + check3() + totalDataModel.getIndex3() + " sang tay " + new FormatNumber().formatNumber(totalDataModel.getExchangeMass3()) + " cổ phiếu, tương đương "+
                totalDataModel.getExchangeValue3() + " tỷ đồng. ",
    			
    			"Chốt phiên giao dịch ngày, "  + nameOfIndex() + " tạm dừng ở " + totalDataModel.getIndex3() +
    			check() + Math.abs(totalDataModel.getIncreAndDecre3()) + " điểm, khối lượng giao dịch đạt " + new FormatNumber().formatNumber(totalDataModel.getExchangeMass3()) +
    			" tương đương " + totalDataModel.getExchangeValue3() + " tỷ đồng. ",
    			
    			"Trong đợt ba, có " + new FormatNumber().formatNumber(totalDataModel.getExchangeMass3()) + " cổ phiếu được chuyển nhượng (tương đương "+
    			totalDataModel.getExchangeValue3() + " tỷ đồng), " + nameOfIndex() + check3() + "đạt " +
    				totalDataModel.getIndex3() + " điểm. ",
    			 
    			"Chốt phiên giao dịch ngày " + new FormatDate().formatDate(totalDataModel.getDate()) + " sàn " + totalDataModel.getNameExchange() + " có nhiều mã tăng giá cũng có nhiều mã giảm giá, tuy nhiên" + 
    			check4() + nameOfIndex() + check() + Math.abs(totalDataModel.getIncreAndDecre3()) + " điểm, đạt " +
         		new FormatNumber().formatNumber(totalDataModel.getExchangeMass3()) + " cổ phiếu, ứng với " + totalDataModel.getExchangeValue2() + " tỷ đồng."
    			
         	};
    int r = (int) (Math.random()*6);
    return sentences[r];
    }
}
 