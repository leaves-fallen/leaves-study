package com.caofangqi.study.classloader;

public class ClassLoaderTest {

  public static void showClassLoaderTree() {
    ClassLoader loader = ClassLoaderTest.class.getClassLoader();
    while (loader != null) {
      System.out.println(loader);
      loader = loader.getParent();
    }
  }

  public static void showDifferentClassLoaderLoadClass() throws Exception {
    MyClassLoader myClassLoader = new MyClassLoader();
    Object obj = myClassLoader.loadClass("com.caofangqi.study.classloader.ClassLoaderTest")
        .newInstance();
    System.out.println(obj);
    System.out.println(obj instanceof ClassLoaderTest);
    System.out.println(obj.equals(new ClassLoaderTest()));
  }

  public static void main(String[] args) throws Exception {
    showClassLoaderTree();

  }

}
