package com.caofangqi.study.stack;

import java.util.ArrayList;
import java.util.Stack;
/*
 * 我的栈
 * */
public class MyStack {

  // 栈存储数组
  private Object[] stack;

  // 栈顶
  private int top;
  // 栈 默认大小
  private final int defaultStackSize = 10;
  // 栈大小;
  private int stackSize = defaultStackSize;

  public MyStack(int stackSize) {
    this.stackSize = stackSize;
      stack =new Object[stackSize];
  }


  public MyStack() {
      stack = new Object[stackSize];
  }

  //压栈
    public void push(Object o){
    if (top+1>stackSize){
        throw new RuntimeException("栈上溢。。。");
    }
    this.stack[top++-1]=o;
    }

    //弹栈
    public Object pop(){
      if (top==0){
          throw new RuntimeException("栈下溢。。。。");
      }
      return stack[top---1];
    }

}
