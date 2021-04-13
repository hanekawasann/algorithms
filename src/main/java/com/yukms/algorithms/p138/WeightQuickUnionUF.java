package com.yukms.algorithms.p138;

/**
 * @author yukms 2021/4/13 23:21
 */
public class WeightQuickUnionUF extends QuickUnionUF {
    /** （由触点索引的）各个根节点所对应的分量的大小 */
    private int[] sz;

    public WeightQuickUnionUF(int n) {
        super(n);
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            sz[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        // 将小树的根节点连接到大树的根节点
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}
