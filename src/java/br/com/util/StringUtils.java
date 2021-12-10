/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.util;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author sferr
 */
public class StringUtils {
    public static String tiraMascara(String str){
        return str.replace("-", "")
                  .replace("/", "")
                  .replace("(", "")
                  .replace(")", "")
                  .replace("*", "")
                  .replace(".", "")
                  .replace(" ", "");
    }
    
    public static Object nvl(Object obj, Object substituto){
        return obj != null ? obj : (substituto != null ? substituto : "");
    }
    
    public static Object nvl(Object obj){
        return nvl(obj, null);
    }
    
    public static String nvlStr(Object obj, Object substituto){
        return nvl(obj, substituto).toString();
    }
    
    public static String nvlStr(Object obj){
        return nvl(obj, null).toString();
    }
    
    public static String retornaPrefUrl(HttpServletRequest request){
        if(request != null){
        String url = request.getRequestURL().toString();
        String sPath = request.getServletPath();
        
        int indexFim = url.indexOf(sPath);
        
        return url.substring(0,indexFim);
        }
        return "";
    }
}
