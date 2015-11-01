package com.zhb.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Model {
	 public HashMap<String, String> extraData = new HashMap<String, String>();
	 private int productCount;
	 private String exchangeRate;
	 private double dd;
	/**
     * @return the dd
     */
    public double getDd() {
        return dd;
    }
    /**
     * @param dd the dd to set
     */
    public void setDd(double dd) {
        this.dd = dd;
    }
    /**
	 * @return the extraData
	 */
	public HashMap<String, String> getExtraData() {
		return extraData;
	}
	/**
	 * @param extraData the extraData to set
	 */
	public void setExtraData(HashMap<String, String> extraData) {
		this.extraData = extraData;
	}
	/**
	 * @return the productCount
	 */
	public int getProductCount() {
		return productCount;
	}
	/**
	 * @param productCount the productCount to set
	 */
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	/**
	 * @return the exchangeRate
	 */
	public String getExchangeRate() {
		return exchangeRate;
	}
	/**
	 * @param exchangeRate the exchangeRate to set
	 */
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
	public static void main(String[] args){
		//Model m = new Model();
		//m.setExchangeRate("xx");
		/*Field[] fields = Model.class.getDeclaredFields();//
		for(int i=0;i<fields.length;i++){
			System.out.println(fields[i].getName() + "xxxx" + fields[i].getGenericType().toString());
		}
		
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("hoo", "world");
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("ho", "world");
		//map2.put("hoo", "worldssss");
		map1.putAll(map2);
		
		
		for(Map.Entry<String,String> entry : map1.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		}*/
		
		
		/*Model m = new Model();
        m.setProductCount(222);
        m.setExchangeRate("xxx");
        m.setDd(6.3);
        Field[] fields = m.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            String name = fields[i].getName();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method method = null;
            Object value = null;
            try {
                method = m.getClass().getMethod("get"+name, null);
            } catch (NoSuchMethodException | SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                value = method.invoke(m, null);
            } catch (IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(name + "   " + value.toString());
        }
	*/
	
	
	
	
	}

}
