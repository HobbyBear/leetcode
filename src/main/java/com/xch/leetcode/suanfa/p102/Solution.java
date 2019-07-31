package com.xch.leetcode.suanfa.p102;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        NodePair rootPair = new NodePair(root,0);
        Queue<NodePair> queue = new LinkedList<>();
        if (root != null)
        queue.add(rootPair);
        while (!queue.isEmpty()){
            NodePair nodePair = queue.poll();
            if (nodePair.level == res.size()){
                res.add(new ArrayList<>());
            }
            res.get(nodePair.level).add(nodePair.node.val);
            if (nodePair.node.left != null)
            queue.add(new NodePair(nodePair.node.left,nodePair.level + 1));
            if (nodePair.node.right != null)
            queue.add(new NodePair(nodePair.node.right,nodePair.level + 1));
        }
        return res;
    }
}

class NodePair {
    TreeNode node;
    int level;

    public NodePair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}