package com.lin.data.structure.tree;

/**
 * 树节点：包含有值，父节点，左节点和又节点
 * @author chenlin
 *
 */
public class TreeNode{
    Object data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    
    public TreeNode() {
    }
    
    public TreeNode(Object data) {
        this.data = data;
    }
    
    public TreeNode(Object data,TreeNode left,TreeNode right,TreeNode parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
