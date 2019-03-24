# 遇见的BUG

## Arrays中的ArrayList 的toArray()方法不能 始终返回 Object[]
如下代码:
```
  public static void main(String[] args) {
    List l = Arrays.asList(args);
    
    System.out.println(l.toArray());
    System.out.println(l.toArray(new Object[0]));
  }
```
运行结果如下:
```
[Ljava.lang.String;@14ae5a5
[Ljava.lang.Object;@7f31245a
```
这是因为Arrays中的ArrayList 重写的 toArray方法是通过 clone来实现的，如下:
```
   @Override
        public Object[] toArray() {
            return a.clone();
        }
```
该BUG在 jdk9 中已修复。jdk9实现如下
```
  @Override
        public Object[] toArray() {
            return Arrays.copyOf(a, a.length, Object[].class);
        }
```
参考资料:
* https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-6260652