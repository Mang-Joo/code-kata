package io.github.mangjoo.domian;

public interface Storage<T> {

    void save(String key, T t);

    T find(String key, Class<T> clazz);
}
