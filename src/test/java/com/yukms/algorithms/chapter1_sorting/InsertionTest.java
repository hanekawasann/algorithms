package com.yukms.algorithms.chapter1_sorting;

/**
 * @author yukms 2021/4/15 16:45
 */
class InsertionTest extends BaseSortingTest {
    @Override
    void sort(Comparable[] a) {
        new Insertion().sort(a);
    }
}