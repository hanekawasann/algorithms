package com.yukms.algorithms.sorting;

import java.io.IOException;

import com.yukms.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yukms 2021/4/20 16:12
 */
class InsertionXTest extends BaseTest {
    @Test
    public void test_sort() throws IOException {
        Comparable<?>[] a = read("tiny.txt");
        new InsertionX().sort(a);
        Assertions.assertTrue(Sorting.isSorted(a));
    }
}