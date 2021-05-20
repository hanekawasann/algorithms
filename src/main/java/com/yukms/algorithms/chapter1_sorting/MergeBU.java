package com.yukms.algorithms.chapter1_sorting;

/**
 * 自底向上 bottom-up
 *
 * @author yukms 2021/4/21 23:18
 */
public class MergeBU extends Merge {
    @Override
    public void sort(Comparable[] a) {
        // 进行lgN次两两归并
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        // sz子数组大小
        for (int sz = 1; sz < n; sz = sz + sz) {
            // lo：子数组索引
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }
}
