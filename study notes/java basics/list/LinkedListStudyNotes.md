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

  

  

## LinkedList 的存取操作



##### 	都说 LinkedList 增删比 ArrayList 要快，为什么呢？

 LinkedList 中的 add 方法,如下：

  ```
     public boolean add(E e) {
     	   linkLast(e);
     	   return true;
  	  }
  	    将添加进来的元素 链接上最后一个节点
  	  
  	   void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
  ```

LinkedList 中的添加方法直接将元素链接到最后一个节点上面去，而ArrayList中如果容量不足还会进行扩容的操作。

再看 remove 方法:



```
 	//这是根据对象删除
 	public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x); //删除该节点，将该节点前后节点 进行链接
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);//删除该节点，将该节点前后节点 进行链接
                    return true;
                }
            }
        }
        return false;
   	 }
   	 
   	 //根据索引进行删除
   	    public E remove(int index) {
        checkElementIndex(index);//检查索引是否越界
        return unlink(node(index)); //执行查询方法 删除节点
    }
    
    //删除该节点，将该节点前后节点 进行链接
    E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }
    
```

LinkedList 中的删除方法是找到 要删除的节点，然后将被删除的节点 前后两个节点进行链接，而ArrayList中在删除元素之后还要进行一个移动元素的操作。

综上所述，LinkedList 的增删 方法比 ArrayList 的增删方法效率要高。



再看 改 查方法：

LinkedList中的查 get 方法:

```
    
    public E get(int index) {
        checkElementIndex(index);//检查索引是否越界
        return node(index).item;//二分查找 
    }
    //二分查找出节点
     Node<E> node(int index) {
        // assert isElementIndex(index);
         //右移1位 相当于 除以2  索引在前半部分就从first节点遍历
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {//索引在后半部分 就从 last 节点遍历
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
```

LinkedList 中获取某个索引位置的节点，需要进行遍历，而 ArrayList 是以数组实现的，可以直接获取某个索引位置的元素。

再看 LinkedList 中的 set 方法：



```
	
	public E set(int index, E element) {
   	 checkElementIndex(index); //检查索引
   	 Node<E> x = node(index); //获取该节点
   	 E oldVal = x.item; //修改值
   	 x.item = element;
   	 return oldVal;
	}
```

 LinkedList 中修改 也是需要先遍历查出来的，然后进行修改，而 ArrayList 就可以直接进行修改。

所以：

得出结论： LinkedList 的改查 的效率不如 ArrayList 高。





# 未待完续





  









