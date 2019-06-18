package com.caofangqi.study.io.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO DEMO
 *
 * @author 叶子
 * @date 2019/06/18 15:19:08
 */
public class NioTest {

  /**
   * Buffer 读取完数据后 clear()方法清空数据DEMO
   *
   * @date 2019/06/18 15:21:49
   */
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

  /**
   * Buffer 读取完数据后 compact()方法清除已读数据DEMO
   *
   * @date 2019/06/18 15:21:49
   */
  public static void compactBufferDemo() {
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
        System.out.println("翻转之前position:" + byteBuffer.position());
        // 翻转 准备读取缓冲区
        byteBuffer.flip();
        System.out.println("翻转之后position:" + byteBuffer.position());
        // 从 缓冲区 中读取数据 转成字符打印
        System.out.println((char) byteBuffer.get());
        System.out.println("读取数据之后position:" + byteBuffer.position());
        // 清除已读数据(并没有清除已读数据，只是将未读数据拷贝到了数组从零开始的地方，已读数据会被覆盖) 准备重新写入
        byteBuffer.compact();
        System.out.println("清除已读数据之后position:" + byteBuffer.position());
        // 读取通道中的数据写入到 缓冲区
        bytesRead = fc.read(byteBuffer);
      }
      byteBuffer.flip();

      // 判断缓冲区 是否还有下一个字节
      while (byteBuffer.hasRemaining()) {
        // 从 缓冲区 中读取数据 转成字符打印
        System.out.print((char) byteBuffer.get());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
