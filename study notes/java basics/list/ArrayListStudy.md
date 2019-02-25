# ArrayList  源码阅读
ArrayList 实现了 List 接口，动态数组。线程不安全。
## 字段
* DEFAULT_CAPACITY = 10;  //默认初始化数组长度

* Object[] EMPTY_ELEMENTDATA = {}; //Shared empty array instance used for empty instances.
  共享的空数组实例 用于空实例。（此处感谢一下微信群Java飞虎队2中的几位大佬）

* Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {}; //共享的空数组实例 用于默认大小的空实例

* transient Object[] elementData; //存储 ArrayList 元素的数组缓冲区，使用 transient 修饰，不会被序列化

* size //ArrayList 的大小(存储的元素的数量)
## 构造方法
 * 无参构造方法
   ````
    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public ArrayList() {
        //默认大小的空实例 
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
   ````
 * 指定初始容量构造函数
    ````
      public ArrayList(int initialCapacity) {
          if (initialCapacity > 0) {
              // 构造初始化容量数组 
              this.elementData = new Object[initialCapacity];
          } else if (initialCapacity == 0) {
              //如果为零 则使用共享的空数组实例
               this.elementData = EMPTY_ELEMENTDATA;
           } else {
               throw new IllegalArgumentException("Illegal Capacity: "+
                                                initialCapacity);
           }
       }
    ````
 * 通过已有的集合构造实例
  [jdkBUG 6260652](Bug记录.md)
    ```
        public ArrayList(Collection<? extends E> c) {
            // 集合转成数组 存进缓冲数组
            elementData = c.toArray();
            if ((size = elementData.length) != 0) {
                // 判断是否是Object类型数组，(JDK有个BUG，toArray()返回的不一定是Object类型数组，详见 jdkBug 6260652) 
                if (elementData.getClass() != Object[].class)
                    elementData = Arrays.copyOf(elementData, size, Object[].class);
            } else {
                // 如果数组长度为0，替换成共享空数组
                this.elementData = EMPTY_ELEMENTDATA;
            }
        }
    ```
## 常用方法
* add(E e) //添加一个元素到列表末尾
  ```
    public boolean add(E e) {
          //进行一个扩容的操作
          ensureCapacityInternal(size + 1);  // Increments modCount!!
          //然后赋值，同时自增size
          elementData[size++] = e;
          return true;
      }
  //进行一个扩容的操作    
  private void ensureCapacityInternal(int minCapacity) {
        //获取要扩容的容量，然后进行一个扩容的操作
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
  }
  //获取 要扩容的容量  
  private static int calculateCapacity(Object[] elementData, int minCapacity) {
         
          //如果缓冲数组是 默认的共享空数组实例 那就返回 最小容量(minCapacity)和默认容量中的最大的那一个 (默认构造函数初始化实例，第一个add时扩容至默认容量)
          if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
              return Math.max(DEFAULT_CAPACITY, minCapacity);
          }
          return minCapacity;
  }
  private void ensureExplicitCapacity(int minCapacity) {
         //自增列表结构 修改次数
         modCount++;
  
         // 如果最小容量 大于缓冲区大小，就进行扩容操作
         if (minCapacity - elementData.length > 0)
             grow(minCapacity);
  }
  
   //扩容 以确保缓冲数组能容纳 最小容量(minCapacity) 的参数数量
   private void grow(int minCapacity) {
          // overflow-conscious code
          int oldCapacity = elementData.length;
          //新的容量=老的容量加上老的容量一半（右移1位，相当于除以2）
          int newCapacity = oldCapacity + (oldCapacity >> 1);
          if (newCapacity - minCapacity < 0)
              newCapacity = minCapacity;//如果新容量小于最小容量，新容量=最小容量
          if (newCapacity - MAX_ARRAY_SIZE > 0)
              newCapacity = hugeCapacity(minCapacity);//新容量大于数组最大容量时，判断最小容量是否大于数组最大容量，代码如下
          // minCapacity is usually close to size, so this is a win:
          elementData = Arrays.copyOf(elementData, newCapacity); //使用Arrays的copy方法将原数组数据复制到新数组
   }
   //如果最小容量大于最大数组容量，返回int最大值 2147483647 也就是说，list最大可以存储这么多
   private static int hugeCapacity(int minCapacity) {
           if (minCapacity < 0) // overflow
               throw new OutOfMemoryError(); //如果超出2147483647的上限，就会内存溢出 抛出异常
           return (minCapacity > MAX_ARRAY_SIZE) ?
               Integer.MAX_VALUE :
               MAX_ARRAY_SIZE;
       }
  ```
* add(int index, E element) 将指定的元素添加到指定的位置
  ```
    public void add(int index, E element) {
        rangeCheckForAdd(index);//判断索引是否合法，代码如下
        //确保容量的大小足够 添加新的元素
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        //将指定位置以后的所有元素往后移动一位(包括指定位置所在的那一个元素)
        System.arraycopy(elementData, index, elementData, index + 1,
                         size - index);
        elementData[index] = element;//赋值
        size++;//大小自增
    }
        //判断索引是否在 列表大小范围内
        private void rangeCheckForAdd(int index) {
            if (index > size || index < 0)
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
  ```
 * E remove(int index) //删除指定位置的元素，返回改元素，此位置之后元素向左移一位
  ```
   public E remove(int index) {
          rangeCheck(index); //检查索引是否在范围内
  
          modCount++;
          //获取要删除的元素
          E oldValue = elementData(index);
          //计算出要移动的元素的数量 
          int numMoved = size - index - 1;
          //大于零，向左移动元素
          if (numMoved > 0)
              System.arraycopy(elementData, index+1, elementData, index,
                               numMoved);
          elementData[--size] = null; // clear to let GC do its work
          //返回删除的元素
          return oldValue;
      }

  ```
 * boolean remove(Object o) //根据元素删除，返回布尔值  如果有多个相同的元素，该方法只会删除第一个元素
    ```
    public boolean remove(Object o) {
    //如果传入值等于null
         if (o == null) {
             //遍历数组判断 然后快速删除
             for (int index = 0; index < size; index++)
                 
                 if (elementData[index] == null) {
                     fastRemove(index);
                     return true;
                 }
         } else {
            //不为空 遍历数组 使用equals 判断，然后删除
             for (int index = 0; index < size; index++)
                 if (o.equals(elementData[index])) {
                     fastRemove(index);
                     return true;
                 }
         }
         return false;
     }
     //快速删除方法，没有索引边界检查
     private void fastRemove(int index) {
             modCount++;
             int numMoved = size - index - 1;
             if (numMoved > 0)
                 System.arraycopy(elementData, index+1, elementData, index,
                                  numMoved);
             elementData[--size] = null; // clear to let GC do its work
         }
    ```
*  E get(int index)  //获取某个下标索引的元素
  ```
   public E get(int index) {
        //索引边界检查  检查不通过，抛出索引越界异常 IndexOutOfBoundsException 
        rangeCheck(index);
        //获取该索引位置的元素  返回
        return elementData(index);
    }
    //获取该索引位置的元素  返回
     E elementData(int index) {
            return (E) elementData[index];
        }
  ```
* E set(int index, E element) //设置某个位置的元素，返回老的元素
  
  ```
      public E set(int index, E element) {
          rangeCheck(index);//索引边界检查 
  
          E oldValue = elementData(index);//获取老的元素
          elementData[index] = element;//设置新的元素
          return oldValue;
      }
  ```
* sort(Comparator<? super E> c) //排序方法
  ```
  // 传入一个比较器 
     public void sort(Comparator<? super E> c) {
          //记录当前结构改变次数
          final int expectedModCount = modCount;
          //排序
          Arrays.sort((E[]) elementData, 0, size, c);
          //如果排序之后 结构改变次数与排序前改变次数 不相等 则抛出异常
          if (modCount != expectedModCount) {
              throw new ConcurrentModificationException();
          }
          modCount++;
      }
  ```
* 



  