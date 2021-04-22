package com.yukms.algorithms.sorting;

/**
 * 自顶向下 top-down
 *
 * @author yukms 2021/4/20 16:57
 */
public class MergeTD extends Merge {
    @Override
    public void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    protected void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        // 将数组a[lo..hi]有序
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // 将左半边排序
        sort(a, aux, lo, mid);
        // 将右半边排序
        sort(a, aux, mid + 1, hi);
        // 归并结果
        merge(a, aux, lo, mid, hi);
    }
}
