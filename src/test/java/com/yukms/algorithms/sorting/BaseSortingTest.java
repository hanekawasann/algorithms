package com.yukms.algorithms.sorting;

import java.io.IOException;

import com.yukms.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yukms 2021/4/24 17:45
 */
public abstract class BaseSortingTest extends BaseTest {
    @Test
    public void test_tiny() throws IOException {
        Comparable[] a = read("tiny.txt");
        sort(a);
        Assertions.assertTrue(Sorting.isSorted(a));
    }

    abstract void sort(Comparable[] a);
}
