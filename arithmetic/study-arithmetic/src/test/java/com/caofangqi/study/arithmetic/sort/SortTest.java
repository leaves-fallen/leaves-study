package com.caofangqi.study.arithmetic.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Test for Sort
 */
public class SortTest {

  Sort sort;
  Integer[] nums = new Integer[]{879874, 5, 1374, 8674, 61, 35, 746, 745, 4165,
      4, 9879, 7, 987, 979, 79, 789, 78, 645, 45, 13,635751,68486,132164 };


  public void test() {

    sort.sort(nums);
    sort.show(nums);
    assertTrue(sort.isSorted(nums), "排序失败,数组不是升序的");

  }

  /**
   * 冒泡排序测试
   */
  @Test
  public void bubbleSort() {
    sort = new BubbleSort();
    test();
  }

  /**
   * 选择排序测试
   */
  @Test
  public void selectionSort() {
    sort = new SelectionSort();
    test();
  }


}
