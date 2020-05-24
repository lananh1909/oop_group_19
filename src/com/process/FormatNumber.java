package com.process;

import java.text.DecimalFormat;

public class FormatNumber {
    public String formatNumber(double number){
        String patern = "###,###.###";
        DecimalFormat df = new DecimalFormat(patern);
        return df.format(number);
    }
}
