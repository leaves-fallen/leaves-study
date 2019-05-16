package com.caofangqi.study.le;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * <p>
 * Lambda表达式 Lambda Expressions
 * </p>
 * <p>
 * lambda 表达式 主要用来表达函数接口的实例。实现函数接口唯一的抽象函数，以此来实现函数接口。
 * </p>
 * lambda 表达式的用处:
 *  1.将函数作为方法参数传递。
 *  2.lambda 表达式可以像对象一样传递并按需执行。
 *  3.lambda 表达式 就像函数一样的接受参数
 *
 *  lambda 表达式体里当有多个语句时，这些语句必须用大括号括起来(代码块)，并且匿名函数的返回类型与代码块中返回的值的类型相同，如果没有返回任何值，则为void。
 * 参考资料:
 * https://www.geeksforgeeks.org/lambda-expressions-java-8/
 */
public class LambdaExpressions {




  public static void main(String[] args){
    List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,34,234,234,24,2);
    //使用lambda 表达式遍历所有元素

    //         参数列表     lambda 表达式体
    list.forEach((e)->      System.out.println(e.toString()));
    //使用lambda 表达式遍历偶数
    list.forEach(e->{
      if (e % 2 == 0) {
        System.out.println(e.toString());
      }
    });


  }


}
