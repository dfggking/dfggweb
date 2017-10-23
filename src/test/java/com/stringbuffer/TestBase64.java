package com.stringbuffer;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author dfggking@hotmail.com
 * @create 2017-09-11
 * @since 1.0
 */
public class TestBase64{
    
    public static void main(String[] args){
        
        
        getFromBase64(getBase64("tom"));
        
    }
    
    
    private static String getBase64(String str) {
        try{
            String asb64 = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
            System.out.println(asb64);
            return asb64;
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }
    
    private static String getFromBase64(String str) {
        
        byte[] asBytes = Base64.getDecoder().decode(str);
        try{
            System.out.println(new String(asBytes, "utf-8"));
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }
    
}
