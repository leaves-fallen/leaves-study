package com.caofangqi.study.arithmetic.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort implements Sort {


  @Override
  public void sort(Comparable[] arr) {

  }

  public Comparable[] mergeSoft(Comparable[]arr){
    if (arr.length<2)
      return arr;
    int mid=arr.length/2;
    Comparable []left= Arrays.copyOfRange(arr,0,mid);
    Comparable []right=Arrays.copyOfRange(arr,mid,arr.length);
    return merge(MergeSort(left),MergeSort(right));
  }
  public Comparable[] merge(Comparable[] left,Comparable[] right){
    Comparable []result=new Comparable[left.length+right.length];
    for (int i = 0,l=0,r=0; i < result.length; i++) {
       if ()

    }
    return null;
  }

}
