[TOC]

# NIO 学习笔记

传统的 IO 流还是有很多缺陷的，尤其它的阻塞性加上磁盘读写本来就慢，会导致 CPU 使用效率大大降低。

从JDK1.4开始，java中提供一个种叫NIO(Non-Blocking IO / New IO)的 IO 处理机制。NIO 弥补了原来的BIO的不足，它在标准 Java 代码中提供了高速的、面向缓冲的 I/O。

NIO由三个核心部分组成: 

* 缓冲区(Buffer)
* 通道(Channel)
* 选择器(Selector)



Channel，Buffer 和 Selector 构成了 NIO 核心的API。



## Channel 和 Buffer

所有的 IO 在NIO 中都从一个Channel 开始。Channel 有点象流。 数据可以从Channel读到Buffer中，也可以从Buffer 写到Channel中,如下图所示:

![](../../../../img/java-basics/io/nio-channels-and-buffers.png)

### 通道 Channel 

channel 和 IO 中的 流类似，只不过流是单向的，而 Channel 是双向的，既可以读也可以写，如上图所示. 

Channel 主要实现如下:

* FileChannel

  FileChannel 从文件中读写数据。

* DatagramChannel

  DatagramChannel 能通过UDP读写网络中的数据。

* SocketChannel

  SocketChannel 能通过TCP读写网络中的数据。

* ServerSocketChannel

  ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。



### Buffer

Buffer 主要实现如下:

* ByteBuffer

   对应基本数据类型 byte

* CharBuffer

  对应基本数据类型 char

* DoubleBuffer

  对应基本数据类型 double

* FloatBuffer

  对应基本数据类型 float 

* IntBuffer

  对应基本数据类型 int 

* LongBuffer

  对应基本数据类型 long

* ShortBuffer

  对应基本数据类型 short





 ## Selector

Selector 允许单线程处理多个 Channel 。如果你的应用打开了多个连接（通道），但每个连接的流量都很低，使用Selector就会很方便。例如，在一个聊天服务器中。

这是在一个单线程中使用一个Selector处理3个Channel的图示：

![](../../../../img/java-basics/io/nio-selectors.png)

要使用Selector，得向Selector注册Channel，然后调用它的select()方法。这个方法会一直阻塞到某个注册的通道有事件就绪。一旦这个方法返回，线程就可以处理这些事件，事件的例子有如新连接进来，数据接收等。





# 参考资料

* [Java NIO Overview](<http://tutorials.jenkov.com/java-nio/overview.html>)
* [攻破JAVA NIO技术壁垒](<https://blog.csdn.net/u013256816/article/details/51457215>)
* [Java NIO系列教程（一） Java NIO 概述](<http://ifeve.com/overview/>)

