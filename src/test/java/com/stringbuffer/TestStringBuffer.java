package com.stringbuffer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author dfggking@hotmail.com
 * @create 2017-09-11
 * @since 1.0
 */
public class TestStringBuffer{
    
    
    
    public static void main(String[] args){
        
        MessageDigest md = null;
        
        try{
            md = MessageDigest.getInstance("MD5");
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        
        md.reset();
        String pwd = "123456";
        md.update(pwd.getBytes());
        
        
        byte[] bArray = md.digest();
        
        
        
        
    }
    
    
    
}
