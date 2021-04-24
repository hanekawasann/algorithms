package com.yukms.algorithms.sorting;

/**
 * @author yukms 2021/4/19 18:09
 */
class ShellTest extends BaseSortingTest {
    @Override
    void sort(Comparable[] a) {
        new Shell().sort(a);
    }
}