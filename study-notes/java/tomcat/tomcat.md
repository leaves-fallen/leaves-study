# Tomcat 学习笔记

[TOC]

## Tomcat 系统架构





<img src="../../../img/web/tomcat/tomcat-architecture.png"/>



tomcat 设计了两个核心组件 连接器 (Connector ) 和容器 (Container) 来分别做这两件事情。连接器负责对外交流，容器负责内部处理。

### Tomcat 支持的多种 I/O 模型和应用层协议

 Tomcat 支持的 I/O 模型有:

* NIO : 非阻塞 I/O ,采用 JAVA NIO 类库实现。
* NIO2 : 异步I/O , 采用JDK7 最新的NIO2 类库实现。
* APR: 采用 Apache 可移植运行库实现，是 C/C++ 编写的本地库。

 Tomcat 支持的应用层协议 :

* HTTP/1.1：这是大部分 Web 应用采用的访问协议。
* AJP：用于和 Web 服务器集成（如 Apache）。
* HTTP/2：HTTP 2.0 大幅度的提升了 Web 性能。

Tomcat 为了实现支持多种 I/O 模型和应用层协议，一个容器可能对接多个连接器，就好比一个房间有多个门。但是单独的连接器或者容器都不能对外提供服务，需要把它们组装起来才能工作，组装后这个整体叫作 Service 组件。这里请你注意，Service 本身没有做什么重要的事情，只是在连接器和容器外面多包了一层，把它们组装在一起。Tomcat 内可能有多个 Service，这样的设计也是出于灵活性的考虑。通过在 Tomcat 中配置多个 Service，可以实现通过不同的端口号来访问同一台机器上部署的不同应用。

如下图所示:

![](../../../img/web/tomcat/connector-container.jpg)

最顶层是 Server，这里的 Server 指的就是一个 Tomcat 实例。一个 Server 中有一个或者多个 Service，一个 Service 中有多个连接器和一个容器。连接器与容器之间通过标准的 ServletRequest 和 ServletResponse 通信。



## 连接器

连接器对 Servlet 容器屏蔽了协议及 I/O 模型等的区别，无论是 HTTP 还是 AJP，在容器中获取到的都是一个标准的 ServletRequest 对象。



# 参考资料

* [深入拆解 Tomcat & Jetty-李号双](https://time.geekbang.org/column/article/96328) 