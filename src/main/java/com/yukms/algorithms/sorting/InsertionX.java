package com.yukms.algorithms.sorting;

/**
 * @author yukms 2021/4/20 14:19
 */
public class InsertionX extends Sorting {
    @Override
    public void sort(Comparable[] a) {
        int n = a.length;

        // 把最小的元素放在适当的位置作为哨兵
        int exchanges = 0;
        for (int i = n - 1; i > 0; i--) {
            if (less(a[i], a[i - 1])) {
                exchange(a, i, i - 1);
                exchanges++;
            }
        }
        // 没有交换说明已是有序
        if (exchanges == 0) {
            return;
        }

        // 一半交换的插入排序
        for (int i = 2; i < n; i++) {
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = v;
        }
    }
}
