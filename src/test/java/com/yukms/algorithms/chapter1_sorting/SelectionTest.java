package com.yukms.algorithms.chapter1_sorting;

/**
 * @author yukms 2021/4/14 14:40
 */
class SelectionTest extends BaseSortingTest {
    @Override
    void sort(Comparable[] a) {
        new Selection().sort(a);
    }
}