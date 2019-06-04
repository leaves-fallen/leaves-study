package com.caofangqi.study.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 日期时间 Date API 1.java8以前 Date 和 Calendar 是线程不安全的，现在时间API是线程安全的 2.Date和Calendar
 * api设计得很差，没有足够的方法来执行日常操作。新的日期/时间api以ISO为中心，并遵循日期、时间、持续时间和周期的一致域模型。有多种实用方法支持最常见的操作。
 * 3.开发人员必须编写额外的逻辑来使用旧api处理时区逻辑，而使用新api，可以使用本地和ZonedDate/Time api处理时区。
 *
 * 参考资料:
 * https://www.baeldung.com/java-8-date-time-intro
 */
public class DateTest {


  /**
   * LocalDate LocalDate以ISO格式(yyyy-MM-dd)表示没有时间的日期。
   */
  public static void localDateDemo() {
    //获取当前日期
    LocalDate localDate = LocalDate.now();
    System.out.println("获取当前日期:" + localDate);
    //创建给定日期的实例
    localDate = LocalDate.of(2099, 9, 19);
    System.out.println("创建给定日期的实例-of:" + localDate);
    localDate = LocalDate.parse("2099-09-19");
    System.out.println("创建给定日期的实例-parse:" + localDate);
    //获取明天的日期，当前日期加上一天
    localDate = LocalDate.now().plus(1, ChronoUnit.DAYS);
    System.out.println("获取明天的日期 plus:" + localDate);
    localDate = LocalDate.now().plusDays(1);
    System.out.println("获取明天的日期 plusDays:" + localDate);
    //获取当前日期减一个月
    localDate = LocalDate.now().plusDays(11).minus(3, ChronoUnit.MONTHS);
    System.out.println("获取当前日期减一个月:" + localDate);

    DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
    System.out.println("dayOfWeek:" + dayOfWeek);
    int dayOfMonth = LocalDate.now().getDayOfMonth();
    System.out.println("dayOfMonth:" + dayOfMonth);
    //测试当前日期是否为闰年
    boolean leapYear = LocalDate.now().isLeapYear();
    System.out.println(leapYear ? "闰年" : "不是闰年");

  }


  public static void main(String[] args) {
    localDateDemo();
  }


}
