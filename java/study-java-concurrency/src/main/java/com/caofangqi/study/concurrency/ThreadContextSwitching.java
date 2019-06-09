package com.caofangqi.study.concurrency;
/** 线程上下文切换 速度对比 测试 */
public class ThreadContextSwitching {
  public static final long count = 100000000;

  public static void main(String[] args) throws InterruptedException {
    concurrency();
    serial();
  }

  public static void concurrency() throws InterruptedException {

    long st = System.currentTimeMillis();
    Thread thread =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                  // 循环加1
                  a += 10;
                }
              }
            });
    int b = 0;
    for (long i = 0; i < count; i++) {
      // 循环减一
      b--;
    }
    thread.join();
    long time = System.currentTimeMillis() - st;
    System.out.println("循环" + count + " 次并发执行耗时 " + time + " ms");
  }

  public static void serial() {
    long st = System.currentTimeMillis();
    int a = 0;
    for (long i = 0; i < count; i++) {
      // 循环加1
      a += 10;
    }
    int b = 0;
    for (long i = 0; i < count; i++) {
      // 循环减一
      b--;
    }
    long time = System.currentTimeMillis() - st;
    System.out.println("循环" + count + " 次串行执行耗时 " + time + " ms");
  }
}
