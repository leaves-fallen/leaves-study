# LinkedList 学习笔记(jdk1.8)

LinkedList  继承 抽象类AbstractSequentialList类,实现List接口。数据结构为双向链表





## LinkedList 中的数据结构

LinkedList 是通过私有内部类Node来实现双向链表的。Node类源码如下:

```
		private static class Node<E> {
	  	  E item; //当前元素
	  	  Node<E> next; //存储下一个节点 Node对象
	  	  Node<E> prev; //存储上一个节点 Node对象
	
	  	  Node(Node<E> prev, E element, Node<E> next) {
	    	    this.item = element;
	    	    this.next = next;
	    	    this.prev = prev;
	  	  }
	 	}
	 	
```

添加进来的元素封装进Node对象，然后通过一个一个的Node对象进行首尾链接，仿佛如同贪吃蛇。如下图所示:

<img src="/img/java-basics/list/doubly-linked.png"/>



## 字段

* transient int size=0;   // 集合中已经存储的元素数量。

* transient Node<E> first; //集合中的第一个元素节点。

* transient Node<E> last; 集合中的最后一个元素节点。

  

  

## 对于List常用操作方法的实现



  









