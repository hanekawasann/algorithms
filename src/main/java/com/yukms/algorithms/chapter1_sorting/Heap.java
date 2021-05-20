package com.yukms.algorithms.chapter1_sorting;

/**
 * @author yukms 2021/5/17 0:00
 */
public class Heap extends Sorting {
    @Override
    public void sort(Comparable[] pq) {
        int n = pq.length;

        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }

        int k = n;
        while (k > 1) {
            exchange(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    private void sink(Comparable[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            exchange(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    protected static void exchange(Comparable[] pq, int i, int j) {
        Comparable swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }
}
