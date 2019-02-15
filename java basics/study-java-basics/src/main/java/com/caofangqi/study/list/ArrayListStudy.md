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
  
         // overflow-conscious code
         if (minCapacity - elementData.length > 0)
             grow(minCapacity);
  }
  ```
