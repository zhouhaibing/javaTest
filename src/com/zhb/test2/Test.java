package com.zhb.test2;

import com.alibaba.fastjson.JSON;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;


public class Test {
    public static void main(String[] args){
       //String configChangeValue = "fontScale|orientation|keyboardHidden|locale|navigation|screenSize|uiMode";
       //System.out.println(combineAttrs("xxx|ddddd", configChangeValue));
      // System.out.println(1/100.f);      
      
        String s1 = "你好";
        char[] c1 = s1.toCharArray();
        for(int i=0;i<c1.length;i++){
         System.out.println(c1[i]+":"+(int)c1[i]);
        }
        
        System.out.println(getAscii(s1));
        System.out.println(parseAscii(s1));
        
        
        System.out.println(new Date(Long.parseLong("1456715862154")));
        
        System.out.println(isNumeric("123p56"));

    }
    
    public static boolean isNumeric(String str){ 
        Pattern pattern = Pattern.compile("[0-9]+"); 
        return pattern.matcher(str).matches();    
     } 
    
    public static String getAscii(String str) {  
        String tmp;  
        StringBuffer sb = new StringBuffer(1000);  
        char c;  
        int i, j;  
        sb.setLength(0);  
        for (i = 0; i < str.length(); i++) {  
            c = str.charAt(i);  
            if (c > 255) {  
                sb.append("//u");  
                j = (c >>> 8);  
                tmp = Integer.toHexString(j);  
                if (tmp.length() == 1)  
                    sb.append("0");  
                sb.append(tmp);  
                j = (c & 0xFF);  
                tmp = Integer.toHexString(j);  
                if (tmp.length() == 1)  
                    sb.append("0");  
                sb.append(tmp);  
            } else {  
                sb.append(c);  
            }  
      
        }  
        return (new String(sb));  
    }
    
    
    //other way
    private static String toHexUtil(int n){
        String rt="";
        switch(n){
        case 10:rt+="A";break;
        case 11:rt+="B";break;
        case 12:rt+="C";break;
        case 13:rt+="D";break;
        case 14:rt+="E";break;
        case 15:rt+="F";break;
        default:
            rt+=n;
        }
        return rt;
    }
    
    public static String toHex(int n){
        StringBuilder sb=new StringBuilder();
        if(n/16==0){
            return toHexUtil(n);
        }else{
            String t=toHex(n/16);
            int nn=n%16;
            sb.append(t).append(toHexUtil(nn));
        }
        return sb.toString();
    }
    
    public static String parseAscii(String str){
        StringBuilder sb=new StringBuilder();
        byte[] bs=str.getBytes();
        for(int i=0;i<bs.length;i++)
            sb.append(toHex(bs[i]));
        return sb.toString();
    }
    
    public static boolean getBool(){
        return false || true;
    }
    
    
    private static final String TIME_PATTERN = "yyyyMMddHHmmss";
    
    private static final SimpleDateFormat sTsFormat = new SimpleDateFormat(
            TIME_PATTERN, Locale.getDefault());

    protected static String ts() {
        return sTsFormat.format(new Date(System.currentTimeMillis()));
    }
    
    private static String combineAttrs(String attrValue,String configChangeValue){
        String[] orignalAttrs = attrValue.split("\\|");
        Set<String> originalSet = arrayToSet(orignalAttrs);
        
        String[] fixedAttrs = configChangeValue.split("\\|");
        Set<String> fixedSet = arrayToSet(fixedAttrs);
        fixedSet.addAll(originalSet);
        
        StringBuilder sb = new StringBuilder();
        for(Iterator<String> iter = fixedSet.iterator();iter.hasNext();){
            sb.append(iter.next()).append("|");
        }
        String finalStr = sb.toString().substring(0, sb.toString().length()-1);
        return finalStr;
    }
    
    private static Set<String> arrayToSet(String[] attrs){
        Set<String> set = new HashSet<String>();
        for(String attr : attrs){
            set.add(attr);
        }
        return set;
    }
    
    

}

