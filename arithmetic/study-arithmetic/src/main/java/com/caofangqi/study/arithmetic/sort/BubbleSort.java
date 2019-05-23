package com.caofangqi.study.arithmetic.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {


  /**
   * 冒泡排序
   */
  public static void bbbleSort(int[] nums) {
   if (nums==null)
     throw new RuntimeException("nums 不能为空!!!!!");
     int length=nums.length;
     int temp=0;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length-1-i; j++) {
          if (nums[j]>nums[j+1]){
            temp=nums[j];
            nums[j]=nums[j+1];
            nums[j+1]=temp;
          }
      }
    }

  }


  public static void  main(String []args){
    int [] nums=new int[]{1,2,4,8,9,5,24,32,12,45,76,13,1,324,4,2,1,43,56,8,32,6,8,2,4,3,34};
       bbbleSort(nums);

    System.out.println(  Arrays.toString(nums));
  }

}
