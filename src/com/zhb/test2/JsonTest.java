package com.zhb.test2;

import com.alibaba.fastjson.JSON;
/**
 * fast json test 
 * @author ZHOUHAIBING
 *
 */
public class JsonTest {
    public static void main(String[] args){
        
        //String json = "{\"name\":{\"first\":\"zhou\",\"second\":\"hai\"},\"age\":\"10\",\"hoppy\":\"base\"}";
        //String json = "{\"name\":\"\",\"age\":\"10\",\"hoppy\":\"base\"}";//error
        //String json = "{\"name\":{\"\"},\"age\":\"10\",\"hoppy\":\"base\"}";//error
        String json = "{\"hoppy\":null}";//equal to  "{\"age\":\"10\"}"
        //String json = "{\"age\":\"10\",\"hoppy\":\"\"}";
        Person p = JSON.parseObject(json,Person.class);
        //System.out.println(p.getName().getFirst());
        System.out.println(p.getHoppy());
        System.out.println(p.getAge());
        System.out.println(JSON.toJSONString(p));
        
        
        //object to json
        Person p1 = new Person();
        p1.setName(null);
        p1.setAge(2);
        p1.setHoppy(null);
        System.out.println(JSON.toJSONString(p1));
        
        
        /**
         * object ot json. 
         * 1.if you set anything to attribute ,the json str can present it even if the value of attribute is empty string.
         * 2.if you set value is null or no set,  there is no exist this attribute in the json string.
         * 3."{\"hoppy\":null}";//equal to  "{\"age\":\"10\"}"
         */
        
        
    }

}

class Person{
    private Name name;
    private int age;
    private String hoppy;
    /**
     * @return the name
     */
    public Name getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(Name name) {
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
    /**
     * @return the hoppy
     */
    public String getHoppy() {
        return hoppy;
    }
    /**
     * @param hoppy the hoppy to set
     */
    public void setHoppy(String hoppy) {
        this.hoppy = hoppy;
    }
    
    
}

class Name {
    private String first;
    private String second;
    /**
     * @return the first
     */
    public String getFirst() {
        return first;
    }
    /**
     * @param first the first to set
     */
    public void setFirst(String first) {
        this.first = first;
    }
    /**
     * @return the second
     */
    public String getSecond() {
        return second;
    }
    /**
     * @param second the second to set
     */
    public void setSecond(String second) {
        this.second = second;
    }
    
}
