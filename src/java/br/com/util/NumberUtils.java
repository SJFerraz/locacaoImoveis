package br.com.util;


import java.math.BigDecimal;


/**
 *
 * @author sferr
 */
public class NumberUtils {
    public static BigDecimal stringToDecimal(String strNumber){
        return new BigDecimal(trocaPontosStrDecimal(strNumber, ",", "."));
    }
    
    public static String trocaPontosStrDecimal(String strNumber, String caracterAntes, String caracterDepois){
        return strNumber.replace(caracterDepois, "").replace(caracterAntes, caracterDepois);
    }
    
    public static String decimalToString(BigDecimal number){
        if(number != null){            
            return trocaPontosStrDecimal(number.toString(),".", ",");
        }
        return "";
    }
}
