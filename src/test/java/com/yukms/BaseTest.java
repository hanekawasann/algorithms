package com.yukms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author yukms 2021/4/13 22:17
 */
public abstract class BaseTest {
    protected Comparable[] read(String fileName) throws IOException {
        InputStream is = this.getClass().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String s = reader.readLine();
        return s.split(" ");
    }
}
