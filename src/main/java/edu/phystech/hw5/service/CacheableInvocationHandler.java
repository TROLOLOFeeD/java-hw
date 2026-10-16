package edu.phystech.hw5.service;

import edu.phystech.hw5.annotation.Cacheable;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CacheableInvocationHandler implements InvocationHandler {
    private final Object target;
    private final ConcurrentMap<Method, ConcurrentMap<Object, Object>> cache = new ConcurrentHashMap<>();

    public CacheableInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object obj, Method method, Object[] arguments) throws Throwable {
        if (method.isAnnotationPresent(Cacheable.class)) {
            ConcurrentMap<Object, Object> workCache = cache.computeIfAbsent(method, k -> new ConcurrentHashMap<>());
            Object key = arguments[0];
            if (workCache.containsKey(key)) {
                return workCache.get(key);
            } else {
                try {
                    Object result = method.invoke(target, arguments);
                    workCache.put(key, result);
                    return result;
                } catch (InvocationTargetException exc) {
                    throw exc.getCause();
                }
            }
        } else {
            try {
                return method.invoke(target, arguments);
            } catch (InvocationTargetException exc) {
                throw exc.getCause();
            }
        }
    }
}