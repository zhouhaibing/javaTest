package com.zhb.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {
	public static void main(String[] args){
	    Test t = new Test();
	    String s = "PayInfo.Uid";
	    String[] ss = s.split("\\.");
	    System.out.println(ss[0]);

	    
	/*	Double d = 3.2;
		System.out.println(String.valueOf(d));
		
		String s = "zhou dddd   ffff";
		String[] ss = s.split("\\s+");//  \\s表示以空格分割   \\S表示以非空格分割
		for(int i=0;i<ss.length;i++){
		    System.out.println(ss[i]);
		}*/
	    
	    //t.jsonTest();
	    /*String jsonStr = "{ \"name\": \"create\", \"params\": {\"pp\" : \"haha\",\"ppp\" : \"haha\"},"
	            + "\"params\": {\"pp\" : \"haha\"} }";
	    System.out.println(t.checkCustomParams(JSONObject.parseObject(jsonStr)));*/
	    
	    
	   /* String s = "PayInfo":{"uid":"9876","productId":"333","productName":"西游降魔","productDesc":"西游",
	        "productTotalPrice":"100","productUnitPrice":"10","productCount":"10","currencyName":"元",
	        "ext":"330003","notifyURL":"http://10.20.72.72:8090/package/interfaceTest","roleId":"555",
	        "roleName":"草上飞","serverId":"666","serverName":"dell","balance":"2999","gameOrderId":"8888",
	        "zoneId":"333","zoneName":"huanamqu"}*/
	    t.jsonTest();
	}
	
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

    
