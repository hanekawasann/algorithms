package com.yukms.algorithms.sorting;

/**
 * 快速三向切分
 *
 * @author yukms 2021/5/16 11:09
 */
public class QuickBentleyMcIlroy extends Quick {
    private static final int INSERTION_SORT_CUTOFF = 8;
    private static final int MEDIAN_OF_3_CUTOFF = 40;

    @Override
    protected void sort(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;

        if (n <= INSERTION_SORT_CUTOFF) {
            // 插入排序
            insertionSort(a, lo, hi);
            return;
        } else if (n <= MEDIAN_OF_3_CUTOFF) {
            // 中位数
            int m = median3(a, lo, lo + n / 2, hi);
            exchange(a, m, lo);
        } else {
            // use Tukey ninther as partitioning element
            int eps = n / 8;
            int mid = lo + n / 2;
            int m1 = median3(a, lo, lo + eps, lo + eps + eps);
            int m2 = median3(a, mid - eps, mid, mid + eps);
            int m3 = median3(a, hi - eps - eps, hi - eps, hi);
            int ninther = median3(a, m1, m2, m3);
            exchange(a, ninther, lo);
        }

        // Bentley-McIlroy 3-way partitioning
        int i = lo;
        int j = hi + 1;
        int p = lo;
        int q = hi + 1;
        Comparable v = a[lo];
        while (true) {
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

            if (i == j && eq(a[i], v)) {
                exchange(a, ++p, i);
            }
            if (i >= j) {
                break;
            }

            exchange(a, i, j);

            if (eq(a[i], v)) {
                exchange(a, ++p, i);
            }
            if (eq(a[j], v)) {
                exchange(a, --q, j);
            }
        }

        // 将两边的v交换到中间
        i = j + 1;
        for (int k = lo; k <= p; k++) {
            exchange(a, k, j--);
        }
        for (int k = hi; k >= q; k--) {
            exchange(a, k, i++);
        }

        sort(a, lo, j);
        sort(a, i, hi);
    }

    /**
     * 返回a[i], a[j], a[k]中的中位数的索引
     */
    private static int median3(Comparable[] a, int i, int j, int k) {
        return less(a[i], a[j])//
            ? (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i)//
            : (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i);
    }

    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) { exchange(a, j, j - 1); }
        }
    }
}