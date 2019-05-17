package com.caofangqi.study.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 流 Streams java.util.Stream 表示能应用在一组元素上一次执行的操作序列。 Stream 操作分为中间操作或者最终操作两种，最终操作返回一特定类型的计算结果，
 * 而中间操作返回Stream本身，这样你就可以将多个操作依次串起来。 Stream 的创建需要指定一个数据源，比如 java.util.Collection 的子类， List 或者 Set，
 * Map 不支持。Stream 的操作可以串行执行或者并行执行。
 */
public class StreamsTest {


  public static void main(String[] args) {
    List<String> list = Arrays
        .asList("12", "546", "ba", "sag", "dg23", "cdg435", "dfs", "231d", "aba", "abd");

    /**
     * Filter 过滤
     * 通过 predicate 函数接口 来过滤 返回符合条件的元素，该操作属于中间操作，所以可以在过滤后应用其他Stream 操作。
     * forEach 是一个最终操作，所以不能在forEach 之后执行其他Stream 操作.
     */
    list.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
    System.out.println("===========================");
    /**
     * Sorted 排序
     *排序是一个 中间操作，返回的是排序好后的 Stream。如果不指定一个自定义的 Comparator 则会使用默认排序。
     */
    list.stream().sorted().filter(s -> s.length() == 3).forEach(System.out::println);
    System.out.println("===========================");
    /**
     * Map 映射
     * 中间操作 map 会将元素根据指定的 Function 接口来依次将元素转成另外的对象。
     */
    list.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
    System.out.println("===========================");
    /**
     * Match 匹配
     *Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。所有的匹配操作都是 最终操作 ，并返回一个 boolean 类型的值。
     */
    //测试 是否有任意字符匹配 以a开头
    System.out.println(list.stream().anyMatch(s->s.startsWith("a")));
    //测试 是否全部字符都匹配 以a开头
    System.out.println(list.stream().allMatch(s->s.startsWith("a")));
    //测试 是否没有字符匹配条件 以a开头
    System.out.println(list.stream().noneMatch(s->s.startsWith("a")));

    /**
     * Count 计数
     * 计数是一个 最终操作，返回Stream中元素的个数，返回值类型是 long。
     */
    System.out.println("===========================");
    System.out.println(list.stream().filter(s->s.length()>1).count());
   /**
    * Reduce 规约
    * 这是一个 最终操作 ，允许通过指定的函数来讲stream中的多个元素规约为一个元素，规约后的结果是通过Optional 接口表示的：
    */
    System.out.println("===========================");
    Optional<String> reduced=list.stream().sorted().reduce((s1,s2)->s1+"#"+s2);
      reduced.ifPresent(System.out::println);

    System.out.println(  list.stream().sorted().reduce("开始了:",(s1,s2)->s1+"#"+s2));

    /**
     *  Parallel Streams  并行流
     *  串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行。
     */
    int max = 100000;
    List<String> values = new ArrayList<>(max);
    for (int i = 0; i < max; i++) {
      UUID uuid = UUID.randomUUID();
      values.add(uuid.toString());
    }
    /**
     *Sequential 串行排序
     */
    long time=System.nanoTime();
    long count =values.stream().sorted().count();
   long  time2=System.nanoTime();
    System.out.println(String.format("sequential sort took: %d ms", TimeUnit.NANOSECONDS.toMillis(time2-time)));
  /**
   * Parallel Sort 并行排序
   */
    time=System.nanoTime();
    count =values.parallelStream().sorted().count();
    time2=System.nanoTime();
    System.out.println(String.format("parallel sort took: %d ms", TimeUnit.NANOSECONDS.toMillis(time2-time)));



  }

}
