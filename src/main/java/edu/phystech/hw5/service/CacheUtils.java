package edu.phystech.hw5.service;

import java.lang.reflect.Proxy;

public class CacheUtils {
    public static <T> T getCacheProxy(Class<T> clazz, T object) {
        // Здесь приведен пример того, как можно создавать динамический прокси
        return (T) Proxy.newProxyInstance(
                CacheUtils.class.getClassLoader(),
                new Class[]{clazz},
                new CacheableInvocationHandler(object));
    }
}