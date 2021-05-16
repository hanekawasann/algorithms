package com.yukms.algorithms.sorting;

/**
 * 三向切分的快速排序
 *
 * @author yukms 2021/5/16 10:26
 */
public class Quick3way extends Quick {
    @Override
    protected void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo;
        int gt = hi;
        Comparable v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                // a[i]小于v，将a[lt]和a[i]交换，将lt和i加一
                exchange(a, lt++, i++);
            } else if (cmp > 0) {
                // a[i]大于v，将a[gt]和a[i]交换，将gt减一
                exchange(a, i, gt--);
            } else {
                // a[i]等于v，将i加一
                i++;
            }
        }

        // 现在a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
