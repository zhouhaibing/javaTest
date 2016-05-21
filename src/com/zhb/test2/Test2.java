package com.zhb.test2;

import java.io.UnsupportedEncodingException;

public class Test2 {
  public  int a = 1;
  public  boolean ready;
  
  public class VolatileTest extends Thread{
    @Override
    public void run(){
      while(!ready){
        Thread.yield();
      }
      System.out.println(a);
    }
  }
  public static void main(String[] args) throws UnsupportedEncodingException{    
    Test2 t = new Test2();
    t.new VolatileTest().start();
    t.a = 23;
    t.ready = true;
    
    
    
    //weakHashMapTest();
       
    /*String s = "测试商品str";
    String isoEncodeStr = new String(s.getBytes(),"ISO8859-1");
    System.out.println(isoEncodeStr);
    String decodeFromiso = new String(isoEncodeStr.getBytes("ISO8859-1"),"UTF-8");
    System.err.println(decodeFromiso);
    String result = URLEncoder.encode(decodeFromiso,"UTF-8");
    System.out.println(result);*/
    
    //output : æµè¯ååstr  测试商品str    %E6%B5%8B%E8%AF%95%E5%95%86%E5%93%81str
    
    
  }
  
  /*public static int getRandomNum(int max,int min){
    //return (int)(min+Math.random()*(max-min+1));
    
    return new Random().nextInt(max - min + 1) + min;
  }
  
  public static void weakHashMapTest(){
    String a = new String("a");  
    String b = new String("b");  
    Map weakmap = new WeakHashMap();  
    Map map = new HashMap();  
    Map map2 = new HashMap();
    map.put(a, "aaa");  
    map.put(b, "bbb");  
    
    //map2.put(a, "aaa");  
    //map2.put(b, "bbb");  
    
      
    weakmap.put(a, "aaa");  
    weakmap.put(b, "bbb");  

    map.remove(a);
    //weakmap.remove(a);

    a=null;  
    b=null;  

    System.gc();  
    Iterator i = map.entrySet().iterator();  
    while (i.hasNext()) {  
        Map.Entry en = (Map.Entry)i.next();  
        System.out.println("map:"+en.getKey()+":"+en.getValue());  
    }  
    
    Iterator k = map2.entrySet().iterator();  
    while (k.hasNext()) {  
        Map.Entry en = (Map.Entry)k.next();  
        System.out.println("map2:"+en.getKey()+":"+en.getValue());  
    }  
    
    Iterator j = weakmap.entrySet().iterator();  
    while (j.hasNext()) {  
        Map.Entry en = (Map.Entry)j.next();  
        System.out.println("weakmap:"+en.getKey()+":"+en.getValue());  

    }  
  }*/

}
