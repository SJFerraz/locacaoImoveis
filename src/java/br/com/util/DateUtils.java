
package br.com.util;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sferr
 */
public class DateUtils {
    
    public static String defineDateMaskFromDtStr(String dateString){
        String mask = null;
        if(dateString.contains("/")){
            mask = "dd/MM/yyyy";
        }else if(dateString.contains("-")){
            mask = "yyyy-MM-dd";
        }
        
        if(dateString.contains(":")){
            mask += " HH:mm:ss";
        }
        
        return mask;
    }
    
    public static Date stringToDate(String dateString, String mask){
        try {
            return new SimpleDateFormat(mask).parse(dateString);
        } catch (ParseException | NullPointerException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }   
    
    
    public static Date stringToDate(String dateString){
        String mask = defineDateMaskFromDtStr(dateString);        
        return stringToDate(dateString, mask);
    }
    
    public static String dateToString(Date date, String mask){
        if(date != null){            
            return new SimpleDateFormat(mask).format(date);
        }        
        return "";
    }
    
    public static String dateToString(Date date){
        return dateToString(date, "dd/MM/yyyy");
    }
        
    
    public static Date convertSqlDateToUtil(java.sql.Date sqlDate){
        return new Date(sqlDate.getTime()); 
    }
    
    public static java.sql.Date convertUtilDateToSql(Date utilDate){
        if(utilDate != null){
            return new java.sql.Date(utilDate.getTime()); 
        }
        return null;        
    }
    
    public static java.sql.Date stringToDateSql(String dateString, String mask){
        return convertUtilDateToSql(stringToDate(dateString, mask));
    }
    
    public static java.sql.Date stringToDateSql(String dateString){
        return convertUtilDateToSql(stringToDate(dateString));
    }
}
