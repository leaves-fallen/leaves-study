# HashMap 学习笔记 (jdk 1.8)

```
This map usually acts as a binned (bucketed) hash table, but when bins get too large,they are transformed into bins of TreeNodes, each structured similarly to those in java.util.TreeMap.

HashMap通常是一个不安全的哈希桶，但是当桶太大的时候，会变成类似TreeNodes 结构的树。

```

# 重要字段

