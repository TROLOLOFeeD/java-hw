package edu.phystech.hw3.result;

import java.util.function.Function;

public final class Failure<T> implements Result<T> {
    private final Throwable e;

    public Failure(Throwable e) {
        this.e = e;
    }

    @Override
    public boolean isFailure() {
        if (e != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isSuccess() {
        if (e == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T getOrDefault(T defaultValue) {
        if (e == null) {
            return defaultValue;
        } else {
            return null;
        }
    }

    @Override
    public Throwable getExceptionOrNull() {
        if (e != null) {
            return e;
        } else {
            return null;
        }
    }

    //    Каюсь, не совладал
    @Override
    public <R> Result<R> map(Function<T, R> transform) {
        if (isFailure()) {
            return new Failure<>(e);
        } else {
            return new Failure<>(e);
        }
    }
}