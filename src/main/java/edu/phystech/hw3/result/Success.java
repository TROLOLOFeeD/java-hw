package edu.phystech.hw3.result;

import java.util.function.Function;


public final class Success<T> implements Result<T> {
    private final T value;

    public Success(T value) {
        this.value = value;
    }

    @Override
    public boolean isFailure() {
        if (value == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isSuccess() {
        if (value != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T getOrDefault(T defaultValue) {
        if (value != null) {
            return (T) value;
        } else {
            return defaultValue;
        }
    }

    @Override
    public Throwable getExceptionOrNull() {
        if (value != null) {
            return null;
        } else {
            Throwable out = new Throwable("Error");
            return out;
        }
    }

    @Override
    public <R> Result<R> map(Function<T, R> transform) {
        return new Success<>(transform.apply(value));
    }

}