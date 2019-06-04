package com.caofangqi.study.fi;

import java.util.function.Predicate;

/**
 * 函数接口（Functional Interfaces）
 * <p>
 * A functional interface is an interface that contains only one abstract method. They can have only
 * one functionality to exhibit
 * </p>
 * <p>
 * 函数接口就是只有一个抽象方法的接口，它只能展示一个函数。lambda 表达式可以用于表示函数接口的实例 一个函数接口，可以有任意数量的默认方法。
 * </p>
 * 自定义函数接口，只能有一个抽象方法. 可以加注解 @FunctionalInterface 来确保接口上只有一个抽象方法 该注解并不是强制性的。
 *<p>
 * java.util.function package 包含了很多内置接口
 *</p>
 * <p>
 *   总结:
 *   1.函数接口只有一个抽象方法，但是可以有多个默认方法.
 *   2.@FunctionalInterface 可以确保函数接口只有一个抽象方法，该注解不是强制使用的。
 *   3.java.util.function 包下有很多内置函数接口。
 * </p>
 * 参考资料:
 * https://www.geeksforgeeks.org/functional-interfaces-java/
 */
public class FunctionalInterfacesTest {


  /**
   * java 8 以前实现runnable 接口
   */
  public static void beforeJava8ImplementsRunnable() {
    //创建匿名内部类
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("New Thread created");
      }
    }).start();
  }

  /**
   * java 8 以后，可以使用 lambda 表达式，以赋值的形式赋给 函数接口对象 。
   */
  public static void java8OnwardsImplementsRunnable() {
    //lambda 表达式创建函数接口对象
    new Thread(() -> {
      System.out.println("New Thread created with lambda");
    }).start();
  }

  /**
   * 自定义函数接口使用 展示
   */
  public static void customFunctionalInterfaceShow() {
    // lambda 表达式 来实现计算过程，充当 Sum 接口的实例
    Sum sum = (a, b) -> a + b;

    System.out.println(sum.calculate(2, 3));
  }

  public static void main(String[] args) {
    beforeJava8ImplementsRunnable();
    java8OnwardsImplementsRunnable();
    customFunctionalInterfaceShow();
  }



}
