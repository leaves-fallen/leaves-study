package com.caofangqi.study.fi;


/**
 * 自定义函数接口
 */
@FunctionalInterface //该注解可加可不加
public interface Sum {

  long calculate(int n1, int n2);

}
