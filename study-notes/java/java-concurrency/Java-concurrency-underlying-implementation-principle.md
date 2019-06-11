

# Java 并发机制的底层实现原理

[TOC]

# volatile

volatile 是轻量级的synchronized,它在多处理器开发中保证了共享变量的 可见性 。

```
 可见性 : 当一个线程修改一个共享变量时，另外一个线程能读到这个修改的值。
```

volatile 比 synchronized 的使用和执行成本更低，因为它不会引起线程上下文的切换和调度。

### volatile 的定义与实现原理

**如果一个字段被声明成 volatile ，Java 线程内存模型确保所有线程看到的这个变量的值是一致的。**

