package com.zhb.test2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * fast json test
 * 
 * @author ZHOUHAIBING
 *
 */
public class JsonTest {
	public static void main(String[] args) {

		/*JSONObject jsonObj = JSON.parseObject("{\"id\":0,\"state\":{\"code\":10,\"msg\":\"invalid request param\"}}");
		System.out.println(jsonObj.getString("state"));
		String json2 = "{\"code\":5,\"msg\":\"sign\\u65e0\\u6548\",\"data\":[]}";
		JSONObject obj = JSONObject.parseObject(json2);
		System.out.println(obj.getInteger("code"));
		System.out.println(obj.getString("data"));
		obj.put("data", null);
		System.out.println(obj.toJSONString());
		
		
		//json to object
		String json = "{\"name\":{\"first\":\"zhou\"},\"age\":\"10\",\"hoppy\":\"base\"}";//right
		//String json = "{\"name\":\"{\"first\":\"zhou\"}\",\"age\":\"10\",\"hoppy\":\"base\"}";//error.name is json string
		//String json = "{\"name\":null,\"age\":\"10\",\"hoppy\":\"base\"}";//right
		//String json = "{\"age\":\"10\",\"hoppy\":\"base\",\"check\":true}";//right
		//String json = "{\"name\":\"\",\"age\":\"10\",\"hoppy\":\"base\"}";//error
		//String json = "{\"name\":{\"\"},\"age\":\"10\",\"hoppy\":\"base\"}";//error
		//String json = "{\"hoppy\":null}";//equal to  "{\"age\":\"0\"}"
		//String json = "{\"age\":\"\"}";
		//String json = "{\"age\":\"10\",\"hoppy\":\"\"}";
		System.out.println("-------------------");
		Person p = JSON.parseObject(json,Person.class);
		//System.out.println(p.getName().getFirst());
		System.out.println(p.getHoppy());
		System.out.println(p.getAge());
		System.out.println(p.getName());
		System.out.println(JSON.toJSONString(p));
		System.out.println("------------------");
		
		//object to json
		Person p1 = new Person();
		p1.setName(null);
		//p1.setAge(2);
		p1.setHoppy(null);
		System.out.println(JSON.toJSONString((Object)p1));*/

		/**
		 * object ot json.
		 * 1.if you set anything to attribute ,the json str can present it even if the value of attribute is empty string.
		 * 2.if you set value is null or no set, there is no exist this attribute in the json string.
		 * 3."{\"hoppy\":null}";//equal to "{\"age\":\"10\"}"
		 */

		/*System.out.println("this is json test");
		 
		String jsonStr = "{\"age\":10,\"check\":true,\"hoppy\":\"base\"}";
		JSONObject o = JSON.parseObject(jsonStr);
		System.out.println(o.getInteger("age"));//o.getString also is right*/
		
		/*String str = "{\"code\":0,\"rechargeInfo\":[{\"productId\":201,\"name\":\"4000\u5143\u5b9d\",\"price\":\"9999\",\"currency\":\"USD\"},{\"productId\":202,\"name\":\"2500\u5143\u5b9d\",\"price\":\"4999\",\"currency\":\"USD\"},{\"productId\":203,\"name\":\"800\u5143\u5b9d\",\"price\":\"1999\",\"currency\":\"USD\"},{\"productId\":204,\"name\":\"400\u5143\u5b9d\",\"price\":\"999\",\"currency\":\"USD\"},{\"productId\":205,\"name\":\"200\u5143\u5b9d\",\"price\":\"499\",\"currency\":\"USD\"},{\"productId\":206,\"name\":\"40\u5143\u5b9d\",\"price\":\"99\",\"currency\":\"USD\"}]}";
		JSONObject obj = JSON.parseObject(str);
		List<Item> itemList = JSON.parseArray(obj.getString("rechargeInfo"), Item.class);
		System.out.println(itemList.size() + itemList.get(0).getProductId());*/
		
		
		Person p = new Person();
		Name n = new Name();
		n.setFirst("hello");
		n.setSecond("world");
		p.setName(n);
		p.setAge(3);
		p.setHoppy("basketball");
		p.setCheck(false);
		System.out.println(JSON.toJSONString(p));
		JSONObject obj = JSON.parseObject(JSON.toJSONString(p));
		System.out.println(obj.keySet());
	}

}

class Person {
	@JSONField(ordinal = 1)
	private Name name;
	@JSONField(ordinal = 4)
	private int age;
	@JSONField(ordinal = 2)
	private String hoppy;
	@JSONField(ordinal = 3)
	private boolean check;

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the hoppy
	 */
	@JSONField(name = "hooppy",ordinal = 2)
	public String getHoppy() {
		return hoppy;
	}

	/**
	 * @param hoppy
	 *            the hoppy to set
	 */
	public void setHoppy(String hoppy) {
		this.hoppy = hoppy;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", hoppy=" + hoppy + ", check=" + check + "]";
	}

}

class Name {
	@JSONField(ordinal = 2)
	private String first;
	@JSONField(ordinal = 1)
	private String second;

	/**
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * @param first
	 *            the first to set
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
	 * @param second
	 *            the second to set
	 */
	public void setSecond(String second) {
		this.second = second;
	}

}
