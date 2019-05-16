package com.caofangqi.study.dmfi;

public interface TestTwoInterface {
  static void testStatic() {
    System.out.println("TestTwo 接口中的静态方法");
  }

  default void test() {
    System.out.println("TestTwo 接口中的默认方法test");
  }

}
