package com.yukms.algorithms.fundamentals;

/**
 * @author yukms 2021/4/13 22:01
 */
public class QuickFindUF extends UF {
    public QuickFindUF(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        // 将p和q归并到相同的分量中
        int pId = find(p);
        int qId = find(q);

        // 如果p和q已经在相同的分量之中则不需要采取任何行动
        if (pId == qId) {
            return;
        }

        // 将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }
}
