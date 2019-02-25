package com.caofangqi.study.list;

import com.caofangqi.study.model.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 阅读ArrayList 源码
 *
 * @author : 高冷的美男子
 * @date : Created in 10:54 2019/2/15
 */
public class ArrayListStudy {


  public static void main(String[] args) {

   ArrayList<Integer> arrayList = new ArrayList();

       arrayList.add(1);
       arrayList.add(2);
       arrayList.add(3);
       arrayList.add(1);


       arrayList.remove((Object)1);


      arrayList.forEach(e-> {
        System.out.println("----------------------------------");
      });

    Map<String,String> map=new HashMap<>();
    map.forEach((e,d)->{

    });

   // System.out.println( arrayList.get(4));

  /*  Integer integer=2147483647;
    System.out.println(integer);*/
  }


  public static void testRightMove(int a,int b){
    System.out.println("a>>b:"+(a>>b));
  }

}
