package com.caofangqi.study.arithmetic.sort;

/**
 * 插入排序
 */
public class InsertionSort implements Sort {


  @Override
  public void sort(Comparable[] arr) {
    int length=arr.length;
    int preIndex;
    Comparable current;
    for (int i = 1; i < length; i++) {
      preIndex=i-1;
      current=arr[i];
      while (preIndex>=0 && less(current,arr[preIndex]) ){
          arr[preIndex+1]=arr[preIndex];
          preIndex--;
      }
      arr[preIndex+1]=current;

    }
    
  }

}
