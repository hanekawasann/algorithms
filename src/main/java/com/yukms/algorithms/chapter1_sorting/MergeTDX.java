package com.yukms.algorithms.chapter1_sorting;

import java.util.Arrays;

/**
 * 自顶向下改进
 *
 * @author yukms 2021/4/22 10:31
 */
public class MergeTDX extends MergeTD {
    private static final int CUTOFF = 7;

    @Override
    public void sort(Comparable[] a) {
        Comparable[] aux = Arrays.copyOf(a, a.length);
        // 将数据从输入数组排序到辅助数组
        sort(aux, a, 0, a.length - 1);
    }

    @Override
    protected void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
        // 对小规模子数组使用插入排序
        if (hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid + 1, hi);

        // 判断测试数组是否已经有序
        if (!less(src[mid + 1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }

        // 将数据从辅助数组排序到输入数组
        merge(src, dst, lo, mid, hi);
    }

    private void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }

    @Override
    protected void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                dst[k] = src[j++];
            } else if (j > hi) {
                dst[k] = src[i++];
            } else if (less(src[j], src[i])) {
                dst[k] = src[j++];
            } else {
                dst[k] = src[i++];
            }
        }
    }
}
