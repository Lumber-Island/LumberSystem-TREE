package dev.lumberisland.helpers;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionHelper {

    public static Class<?> getClass(String path){
        try {
            return Class.forName(path);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static Method getMethod(Class<?> clazz, String methodName, Class<?>... args){
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            declaredMethod.setAccessible(true);
            if(declaredMethod.getName().equals(methodName)) {
                if(declaredMethod.getParameterTypes().length == 0)
                    return declaredMethod;
                else if (args.length != 0 && Arrays.equals(args, declaredMethod.getParameterTypes())) return declaredMethod;
            }
        }
        return null;
    }

    public static Field getField(Class<?> clazz, String fieldName){
        for (Field declaredField : clazz.getDeclaredFields()) {
            declaredField.setAccessible(true);
            if(declaredField.getName().equals(fieldName)) return declaredField;
        }
        return null;
    }

    public static Object get(Field field, Object object){
        try {
            return field.get(object);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public static void setValue(Field field, Object inObject, Object newValue){
        try {
            if(!field.isAccessible()) field.setAccessible(true);
            field.set(inObject, newValue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void setValue(String fieldName, Object inObject, Object newValue){
        Class<?> clazz = inObject.getClass();
        Field field = getField(clazz, fieldName);

        if(field == null) return;

        setValue(field, inObject, newValue);
    }

    public static Object invoke(Method method, Object inObject, Object... args){
        try {
            return method.invoke(inObject, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    public static Object newInstance(Class<?> clazz){
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    public static Constructor<?> getConstructor(Class<?> clazz, Class<?>... args){
        try {
            return clazz.getConstructor(args);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Object newInstance(Constructor<?> constructor, Object... args){
        try {
            return constructor.newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    public static boolean isStatic(Method method){
        method.setAccessible(true);
        return Modifier.isStatic(method.getModifiers());
    }

    public static boolean isStatic(Field field) {
        field.setAccessible(true);
        return Modifier.isStatic(field.getModifiers());
    }
}
