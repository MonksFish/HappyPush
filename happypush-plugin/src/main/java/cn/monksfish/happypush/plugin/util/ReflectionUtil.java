package cn.monksfish.happypush.plugin.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.DefaultParameterNameDiscoverer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author 小沙弥
 * @description 反射工具类
 * @date 2022/9/6 2:33 下午
 */
public class ReflectionUtil {


    /**
     * 通过反射进行调用
     * @param object 目标实例
     * @param methodName 目标实例的方法
     * @param paramObj 目标实例的参数
     * @return 调用返回
     */
    public static Object invoke(Object object, String methodName, Object paramObj) throws InvocationTargetException, IllegalAccessException {

        if (Objects.isNull(object)) {
            throw new RuntimeException("object is null, cannot invoke method");
        }
        Method method = getMethod(object.getClass(), methodName);
        if (Objects.isNull(method)) {
            throw new RuntimeException("method is null, cannot invoke method");
        }
        // 利用Spring提供的类获取方法形参名
        DefaultParameterNameDiscoverer nameDiscoverer = new DefaultParameterNameDiscoverer();
        String[] paramArray =  nameDiscoverer.getParameterNames(method);
        if (null == paramArray) {
            throw new RuntimeException("paramArray is null, cannot invoke method");
        }
        // 获取方法执行的参数
        List<Object> objects = new ArrayList<>();
        // 如果方法只有一个参数，那么就把当前对象整个传入
        if (paramArray.length == 1) {
            objects.add(paramObj);
        } else {
            // 如果方法不止有一个参数，那么证明有一个参数列表，所以需要解析传入的对象，拿到这个对象的所有变量的值，之后进行每个单独赋值
            objects.addAll(getMethodParamList(method, objToMap(paramObj), paramArray));
        }
        // 执行方法
        return Objects.requireNonNull(method).invoke(object, objects.toArray());
    }



    /**
     * 获取方法参数列表
     * @param method 方法
     * @param objToMap 对象转换后的map类型的参数列表 key:参数名 value:参数值
     * @param paramArray 获取方法上的所有参数列表
     */
    private static List<Object> getMethodParamList(Method method, TreeMap<String, Object> objToMap, String[] paramArray) {

        List<Object> objectList = new ArrayList<>();
        if (ArrayUtils.isEmpty(paramArray)) {
            throw new RuntimeException("");
        }
        for (int i = 0; i < method.getParameterTypes().length; i++) {
            Object object = null;
            if(paramArray != null && objToMap.containsKey(paramArray[i])){
                object = objToMap.get(paramArray[i]);
            }
            objectList.add(object);
        }
        return objectList;
    }


    /**
     * 获取目标方法
     * @param proxyObject 目前类
     * @param methodName 方法名
     * @return 方法
     */
    private static Method getMethod(Class<?> proxyObject, String methodName) {
        Method[] methods = proxyObject.getMethods();
        // 这里的时间复杂度是O(n)，可以使用map，用空间换时间，时间复杂度降低为O(1)，以后抽空优化
        for(Method method : methods) {
            if(method.getName().equalsIgnoreCase(methodName)) {
                return method;
            }
        }
        return null;
    }




    /**
     * 把一个对象转换成Map
     * @param object 目标对象
     * @return 返回map key:字段名 value:字段值
     */
    private static TreeMap<String, Object> objToMap(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        TreeMap<String, Object> objectTreeMap = new TreeMap<>();
        while (clazz.getSuperclass() != null) {
            // 获取所有变量
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                // 拿到变量名
                String name = declaredField.getName();
                // 修改访问控制权限
                declaredField.setAccessible(true);
                Object value = declaredField.get(object);
                // 设置到Map
                objectTreeMap.put(name, value);
            }
            clazz = clazz.getSuperclass();
        }
        return objectTreeMap;
    }

}
