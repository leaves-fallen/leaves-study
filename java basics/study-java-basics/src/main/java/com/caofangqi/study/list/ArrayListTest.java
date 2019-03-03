package com.caofangqi.study.list;

import java.util.ArrayList;

/**
 * 阅读ArrayList 源码
 *
 * @author : 高冷的美男子
 * @date : Created in 10:54 2019/2/15
 */
public class ArrayListTest {


  public static void main(String[] args) {

    testForEachVsForSpeed(1000000);

  }


  public static void testRightMove(int a, int b) {
    System.out.println("a>>b:" + (a >> b));
  }

  /**
   * 测试forEach和for循环速度对比
   *
   * @author : 高冷的美男子
   * @date : Created in 14:04 2019/2/26
   */
  public static void testForEachVsForSpeed(int count) {
    ArrayList<Integer> arrayList = new ArrayList<>(100000);
    //存数据到集合中
    for (int i = 0; i < count; i++) {
      arrayList.add(i);
    }
    //获取开始时间-纳秒
    int s = arrayList.size();
    long startTime = System.nanoTime();

    for (int i = 0; i < s; i++) {
      System.out.println(arrayList.get(i));
    }
    long forElapsedTime = System.nanoTime() - startTime;

    startTime = System.nanoTime();
    arrayList.forEach(e -> {
      System.out.println(e);
    });

    long forEachElapsedTime = System.nanoTime() - startTime;
    System.out.println(arrayList.size() + "条数据,for循环----消耗时间:" + forElapsedTime);
    System.out.println(arrayList.size() + "条数据,forEach循环消耗时间:" + forEachElapsedTime);
  }

}
