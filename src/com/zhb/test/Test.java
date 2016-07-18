package com.zhb.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Test {
	public static void main(String[] args){
	    /*Test t = new Test();
	    String s = "PayInfo.Uid";
	    String[] ss = s.split("\\.");
	    System.out.println(ss[0]);
	    
	    System.out.println(new Date().getTime());*/
	    
	  
	/*	Double d = 3.2;
		System.out.println(String.valueOf(d));
		 
		String s = "zhou dddd   ffff";
		String[] ss = s.split("\\s+");//  \\s琛ㄧず浠ョ┖鏍煎垎鍓�   \\S琛ㄧず浠ラ潪绌烘牸鍒嗗壊
		for(int i=0;i<ss.length;i++){
		    System.out.println(ss[i]);
		}*/
	    
	    //t.jsonTest();
	    /*String jsonStr = "{ \"name\": \"create\", \"params\": {\"pp\" : \"haha\",\"ppp\" : \"haha\"},"
	            + "\"params\": {\"pp\" : \"haha\"} }";
	    System.out.println(t.checkCustomParams(JSONObject.parseObject(jsonStr)));*/
	    
	    
	   /* String s = "PayInfo":{"uid":"9876","productId":"333","productName":"瑗挎父闄嶉瓟","productDesc":"瑗挎父",
	        "productTotalPrice":"100","productUnitPrice":"10","productCount":"10","currencyName":"鍏�",
	        "ext":"330003","notifyURL":"http://10.20.72.72:8090/package/interfaceTest","roleId":"555",
	        "roleName":"鑽変笂椋�","serverId":"666","serverName":"dell","balance":"2999","gameOrderId":"8888",
	        "zoneId":"333","zoneName":"huanamqu"}*/
	    //t.jsonTest();
	  
	  
	 /* String s = "{\"heLLo\":\"world\",\"happy\":\"worldd\"}";
	  JSONObject json = JSON.parseObject(s);
	  System.out.println(json.getString("hello"));// case sensitive
	  */
	  /*SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");//Z represents the GMT/UTC timezone
	  sdff.setTimeZone(TimeZone.getTimeZone("GMT"));
	  System.out.println(sdff.format(new Date()) + sdff.getTimeZone().getID());//shanghai
	  
	  
	  
	    // UTC to localTime
	    long ts = System.currentTimeMillis();
	    Date localTime = new Date(ts);
	    String format = "yyyy/MM/dd HH:mm:ss";
	    SimpleDateFormat sdf = new SimpleDateFormat(format);
	    System.out.println("local time: " + sdf.format(localTime));
	    // Convert Local Time to UTC (Works Fine)
	    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
	    Date gmtTime = new Date(sdf.format(localTime));
	    System.out.println("UTC TIME:" + sdf.format(localTime));


	    // Convert UTC to Local Time
	    String format2 = "yyyy/MM/dd HH:mm:ss";
	    SimpleDateFormat sdf2 = new SimpleDateFormat(format);
	    Date localTime2 = new Date(gmtTime.getTime() + TimeZone.getDefault().getOffset(localTime.getTime()));
	    System.out.println("local time:" + sdf2.format(localTime2));*/
		
		
		BigInteger bi = new BigInteger("12345");
		System.out.println(bi.intValue());

	  
	}
	
	//convert UTC time to local time
	
	
	//diguitest
	private boolean checkCustomParams(JSONObject params){
        Iterator<String> paramsIterator = params.keySet().iterator();
        while(paramsIterator.hasNext()){
            String key = paramsIterator.next();
            String value = params.getString(key);
            if(value == null || value.equals(""))
                return false;
            if(value.startsWith("{") && value.endsWith("}")){
                JSONObject obj = JSON.parseObject(value);
                return checkCustomParams(obj);  
            }
        }
        return true;
    }
	
	public void jsonTest(){
        String jsonStr = "{ \"name\": \"create\", \"params\": {\"pp\" : \"haha\"} }";
        JSONObject data = JSON.parseObject(jsonStr);
        String name = data.getString("name");
        /*JSONObject params = data.getObject("params", JSONObject.class);
        String pp = params.getString("pp");
        System.out.println(name + " " +data.getString("params"));*/
        //Iterator<String> paramsIterator = params.keySet().iterator();
        /*Set<String> iter = data.keySet();
        for(String s : iter){
            System.out.println(s + " "+ data.getString(s));
        }*/
        
        Person p1 = new Person("lala",2,String.valueOf(4));
        String p1s = JSON.toJSONString(p1);
        System.out.println(p1s);
        /*Person p2 = new Person();
        p2.setStr("");
        String p2s = JSON.toJSONString(p2);
        System.out.println(p1s + " " + p2s);
        System.out.println(p2.getName());
        System.out.println(Person.Status.SUCCESS.toString());*/
        
        /*JSONObject oo = JSON.parseObject("{\"xxx\":\"xx\"}");
        System.out.println(oo);*/
        
       /* String s = "^\\{.+\\}$";
        //Pattern p = Pattern.compile(s);
        String str = "{\"xxx\":\"xx\"}";
        System.out.println(str.matches(s));*/
        
        
        //map to json
        Map<String,Object> m1 = new HashMap<String,Object>();
        m1.put("2", "44");
        m1.put("3", "rrr");
        System.out.println(JSON.toJSONString(m1));
    }
	
	
}

class Person{
    private String name;
    private int age;
    private String str;
    private boolean check;
    
    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    public enum Status{
        SUCCESS("success"),
        FAIL("fail"),
        GREAT("great");
        
        private Status(String str){
            this.label = str;
        }
        
        private String label;
        
        public String toString(){
            return super.toString() + " " + this.label;
        }
        
        
        
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the str
     */
    public String getStr() {
        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(String str) {
        this.str = str;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    public Person(){
        
    }
    public Person(String name,int age,String str){
        this.name = name;
        this.age = age;
        this.str = str;
    }
}

    
