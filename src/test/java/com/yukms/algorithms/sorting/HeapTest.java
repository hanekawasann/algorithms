package com.yukms.algorithms.sorting;

/**
 * @author yukms 2021/5/17 0:01
 */
class HeapTest extends BaseSortingTest {

    @Override
    void sort(Comparable[] a) {
        new Heap().sort(a);
    }

    public static void main(String[] args) {
        int k = 2;
        System.out.println((k--) - 1);
        System.out.println(k);
    }
}