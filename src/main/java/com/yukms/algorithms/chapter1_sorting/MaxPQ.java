package com.yukms.algorithms.chapter1_sorting;

/**
 * @author yukms 2021/5/16 21:40
 */
public abstract class MaxPQ<Key extends Comparable<Key>> {
    /** 基于堆的完全二叉树 */
    private Key[] pq;
    /** 存储于pq[1..]中，pq[0]没有使用 */
    private int n = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(Key v) {
        // 将新元素添加到数组末尾
        pq[++n] = v;
        swim(n);
    }

    public Key delMax() {
        // 从根节点得到最大元素
        Key max = pq[1];
        // 将其和最后一个节点交换
        exchange(1, n--);
        // 清空
        pq[n + 1] = null;
        // 恢复堆的有序性
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /** 上浮 */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }
    }

    /** 下沉 */
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }
}
