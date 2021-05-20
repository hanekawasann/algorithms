package com.yukms.algorithms.chapter1_sorting;

/**
 * 切换到插入排序
 *
 * @author yukms 2021/5/16 10:57
 */
public class QuickX extends Quick {
    private static final int INSERTION_SORT_CUTOFF = 8;

    @Override
    protected void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        // 插入排序
        int n = hi - lo + 1;
        if (n <= INSERTION_SORT_CUTOFF) {
            insertionSort(a, lo, hi + 1);
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }
}
