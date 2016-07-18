package com.zhb.test2;

public class SynchronizedTest {

    private boolean ready = false;
    private int result = 0;
    private int number = 1;
    
    public void write(){
        ready = true;
        number = 2;
    }
    
    public void read(){if(ready){
            result = number * 3;
        }
        
        System.out.println("result is " + result);
    }
    
    private class TestThread extends Thread{
        private boolean flag;
        public TestThread(boolean flag){
            this.flag = flag;
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
            if(flag){
                write();
            }else{
                read();
            }
        }
    }
    
    public static void main(String[] args){
        SynchronizedTest test = new SynchronizedTest();
        test.new TestThread(true).start();
        test.new TestThread(false).start();
    }
}
