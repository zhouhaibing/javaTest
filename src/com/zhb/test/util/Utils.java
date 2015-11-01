package com.zhb.test.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Utils {
    
    public static void main(String[] args){
        
    }
    
    public HashMap<String, Object> toMap(Object model) {
        if (model == null)
            return null;
        HashMap<String, Object> map = new HashMap<String, Object>();
        Field[] fields = model.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String attrName = fields[i].getName();
            String nameGetter = attrName.substring(0, 1).toUpperCase()
                    + attrName.substring(1);
            String type = fields[i].getGenericType().toString();
            Method m = null;
            try {
                m = model.getClass().getMethod("get" + nameGetter);
            } catch (NoSuchMethodException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Object value = null;
            try {
                value = m.invoke(model, null);
            } catch (IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            map.put(attrName, value);
        }
        return map;
    }

}
