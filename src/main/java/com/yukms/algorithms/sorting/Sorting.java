package com.yukms.algorithms.sorting;

/**
 * @author yukms 2021/4/14 14:07
 */
public abstract class Sorting {
    public abstract void sort(Comparable[] a);

    protected static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static boolean eq(Comparable v, Comparable w) {
        if (v == w) {
            return true;
        }
        return v.compareTo(w) == 0;
    }

    protected void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }
}
