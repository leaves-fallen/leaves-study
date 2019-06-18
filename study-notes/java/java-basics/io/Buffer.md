[TOC]

# Buffer

Java NIO中的 Buffer 用于和 NIO 通道(Channel)进行交互。数据是从通道读入缓冲区，从缓冲区写入到通道中的。[Channel 详细](./Channel.md)

**缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。这块内存被包装成NIO Buffer对象，并提供了一组方法，用来方便的访问该块内存。**

## Buffer 的基本用法

使用 Buffer 读写数据一般遵循以下四个步骤:

1. 写入数据到 Buffer 
2. 调用 flip() 方法
3. 从 Buffer 中读取数据
4. 调用 clear() 方法清空数据或者 compact() 方法清楚已经读过的数据。

当向 Buffer 写入数据时，Buffer 会记录下写了多少数据。一旦要读取数据，需要通过 flip() 方法将 Buffer 从写模式切换到读模式。在读模式下，可以读取之前写入到 Buffer 的所有数据。

一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。有两种方式清空缓冲区:

* clear() 方法

  clear() 方法会清空整个缓冲区。

* compact() 方法

  compact() 方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。



Buffer 使用Demo.

```java

  public static void clearBufferDemo() {
    try (
    // 创建 RandomAccessFile 实例 love.txt:文件地址，rw: 表示读写权限
    // 详见 https://blog.csdn.net/weixin_39913200/article/details/85228072
    RandomAccessFile raf = new RandomAccessFile("love.txt", "rw")) {
      // 获取文件通道
      FileChannel fc = raf.getChannel();
      // 创建 8 个字节容量的缓冲区
      ByteBuffer byteBuffer = ByteBuffer.allocate(8);
      // 读取通道中的数据写入到 缓冲区
      int bytesRead = fc.read(byteBuffer);
      while (bytesRead != -1) {
        // 翻转 准备读取缓冲区
        byteBuffer.flip();
        // 判断缓冲区 是否还有下一个字节
        while (byteBuffer.hasRemaining()) {
          // 从 缓冲区 中读取数据 转成字符打印
          System.out.print((char) byteBuffer.get());
        }
        // 清除数据(并没有删除数据，只是重置了标记，后面写入数据的时候会覆盖以前的数据) 准备重新写入
        byteBuffer.clear();
        // 读取通道中的数据写入到 缓冲区
        bytesRead = fc.read(byteBuffer);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
```





# 参考资料

* [Java NIO Buffer](http://tutorials.jenkov.com/java-nio/buffers.html#capacity-position-limit)
* [Java NIO系列教程（三） Buffer](http://ifeve.com/buffers/)

