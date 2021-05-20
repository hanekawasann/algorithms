package com.yukms.algorithms.chapter1_sorting;

/**
 * @author yukms 2021/5/16 11:53
 */
class QuickBentleyMcIlroyTest extends BaseSortingTest {

    @Override
    void sort(Comparable[] a) {
        new QuickBentleyMcIlroy().sort(a);
    }
}