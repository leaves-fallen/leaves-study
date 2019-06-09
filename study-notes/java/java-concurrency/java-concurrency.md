[TOC]

# Java 并发

java 并发学习笔记，



## 并发编程的挑战

并发编程的目的是为了让程序运行的更快，但是，并不是启动更多的线程就能够让程序最大限度的并发执行。在进行并发编程时，通过多线程执行任务让程序运行的更快，会面临着非常多的挑战。

### 上下文切换

**CPU 通过给每个线程分配 CPU 时间片来实现多线程机制，时间片是CPU 分配给各个线程的时间**，因为时间片非常短，所以 CPU 通过不停的切换线程执行，感觉就像多少线程同时执行的，时间片一般是几十毫秒(ms).

**CPU 通过时间片分配算法来循环执行线程，当前线程执行一个时间片之后 会切换到下一个线程。切换前会保存上一个线程的状态，以便下次切换回这个线程时，可以再次加载这个线程的状态。所以线程从保存到加载的过程就是一次上下文切换。**

**上下文切换会影响线程的执行速度。**

### 死锁

### 资源限制的挑战









# 参考资料

* java 并发编程的艺术
