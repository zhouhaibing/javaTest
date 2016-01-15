package com.zhb.test2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Set;


public class Test {
    public static void main(String[] args){
       //String configChangeValue = "fontScale|orientation|keyboardHidden|locale|navigation|screenSize|uiMode";
       //System.out.println(combineAttrs("xxx|ddddd", configChangeValue));
      // System.out.println(1/100.f);      
      
        System.out.println(Long.toHexString(3758096641L).toUpperCase());
        System.out.println(Long.valueOf(0));
        Date d = new Date();
        System.out.println(d.getTime());
        
        System.out.println(new Date(d.getTime()));
        
        System.out.println((int)(Math.random()*10));
        
        System.out.println(getRandomNum(0,4)); 
        
        String s = null;
        System.out.println("haha" + s);//hahanull
        
        String pattern = "^[A-Za-z0-9_-]*$";
        String pattern1 = "^[A-Za-z0-9_.+/-]*$";
        String pattern2 = "^[A-Za-z0-9_.-]*$";
        String pattern3 = "^[A-Za-z0-9_.@-]*$";
        String pattern4 = "^.*$";
        String urlpat = "^((http|ftp|https)://)([a-zA-Z0-9._-]+.[a-zA-Z]{2,6})(:[0-9]{1,4})*(/[a-zA-Z0-9&%_./-~-]*)?$";
        
        //urlpat true
        String str = "https://pay.i4.cn/member_third.action?token=";
        
        //"^[A-Za-z0-9_-.+/]*$"; true
        String str1 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRcaxnOHkhSsBuAL4QB/p6q1kKBN33Djm0jH0hWheWfZE3Jb0FS8LeGgqcqTp4zbd44n8ISN+smJxDkOhvx7HzKvYVi2v+ZhK81CZ4Q6S2U+10KjgOCDNWiN+34PHflWwk4rCUuYl5lKb5fJYyXen2iXMcFJeXoOfhVWZ4oPyzwQIDAQAB";
        
        //^[A-Za-z0-9_.-]*$ true
        String str2 = "com.wh.xyfm.i4";
        
        
        String str3 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArplNLNzFJpRjGKqV8mmAalHCFoBTKHM4OimWSBFI6odl2TADAFEHnzJO2wiHSE5HnBxh6Ay7A9jrwxIp4iNlL82j8a9NQxDWlV1k1h8FQIttfDPTFTapkRoiSqZdRgH4JYIMWUYGDVtEaQe449w6J6jSa6o4MorQ0JZ2TdekUSBJ71hEOsQDeQcI/kPSR+q3IifpsEdWG+RkBw0c00cNe+I0P0/gu14Wfnio36AdYnCpe7HiMTxNfNq23cECPSvYJdXdZ8IpnyStTKzDGMK1hGOsTQSJgoi6Ppz2ndMRm3gcNJj52LUGnoMWZpsHuzWrOE+D7MKJpLHk4XzNS2exrwIDAQAB";
        
        String str4 = "qA4Cax@zJhtj7GdTq4NCxm@zhWtjQGdq";
        //String str = "https:";
        System.out.println("regex matches " + str4.matches(pattern2));
        
        
        String VERIFY_SESSION_SIGN_PATTERN = "{0}{1}";
        
        System.out.println(String.format(VERIFY_SESSION_SIGN_PATTERN, "dddd","xxxx"));
        
        System.out.println(java.nio.charset.StandardCharsets.UTF_8.toString());
        try {
            System.out.println(URLEncoder.encode("zhou", java.nio.charset.StandardCharsets.UTF_8.toString()));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    public static boolean getBool(){
        return false || true;
    }
    
    public static int getRandomNum(int min,int max){
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
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

