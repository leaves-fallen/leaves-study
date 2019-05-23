# 纯手工编写Servlet

抛弃 IDE、拒绝框架，自己纯手工编写一个 Servlet,并在 Tomcat 中运行起来。一方面进一步加深对 Servlet 的理解；

学习摘录自：

[深入拆解 Tomcat & Jetty(李号双eBay技术主管)](https://time.geekbang.org/column/article/95808)

#### 



# 编译 java 文件

因为 servlet-api.jar 中定义了 Servlet 接口，而我们的 Servlet 类实现了 Servlet 接口，因此编译 Servlet 类需要这个 JAR 包。接着我们执行编译命令：

````
javac -cp ./servlet-api.jar MyServlet.java
````





