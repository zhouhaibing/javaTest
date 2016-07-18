package com.zhb.test3;

import java.util.Comparator;
import java.util.List;

public class HelloTest {
	/*public static void main(String[] args) {
		List<String> emptyList = new ArrayList<String>();
		// emptyList.add("hello");
		for (String s : emptyList) {
			System.out.println("helllo world");
		}

		// file io
		// File file = new File("/resources/hello.txt");
		File file = new File("C:\\zhouhbFile\\developments\\eclipse-workspaces\\ws-xgsdk-jee\\javaTest\\resources\\hello.txt");
		// File file = new File("resources/hello.txt");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.exists());

		// Windows separators ("\") are replaced by simple slashes
		System.out.println("\\");
	}*/
	
	
	private IStrategy strategy;
	
	public HelloTest(IStrategy strategy){
		this.strategy = strategy;
	}
	
	public void changeStrategy(IStrategy strategy){
		this.strategy = strategy;
	}
	
	public void sayHello(){
		this.strategy.sayHello();
	}
	
	public static void main(String[] args){
		IStrategy as = new AStrategy();
		HelloTest ht = new HelloTest(as);
		ht.sayHello();
		IStrategy bs = new BStrategy();
		ht.changeStrategy(bs);
		ht.sayHello();
		
		
		Object a = 3;
		Object b = 4;
		Comparator comp = new myComparator();
		int compp = comp.compare(a, b);
		
		
	}
	
	

	interface IStrategy {
		String HELLO = "hello";

		void sayHello();
	}

	static class AStrategy implements IStrategy {
		@Override
		public void sayHello() {
			System.out.println(HELLO);
		}

	}

	static class BStrategy implements IStrategy {
		@Override
		public void sayHello() {
			System.out.println(HELLO + " world");
		}
	}
	
	public static class myComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
		
		public int comparee(Object o1, Object o2) {
			return compare((Integer)o1,(Integer)o2);
		}
		
		public <T> T max(List<T> list, Comparator<T> comp) {
			   T biggestSoFar = list.get(0);
			   for ( T t : list ) {
			       if (comp.compare(t, biggestSoFar) > 0) {
			          biggestSoFar = t;
			       }
			   }
			   return biggestSoFar;
			}
		
	}

}
