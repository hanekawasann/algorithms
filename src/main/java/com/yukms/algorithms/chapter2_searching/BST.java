package com.yukms.algorithms.chapter2_searching;

import java.util.Iterator;

/**
 * 基于二叉查找树的有序符号表
 *
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {
    /** 二叉查找树的根节点 */
    private Node root;

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x.value;
        }
        return cmp < 0 ? get(x.left, key) : get(x.right, key);
    }

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public void remove(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        return x == null ? 0 : x.n;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    @Override
    public Key min() {
        return null;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    @Override
    public Key max() {
        return null;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public Key floor(Key key) {
        Node x = floor(root, key);
        return x == null ? null : x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        return t != null ? t : x;
    }

    private class Node {
        /** 键 */
        private Key key;
        /** 值 */
        private Value value;
        /** 以该节点为跟的子树中节点总数 */
        private int n;
        /** 左树 */
        private Node left;
        /** 右树 */
        private Node right;

        private Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }
}
