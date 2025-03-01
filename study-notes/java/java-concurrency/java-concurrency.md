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

使用锁的过程中有可能产生死锁。

避免死锁的几个方法:

* 避免一个线程同时获取多个锁
* 避免一个线程在锁内同时占用多个资源，尽量保证每个锁只占用一个资源。
* 尝试使用定时锁，使用 lock.tryLock(timeout) 来替代使用内部锁机制。
* 对于数据库锁，加锁和解锁必须在同一个数据库连接里哦，否则会出现解锁失败的情况。

### 资源的限制

1. 什么是资源限制

   资源限制是指在并发编程时，程序的执行速度受限于计算机硬件资源或软件资源。

2. 资源限制引发的问题

   在并发编程中，将代码执行速度加快的原则是将代码中串行执行的部分变成并发执行，但是如果将某段串行代码并发执行，因为受限于资源，仍然在串行执行，这时候程序不仅不会加快执行，反而会更慢，因为增加了上下文切换和资源调度的时间。

   





## Java 并发机制的底层实现原理

[Java 并发机制的底层实现原理](./Java-concurrency-underlying-implementation-principle.md)

# 参考资料

* java 并发编程的艺术

