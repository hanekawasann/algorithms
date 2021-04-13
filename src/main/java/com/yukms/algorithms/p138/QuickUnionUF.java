package com.yukms.algorithms.p138;

/**
 * @author yukms 2021/4/13 22:24
 */
public class QuickUnionUF extends UF {
    public QuickUnionUF(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        // 找出分量的名称
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        // 将p和q的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }
}
