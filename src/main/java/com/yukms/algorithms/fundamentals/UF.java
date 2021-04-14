package com.yukms.algorithms.fundamentals;

/**
 * @author yukms 2021/4/13 21:47
 */
public abstract class UF {
    /** 分量id */
    protected int[] id;
    /** 分量数量 */
    protected int count;

    public UF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public abstract int find(int p);

    public abstract void union(int p, int q);
}
