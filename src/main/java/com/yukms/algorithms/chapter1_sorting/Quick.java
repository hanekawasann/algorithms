package com.yukms.algorithms.chapter1_sorting;

/**
 * @author yukms 2021/4/24 17:31
 */
public class Quick extends Sorting {
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    protected void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        // 切分
        int j = partition(a, lo, hi);
        // 将左半部分a[lo..j-1]排序
        sort(a, lo, j - 1);
        // 将右半部分a[j+1..hi]排序
        sort(a, j + 1, hi);
    }

    protected int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
        // 左右扫描指针
        int i = lo;
        int j = hi + 1;
        // 切分元素
        Comparable v = a[lo];
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        // 将v = a[j]放入正确的位置
        exchange(a, lo, j);
        // a[lo..j-1] <= a[j] <= a[j+1..hi]达成
        return j;
    }
}
