package com.caofangqi.study.arithmetic.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Test for Sort
 */
public class SortTest {

    Sort sort;
    Integer[] nums = new Integer[]{879874, 5, 1374, 8674, 61, 35, 746, 745, 4165,
            4, 9879, 7, 987, 979, 79, 789, 78, 645, 45, 13, 45, 35, 635751, 68486, 132164};


    public void test() {
       long st=System.nanoTime();
        sort.sort(nums);
        long et=System.nanoTime();
        sort.show(nums);
        assertTrue(sort.isSorted(nums), "排序失败,数组不是升序的");
        System.out.println(sort.toString()+" 耗时:"+(et-st)+" 纳秒");
    }

    /**
     * 冒泡排序测试
     */
    @Test
    public void bubbleSortTest() {
        sort = new BubbleSort();
        test();
    }

    /**
     * 选择排序测试
     */
    @Test
    public void selectionSortTest() {
        sort = new SelectionSort();
        test();
    }


    /**
     * 插入排序测试
     */
    @Test
    public void InsertionSortTest() {
        sort = new InsertionSort();
        test();
    }

    /*
     * 希尔排序测试
     * */
    @Test
    public void shellSort(){
        sort=new ShellSort();
        test();
    }

}
