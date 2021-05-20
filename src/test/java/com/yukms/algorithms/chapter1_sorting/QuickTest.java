package com.yukms.algorithms.chapter1_sorting;

/**
 * @author yukms 2021/4/24 17:44
 */
class QuickTest extends BaseSortingTest {
    @Override
    void sort(Comparable[] a) {
        new Quick().sort(a);
    }
}