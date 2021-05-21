package com.yukms.algorithms.chapter2_searching;

import java.util.Iterator;

/**
 * 有序符号表
 *
 * @param <Key>
 * @param <Value>
 */
public abstract class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    public abstract Value get(Key key);

    public abstract void put(Key key, Value val);

    public abstract void delete(Key key);

    public abstract void remove(Key key);

    public abstract boolean contains(Key key);

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract Iterable<Key> keys();

    @Deprecated
    public abstract Iterator<Key> iterator();

    public abstract Key min();

    public abstract Key max();

    /**
     * 比Key大的中最小的
     */
    public abstract Key ceiling(Key key);

    /**
     * 比Key小的中最大的
     */
    public abstract Key floor(Key key);
}
