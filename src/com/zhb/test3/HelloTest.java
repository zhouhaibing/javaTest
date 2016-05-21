package com.zhb.test3;

import java.util.ArrayList;
import java.util.List;

public class HelloTest {
  public static void main(String[] args){
    List<String> emptyList = new ArrayList<String>();
    //emptyList.add("hello");
    for(String s : emptyList){
      System.out.println("helllo world");
    }
  }

}
