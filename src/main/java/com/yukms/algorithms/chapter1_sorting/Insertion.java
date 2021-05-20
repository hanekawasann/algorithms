package com.yukms.algorithms.chapter1_sorting;

/**
 * 插入排序
 *
 * @author yukms 2021/4/15 15:47
 */
public class Insertion extends Sorting {
    @Override
    public void sort(Comparable[] a) {
        // 将a[]按升序排列
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // 将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }
}
