# ArrayList  源码阅读
ArrayList 实现了 List 接口，动态数组。线程不安全。
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