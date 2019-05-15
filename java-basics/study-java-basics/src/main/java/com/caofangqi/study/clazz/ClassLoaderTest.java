package com.caofangqi.study.clazz;

import java.io.InputStream;

public class ClassLoaderTest {



    public static void main(String [] args)throws Exception{

       MyClassLoader myClassLoader=new MyClassLoader();
         Object obj=myClassLoader.loadClass("com.caofangqi.study.clazz.ClassLoaderTest").newInstance();
        System.out.println(obj);
        System.out.println(obj instanceof ClassLoaderTest);
        System.out.println(obj.equals(new ClassLoaderTest()));

    }

}
class MyClassLoader extends  ClassLoader{


    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        try {
            String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
            InputStream is=getClass().getResourceAsStream(fileName);
            if (is==null){
                return super.loadClass(name);
            }
            byte[]b=new byte[is.available()];
            is.read(b);
            return defineClass(name,b,0,b.length);
        }catch (Exception e){
            throw new RuntimeException("Class not found");
        }
    }
}