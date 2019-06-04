package com.caofangqi.study.dmfi;

public interface TestInterface {

  static void testStatic() {
    System.out.println("Test接口中的静态方法");
  }

  default void test() {
    System.out.println("Test 接口中的默认方法test");
  }
}
