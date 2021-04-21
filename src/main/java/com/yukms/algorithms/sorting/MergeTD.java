package com.yukms.algorithms.sorting;

/**
 * 自顶向下
 *
 * @author yukms 2021/4/20 16:57
 */
public class MergeTD extends Merge {
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
}
