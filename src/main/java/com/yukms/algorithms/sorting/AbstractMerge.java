package com.yukms.algorithms.sorting;

/**
 * @author yukms 2021/4/21 15:15
 */
public abstract class AbstractMerge extends Sorting {
    protected Comparable[] aux;

    /**
     * 原地归并
     */
    protected void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将 a[lo..mid] 和 a[mid..hi] 归并
        int i = lo;
        int j = mid + 1;

        // 将a[lo..hi]复制到aux[lo..hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // 归并回到a[lo..hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                // 左半边用尽（取右半边元素）
                a[k] = aux[j++];
            } else if (j > hi) {
                // 右半边用尽（取左半边元素）
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                // 右半边的当前元素小于左半边的当前元素（取右半边的元素）
                a[k] = aux[j++];
            } else {
                // 左半边的当前元素小于右半边的当前元素（取左半边的元素）
                a[k] = aux[i++];
            }
        }
    }
}
