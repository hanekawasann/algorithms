package com.yukms.algorithms.sorting;

/**
 * 希尔排序
 *
 * @author yukms 2021/4/19 10:16
 */
public class Shell extends Sorting {

    @Override
    public void sort(Comparable[] a) {
        // 将a[]按升序排列
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            // 1, 4, 13, 40, 121, 364, 1093, ...
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < n; i++) {
                // 将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]... 之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
