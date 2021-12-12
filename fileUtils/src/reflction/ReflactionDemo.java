package reflction;

import fileutils.FileUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/** @Author: 云萧YYY @DateTime: 2021/11/12 @Description: TODO */
public class ReflactionDemo {

  public static void main(String[] args) throws ClassNotFoundException {
    //

    //      Class clazz = FileUtils.class;
    //
    //      Constructor[] constructors = clazz.getConstructors();

    Class clazz = Class.forName("fileutils.FileUtils");

    /** 获取当前运行类 和其父类的所有public 属性 */
    Field[] fields = clazz.getFields();
    /** 获取当前运行时类 所有声明的属性 ,不包括父类 */
    Field[] declaredFields = clazz.getDeclaredFields();

    Method[] declaredMethods = clazz.getDeclaredMethods();

    for (Method m : declaredMethods) {
      Annotation[] annotations = m.getAnnotations();
    }
  }
}
