package org.zhendong;

import java.util.List;

public class MultiNode {
    public int val;
    public List<MultiNode> children;

    public MultiNode() {}

    public MultiNode(int _val) {
        val = _val;
    }

    public MultiNode(int _val, List<MultiNode> _children) {
        val = _val;
        children = _children;
    }
};
