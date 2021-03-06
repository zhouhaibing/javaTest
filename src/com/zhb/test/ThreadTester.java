package com.zhb.test;

class ThreadTesterA implements Runnable {

	private int counter;

	@Override
	public void run() {
		while (counter <= 10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("Counter = " + counter + " \n");
			counter++;
		}
		System.out.println();
	}
}

class ThreadTesterB implements Runnable {

	private int i;

	@Override
	public void run(){
		while (i <= 10) {
			
			System.out.print("i = " + i + " \n");
			i++;
		}
		System.out.println();
	}
}

public class ThreadTester {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadTesterA());
		Thread t2 = new Thread(new ThreadTesterB());
		t1.start();
		t1.join(); // wait t1 to be finished
		t2.start();
		//t2.join(); // in this program, this may be removed
	}
}