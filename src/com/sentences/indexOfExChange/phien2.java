package com.sentences.indexOfExChange;


import com.modelDataCK.TotalDataHOSEModel;
import com.process.FormatNumber;

public class phien2 extends phien1{
    public phien2(TotalDataHOSEModel dataModel){
    	super(dataModel);
    }
    
    @Override
    public String check(){
        if (totalDataModel.getIncreAndDecre2() > 0 ){
            return " tăng ";
        } else
            return " giảm ";
    }
    
    @Override
    public String check1(){
        if (totalDataModel.getIncreAndDecre2() > 0 ){
            return " hào hứng";
        } else
            return " nặng trĩu";
    }
    
    @Override
    public String check2(){
        if (totalDataModel.getIncreAndDecre2() > 0 ){
            return " giành được thêm ";
        } else
            return " mất đi ";
    }
    
    @Override
    public String check3(){
        if (totalDataModel.getIncreAndDecre2() > 0 ){
            return " vọt lên ";
        } else
            return " hạ xuống ";
    }
    
    public String createSentence(){
    	String sentences [] = {
    			"Nghỉ giữa phiên, " + nameOfIndex() + check() + 
    			Math.abs(totalDataModel.getIncreAndDecre2()) + " điểm, đạt " + totalDataModel.getIndex1() + " điểm.",
    			
    			"Bước sang phiên giao dịch chiều, " + totalDataModel.getNameExchange() + " trong không khí " +
    			check1() + ", " + nameOfIndex() + check2() + Math.abs(totalDataModel.getIncreAndDecre2()) +
    			" điểm, chốt đợt hai ở " + totalDataModel.getIndex2() + ". ",
    			
                "Chốt phiên giữa, " + nameOfIndex() + check() + Math.abs(totalDataModel.getIncreAndDecre2()) +
    			" điểm," + check3() + totalDataModel.getIndex2() + " sang tay " +
                new FormatNumber().formatNumber(totalDataModel.getExchangeMass2()) + " cổ phiếu, tương đương "+
                totalDataModel.getExchangeValue2() + " tỷ đồng. ",
    			
    			"Kết thúc đợt 2, "  + nameOfIndex() + " tạm dừng ở " + totalDataModel.getIndex2() +
    			check() + Math.abs(totalDataModel.getIncreAndDecre2()) + " điểm, khối lượng giao dịch đạt " + 
    			new FormatNumber().formatNumber(totalDataModel.getExchangeMass2()) +
    			" tương đương " + totalDataModel.getExchangeValue2() + " tỷ đồng. ",
    			
    			"Trong đợt hai, có " + new FormatNumber().formatNumber(totalDataModel.getExchangeMass2()) + " cổ phiếu được chuyển nhượng (tương đương "+
    			totalDataModel.getExchangeValue2() + " tỷ đồng), " +  nameOfIndex() + check2() +
    			totalDataModel.getIncreAndDecre2() + " điểm, đạt " +
    				totalDataModel.getIndex2() + " điểm. ",
    			
    			" Đợt hai, " + nameOfIndex() + check3() + Math.abs(totalDataModel.getIncreAndDecre2()) + 
    			", đạt " + totalDataModel.getIndex2() + " giao dịch với " + new FormatNumber().formatNumber(totalDataModel.getExchangeMass2())+
    			" cổ phiếu khớp lệnh, tương đương " + totalDataModel.getExchangeValue2() + " tỷ đồng. "
    			
    			
         	};
    int r = (int) (Math.random()*6);
    return sentences[r];
    }
}
 