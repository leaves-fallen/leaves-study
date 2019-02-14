# ArrayList  源码阅读
ArrayList 实现了 List 接口，动态数组。线程不安全。
## 重要字段
* DEFAULT_CAPACITY = 10;  //默认初始化数组长度
* Object[] EMPTY_ELEMENTDATA = {}; //Shared empty array instance used for empty instances.
* Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {}; //用于默认构造函数的数组初始化
## 构造方法
 无参构造方法
 ````
    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
 ````