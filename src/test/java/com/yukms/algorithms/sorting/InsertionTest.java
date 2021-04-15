package com.yukms.algorithms.sorting;

import java.io.IOException;

import com.yukms.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yukms 2021/4/15 16:45
 */
class InsertionTest extends BaseTest {
    @Test
    public void test_sort() throws IOException {
        Comparable<?>[] a = read("tiny.txt");
        new Insertion().sort(a);
        Assertions.assertTrue(Sorting.isSorted(a));
    }
}