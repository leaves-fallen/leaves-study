package com.caofangqi.study.arithmetic.sort;

import java.util.Arrays;

/*
 * 选择排序
 *
 * */
public class SelectionSort implements Sort{


    /*
     *
     * 选择排序
     * 将数组按升序排列
     * */
    @Override
    public void sort(Comparable[] arr) {
        int length=arr.length;
        for (int i = 0; i <length ; i++) {

            for (int j = i+1; j < length; j++) {
                if (less(arr[j],arr[i])){
                exch(arr,i,j);
                }
            }
        }
    }





    public static void  main(String []args){
        Integer [] nums=new Integer[]{1,2,4,8,9,5,24,32,12,45,76,13,1,324,4,2,1,43,56,8,32,6,8,2,4,3,34};
        new SelectionSort().sort(nums);

        System.out.println(  Arrays.toString(nums));
    }
}
