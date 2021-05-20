package com.yukms.algorithms.chapter1_sorting;

/**
 * @author yukms 2021/4/21 23:22
 */
class MergeBUTest extends BaseSortingTest {
    @Override
    void sort(Comparable[] a) {
        new MergeBU().sort(a);
    }
}