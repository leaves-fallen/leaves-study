package com.caofangqi.study.dmfi;

interface TestInterface {

  static void testStatic() {
    System.out.println("Test接口中的静态方法");
  }

  default void test() {
    System.out.println("Test 接口中的默认方法test");
  }
}

/**
 * 接口的默认方法 java8 中 可以使用 default 关键字向接口添加非抽象方法实现默认方法来便于接口的扩展。
 *
 * @author : 高冷的美男子
 * @date : Created in 17:00 2019/5/15
 */
public class DefaultMethodsForInterfacesTest {

}