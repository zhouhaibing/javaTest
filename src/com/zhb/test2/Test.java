package com.zhb.test2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
    private static final String SIGN_PATTERN = "orderid={0}&username={1}&gameid={2}";
    private static final String PARAM_PATTERN = "appId={1}&ucid={2}&uid={3}&uuid={4}";// this is error. 1 get the param of index one
    
    public static void main(String[] args) throws UnsupportedEncodingException{
       
        //中文匹配
        String regex1 = "[\u4e00-\u9fa5]*";
        String regex2 = "[A-Za-z0-9_-]*";
        //中文和字符交叉
        String regex3 = "([\u4e00-\u9fa5]*[A-Za-z0-9_-]*)|([A-Za-z0-9_-]*[\u4e00-\u9fa5]*)";
        System.out.println("大神".matches(regex3));
        
        String str = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}(\\,(?:[0-9]{1,3}\\.){3}[0-9]{1,3})*$";
        System.out.println("42.62.45.134,42.62.45.134".matches(str));
        
        System.out.println("---------------------");
        //String configChangeValue = "fontScale|orientation|keyboardHidden|locale|navigation|screenSize|uiMode";
       //System.out.println(combineAttrs("xxx|ddddd", configChangeValue));
      // System.out.println(1/100.f);  
        String orderid = "";
        String username = "";
        String gameid = "yyy";
        try {
            System.out.println(MessageFormat.format(SIGN_PATTERN, URLEncoder.encode(orderid,"UTF-8"),username,gameid));
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        System.out.println(URLEncoder.encode("zhou/+/", "UTF-8"));
        
        
        
        System.out.println(getSpecificFormatDate("yyyyMMddHHmmss",-1));
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        System.out.println(cal.getTime());
        
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(format.format(new Date()));
        
        /*int hex = 0x00ff00;
        System.out.println(hex);
        System.out.println(Integer.parseInt("00ff00", 16));//("0x00ff00", 16)) is error
        System.out.println(Long.toHexString(3758096641L).toUpperCase());
        System.out.println(Long.valueOf(0));
        Date d = new Date();
        System.out.println(d.getTime());
        
        System.out.println(new Date(d.getTime()));
        
        System.out.println((int)(Math.random()*10));
        
        System.out.println(getRandomNum(0,4)); */
        
        /*String s = null;
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
        }*/
        
        
        String userid = "lhh123";
        String name = "lhh123";
        String accesstoken = "43a2eed59ac7867187f7ae46ea33e496";
        
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("state", "1");
        jsonObj.put("msg", "success");
        JSONObject dataObj = new JSONObject();
        dataObj.put("username", name);
        dataObj.put("uid", userid);
        //jsonObj.put("data", dataObj.toJSONString());
        jsonObj.put("data", dataObj);
        
        String str2 = jsonObj.toJSONString();
        JSONObject str2Obj = JSON.parseObject(str2);
        JSONObject oo = str2Obj.getJSONObject("data");
        System.out.println(oo.getString("uid"));
        
        
        //
        System.out.println("the priority of the operator");
        System.out.println((int)(new Date().getTime()/1000));//this is right
        System.out.println((int)new Date().getTime()/1000);//this is error.first to cast to int
        
        
        Pattern pat = Pattern.compile("^(.+)\\.uc$");
        System.out.println(pat.matcher("zhou.xx.ll.uc").matches());
        
        Pattern pat2 = Pattern.compile("^.+(\\.(baidu|BD))$");
        System.out.println(pat2.matcher("dd.xxx.BD").matches());
        
        Pattern pat3 = Pattern.compile("^.+(.(dl)|(downjoy))$");
        System.out.println(pat3.matcher("dd.xxx.downjoy").matches());
        
        Pattern pat4 = Pattern.compile("^.+(\\.itools\\.sky)$");
        System.out.println(pat4.matcher("dd.xxx.itools.sky").matches());
        
        Pattern pat5 = Pattern.compile("^.+\\.tencent\\.tmgp\\..+$");
        System.out.println(pat5.matcher("dd.tencent.tmgp.sky").matches());
        
        System.out.println(MessageFormat.format("{0}|{1}", String.valueOf(123456),"hello world"));
        
        
        System.out.println(MessageFormat.format(PARAM_PATTERN, "hello","world"));
        
        
        System.out.println("123456--------------");
        String strr = "{msg=1234,returnCode=123}";
        //Pattern pat1 = Pattern.compile("^\\{returnCode=(?<returnCode>\\d+)(,msg=(?<msg>.*))?\\}|(\\{msg=(?<msg2>.*),returnCode=(?<returnCode2>.+)\\})?$");
        //Pattern pat1 = Pattern.compile("(?<key>\\w+)=(?<value>\\w+");
        Pattern pat1 = Pattern.compile("^\\{(?=.*returnCode=(?<returnCode>\\d+))(?=.*msg=(?<msg>\\d+)).+\\}$");
        // function: returnCode and msg must exist and match =(....)
        
        //Pattern pat1 = Pattern.compile("^\\{(?=returnCode=(?<returnCode>\\d+))(?=,msg=(?<msg>.*))?\\}$");
        //boolean b = Pattern.matches("a*b", "aaaaab"); this is fast way to match
        
        
        
        Matcher mat = pat1.matcher(strr);
        System.out.println(pat1.matcher(strr).matches()); 
        mat.find(); //must do this before call group method
        System.out.println(mat.group("returnCode"));//1235
        //System.out.println("group msg :" + mat.group("msg"));
        System.out.println(mat.group("msg"));//
          
        System.out.println(Pattern.matches("^[A-Za-z0-9_/%-.]*$", "45612dddddd+")); //the . isn't a simple character 
        System.out.println(Pattern.matches(".{0,3}","dd"));  
        
        
        System.out.println(strr.split("\\{|=|,|\\}")[1]);
        for(String s : strr.split("\\{|=|,|\\}")){
          System.out.println(s);
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
    
    public static String getSpecificFormatDate(String pattern,int addDays){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, addDays);
        String defaultPat = "yyyy-MM-dd HH:mm:ss";
        if(!StringUtils.isEmpty(pattern)){
            defaultPat = pattern;
        }
        
        SimpleDateFormat format = new SimpleDateFormat(defaultPat);
        return format.format(cal.getTime());
    }
    
    

}

