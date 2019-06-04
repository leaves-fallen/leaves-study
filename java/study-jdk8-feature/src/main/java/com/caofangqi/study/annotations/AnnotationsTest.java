package com.caofangqi.study.annotations;

import java.lang.reflect.Method;

/**
 * java8中支持多重注解 可以在一个地方使用同一个类型的注解多次，只需要给该注解标注一下 @Repeatable
 */
public class AnnotationsTest {

  /**
   * JAVA8 以后是这么干的 编译器会隐性的定义好 @Tests 注解。
   */
  @Test
  @Test
  public static void testAnnotation() {

  }








  /**
   * java8以前是这么干的
   */
  @Tests({
      @Test,
      @Test
  })
  public static void beforeJava8Annotations() {

  }

  public static void main(String[] args) throws Exception {
    Method beforeJava8Annotations = AnnotationsTest.class.getMethod("beforeJava8Annotations");
    Method testAnnotation = AnnotationsTest.class.getMethod("testAnnotation");

    System.out.println("testAnnotation 获取Tests注解:" + testAnnotation.getAnnotation(Tests.class));

    System.out.println(
        "beforeJava8Annotations 获取Tests注解:" + beforeJava8Annotations.getAnnotation(Tests.class));
    /**
     * 输出
     * testAnnotation 获取Tests注解:@com.caofangqi.study.annotations.Tests(value=[@com.caofangqi.study.annotations.Test(), @com.caofangqi.study.annotations.Test()])
     * beforeJava8Annotations 获取Tests注解:@com.caofangqi.study.annotations.Tests(value=[@com.caofangqi.study.annotations.Test(), @com.caofangqi.study.annotations.Test()])
     * 可以看出，效果是一样的，这是个 java8的语法糖
     */
  }


}
