package com.caofangqi.study.dmfi;

/**
 * 接口的默认方法 java8 中 可以使用 default 关键字向接口添加非抽象方法实现默认方法来便于接口的扩展。 接口的默认方法可以在实现类中的成员方法中调用，当然也可以通过实现类的实例
 * 去调用
 *
 * The default methods were introduced to provide backward compatibility so that existing intefaces
 * can use the lambda expressions without implementing the methods in the implementation class.
 * Default methods are also known as defender methods or virtual extension methods.
 *
 * jdk1.8 接口引入默认方法是为了提供向后兼容性，使jdk1.8以前存在的接口可以使用lambda表达式，而无需在实现类中实现方法。默认方法也称为防御器方法或虚拟扩展方法。 问题: 1.
 * 多个接口 和类 有 同名方法时，实现类需重写或者指定使用哪个接口或者类的方法。
 *
 * 接口的静态方法: 通过接口名来调用，和类的静态方法类似
 * <p>
 * 参考资料: 1.https://www.geeksforgeeks.org/default-methods-java/
 * </p>
 *
 * @author : 高冷的美男子
 * @date : Created in 17:00 2019/5/15
 */
public class DefaultMethodsForInterfacesTest extends TestClass implements TestInterface,
    TestTwoInterface {

  public static void main(String[] args) {
    //静态方法通过接口名调用
    TestInterface.testStatic();

    new DefaultMethodsForInterfacesTest().test();
  }

  @Override
  public void test() {
    //调用实现类的方法 test
    super.test();
    //调用接口的默认方法
    TestInterface.super.test();
    TestTwoInterface.super.test();
  }

}