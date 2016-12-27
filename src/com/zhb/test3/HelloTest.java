package com.zhb.test3;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class HelloTest {
	public static final String RFC_3339_PATTERN = "yyyy-MM-dd'T'HH:mm:ssXXX";// for 2014-12-12T00:00:00.000+09:00.or ISO 8601

	public static void main(String[] args) throws ParseException {
		
		
		
		String[] ss = new String[]{"hello"};

		/*int[] a = new int[] { 1, 2, 3, 4, 5 };
		List<int[]> list = Arrays.asList(a);
		System.out.println(Arrays.toString(a));// the right way to print arrays

		System.out.println(Arrays.toString("||ddd||".split("\\|")));//[, , ddd]
		System.out.println(Arrays.toString(StringUtils.split("||ddd||", "|")));//[ddd]
		System.out.println(2 * (Integer.MAX_VALUE / 3));

		System.out.println(System.currentTimeMillis());
		
		
		
		System.out.println(JSONObject.parseObject("{}", Person.class));*/

		// subString test
		/*String s1 = "uc__12345";
		String s2 = "12345";
		System.out.println(s2.lastIndexOf("_"));// -1 not contain str,then return -1.equal to indexOf
		System.out.println(s2.substring(s2.lastIndexOf("_") + 1));
		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, 1);
		System.out.println(cal.getTime());
		
		List<String> lists = new ArrayList<String>();
		lists.add("hello");
		lists.add("world");
		System.out.println(lists);
		
		
		System.out.println(Math.random());
		
		try {
			Scanner scan = new Scanner(new File("hello.txt"));
			System.out.println(scan.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		// String s1 = "{\"body\":{\"result\":\"success\"},\"headers\":\"\",\"statusCode\":\"OK\"}";
		/*String s1 = "{\"body\":\"{\\\"result\\\":\\\"success\\\"}\",\"headers\":{},\"statusCode\":\"OK\"}";
		JSONObject obj = JSONObject.parseObject(s1);
		System.out.println(obj.getString("body"));
		System.out.println(obj.toJSONString());
		// System.out.println(obj.getJSONObject("body"));
		// System.out.println(JSON.toJSONString(obj.getString("body")));
		// System.out.println(JSON.toJSONString(obj.getJSONObject("body")));
		// System.out.println(JSON.toJSONString(obj));

		String s2 = "{\"response\":\"{\\\"body\\\":\\\"hello\\\"}\"}";
		JSONObject obj2 = JSONObject.parseObject(s2);
		System.out.println(obj2.getString("response"));

		List<String> list1 = new ArrayList<String>();
		for (String s : list1) {
			System.out.println(s);
		}

		JSONObject obj1 = JSONObject.parseObject("{}");
		System.out.println(obj1.getString("hello"));

		Map<String, String> map = new HashMap<String, String>();
		map.put(null, null);
		System.out.println(map);

		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("ddd", null);
		System.out.println(map1);*/

		// final string
		/*String a = "hello";
		String b = new String("hello");// //创建了两个对象。第一个是创建在字符串常量池中，一个是堆中。
		String c = new String("hello" + "world");// 按理应该是创建了4个对象,前提是字符串字面量"hello","world"之前没有出现过

		System.out.println(a == b);// false
		System.out.println(a == b.intern());// true.b引用指向了字符串常量池中的字面量

		String d = "2";
		String mm = "hello2";
		System.out.println(a + d == mm);// false
		System.out.println("hello" + "2" == mm);// true。字符串拼接，全是字面量常量(字符串，数字2），直接拼接放入常量池中。
		// 有一个不是字面量常量，JVM内部做了优化，会创建一个StringBuilder进行拼接，最后得到的是一个String object.
		System.out.println("hello" + 2 == mm);// true

		final String aa = "hello";
		final String dd = "2";
		System.out.println(aa + dd == mm);// true，加上final，变量成为了编译期的常量，相当于c#中的宏定义。使用该变量的时候直接替换值。

		final String aaa = getHello();
		System.out.println(aaa + dd == mm);// false 只有在编译期间确定final的值，才会有常量的效果。
*/
	}

}
