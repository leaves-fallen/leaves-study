

# JAVA I/O 

[TOC]

## 什么是 I/O ?

I/O 就是计算机内存与外部设备之间拷贝数据的过程。

## 同步/异步 阻塞/非阻塞 的概念

* 阻塞

  用户线程去系统内核从网络读取数据，阻塞住等待数据到来。

* 非阻塞

  用户线程去系统内核从网络读取数据，数据没来时立刻返回读取失败，然后用户线程不断轮询 读取数据。

* 同步

  用户线程去系统内核从网络读取数据时，内核同步返回数据。

* 异步

  用户线程去系统内核从网络读取数据时，用户线程读取方法立刻返回。内核异步传递数据给用户线程。

## Java I/O 模型 

 下列图出自极客时间 [深入拆解 Tomcat & Jetty](https://time.geekbang.org/column/article/100307)

### 同步阻塞 I/O

用户线程发起 read 调用后就阻塞了，内核等待网卡数据到来，把数据从网卡拷贝到内核空间，接着把数据拷贝到用户空间,然后用户线程继续执行。

![](../../../../img/java-basics/io/sync-block-io.jpg)

### 同步非阻塞 I/O

用户线程发起 read 之后，如果没有数据就立即返回失败，不断轮训至数据已到达，返回数据，拷贝数据的过程中，用户线程是阻塞的。

![](../../../../img/java-basics/io/sync-nonblock-io.jpg)

### I/O 多路复用

用户线程 read 操作分成两步，

第一步：线程先发起  select 调用，查询内核数据是否准备好了。

第二步：如果数据准备好了，用户线程在发起 read 调用，读取数据。(在等待数据从内核空间拷贝到用户空间这段时间里，线程还是阻塞的。)

**因为一次 select 调用可以向内核查多个数据通道（Channel）的状态，所以叫多路复用。**

![](../../../../img/java-basics/io/io-multiplexing.jpg)

### 异步  I/O

用户线程发起 read 调用的同时注册一个回调函数，read 立即返回，等内核将数据准备好后，再调用指定的回调函数完成处理。在这个过程中，用户线程没有阻塞。

![](../../../../img/java-basics/io/async-io.jpg)



## NIO

[nio学习笔记](./nio.md)



# 参考资料

* [深入拆解 Tomcat & Jetty](https://time.geekbang.org/column/article/100307)
* [百度、腾讯热门面试题：聊聊Unix与Java的IO模型？（含详细解析）](https://juejin.im/post/5cc16477e51d456e7f0ba5b6)