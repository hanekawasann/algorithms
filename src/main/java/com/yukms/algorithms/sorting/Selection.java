package com.yukms.algorithms.sorting;

/**
 * 选择排序
 *
 * @author yukms 2021/4/14 14:30
 */
public class Selection extends Sorting {
    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // 将a[i]和a[i+1..n]中最小的元素交换
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }
}
