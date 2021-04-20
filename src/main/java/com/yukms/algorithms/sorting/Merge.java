package com.yukms.algorithms.sorting;

/**
 * @author yukms 2021/4/20 16:57
 */
public class Merge extends Sorting {
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        // 将数组a[lo..hi]有序
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // 将左半边排序
        sort(a, lo, mid);
        // 将右半边排序
        sort(a, mid + 1, hi);
        // 归并结果
        merge(a, lo, mid, hi);
    }

    private void merge(Comparable[] a, int lo, int mid, int hi) {
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
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
