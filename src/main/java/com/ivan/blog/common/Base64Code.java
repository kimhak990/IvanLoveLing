package com.ivan.blog.common;

import org.apache.commons.codec.binary.Base64;
/**
 * Created by ivankim on 2017. 3. 30..
 */
public class Base64Code {
    public static String base64Encode(String str) throws java.io.IOException{
        if (str == null || str.equals("")){
            return "";
        }else{
            return Base64.encodeBase64URLSafeString(str.getBytes());
        }
    }

    public static String base74Decode(String str) throws java.io.IOException{
        if(str == null || str.equals("")){
            return "";
        }else{
            return new String(Base64.decodeBase64(str));
        }
    }
}
