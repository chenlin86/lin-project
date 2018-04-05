package com.lin.data.structure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树
 * @author chenlin
 * @param <E>
 */
public class TreeLinkBinTree<E> {
    
    // 树根结点
    private TreeNode root;
    
    /**
     * 默认构造器创建二叉树
     */
    public TreeLinkBinTree() {
        this.root = new TreeNode();
    }
    
    /**
     * 指定根元素创建二叉树
     * @param data
     */
    public TreeLinkBinTree(E data) {
        this.root = new TreeNode(data);
    }
    
    /**
     * 为指定的节点添加子节点
     * @param parent
     * @param data
     * @param isLeft
     * @return
     */
    public TreeNode addNode(TreeNode parent,E data,boolean isLeft) {
        if(parent==null) {
            throw new RuntimeException(parent+"节点为null,无法添加子节点");
        }
        if(isLeft&&parent.left!=null) {
            throw new RuntimeException(parent+"节点已有左节点,无法添加左子节点");
        }
        
        if(!isLeft&&parent.right!=null) {
            throw new RuntimeException(parent+"节点已有右节点,无法添加右子节点");
        }
        
        TreeNode node = new TreeNode(data);
        if(isLeft) {
            //让父节点的left引用指向新结点
            parent.left = node;
        }else {
            //让父节点的right引用指向新结点
            parent.right = node;
        }
        //让新结点的parent引用parent节点
        node.parent = parent;
        return node;
    }
        
    /**
     * 判断二叉树是否为空
     * @return
     */
    public boolean empty() {
        // 判断元素是否为空
      return  this.root.data == null;
    }    
    
    /**
     * 返回跟节点
     * @return
     */
    public TreeNode getRoot() {
        if(empty()) {
            throw new RuntimeException("树为空,无法访问跟节点");
        }
        return root;
    }
    
    /**
     * 获取指定节点的父节点值
     * @param node
     * @return
     */
    @SuppressWarnings("unchecked")
    public E parentData(TreeNode node) {
        if(node==null) {
            throw new RuntimeException("节点为空,无法访问父节点");
        }
        return node.parent==null?null:(E)node.parent.data;
    }
    
    /**
     * 获取指定节点的左节点值
     * @param parent
     * @return
     */
    @SuppressWarnings("unchecked")
    public E leftChild(TreeNode parent) {
        if(parent==null) {
            throw new RuntimeException("");
        }
        return parent.left == null ?null:(E)parent.left.data;
    }
    
    /**
     * 获取指定节点的右节点值
     * @param parent
     * @return
     */
    @SuppressWarnings("unchecked")
    public E rightChild(TreeNode parent) {
        if(parent==null) {
            throw new RuntimeException("");
        }
        return parent.right == null ?null:(E)parent.right.data;
    }
    
    /**
     * 返回二叉树的深度
     * @return
     */
    public int deep() {
        // 获取该树的深度
        return deep(root);
    }
    
    /**
     * 计算树的深度(通过递归计算每一个树的最大深度+1)
     * @param node
     * @return
     */
    private int deep(TreeNode node) {
        // 如果树为空，则深度为0
        if(node==null) {
            return 0;
        }
        // 如果没有子树，则深度为1
        if(node.left==null&&node.right==null) {
            return 1;
        }else {
            // 获取左树的深度
            int leftDeep = deep(node.left);
            // 获取右树的深度
            int rightDeep = deep(node.right);
            // 记录其所有左、右树中较大的深度
            int max = leftDeep > rightDeep ? leftDeep: rightDeep;
            // 返回左右子树中较大深度+1
            return max + 1;
        }
        
    }
    
    /**
     * 二叉树的遍历--前序遍历
     * @return
     */
    public List<TreeNode> preIterator(){
        return preIterator(root);
    }

    /**
     * 树的遍历--前序遍历
     * 1.访问跟节点
     * 2.递归遍历左子树
     * 3.递归遍历右子树
     * @param node
     * @return
     */
    private List<TreeNode> preIterator(TreeNode node) {
        List<TreeNode> list = new ArrayList<>();
        // 处理跟节点
        list.add(node);
        // 递归遍历左树
        if(node.left!=null) {
            list.addAll(preIterator(node.left));
        }
        // 递归遍历右树
        if(node.right!=null) {
            list.addAll(preIterator(node.right));
        }
        return list;
    }
       
    /**
     * 二叉树的遍历--中序遍历
     * @return
     */
    public List<TreeNode> inIterator(){
        return inIterator(root);
    }

    /**
     * 树的遍历--中序遍历
     * 1.递归遍历左子树
     * 2.访问跟节点
     * 3.递归遍历右子树
     * @param node
     * @return
     */
    private List<TreeNode> inIterator(TreeNode node) {
        List<TreeNode> list = new ArrayList<>();
        // 递归遍历左树
        if(node.left!=null) {
            list.addAll(preIterator(node.left));
        }
        // 处理跟节点
        list.add(node);
        // 递归遍历右树
        if(node.right!=null) {
            list.addAll(preIterator(node.right));
        }
        return list;
    }
    
    /**
     * 二叉树的遍历--后序遍历
     * @return
     */
    public List<TreeNode> postIterator(){
        return postIterator(root);
    }

    /**
     * 树的遍历--后序遍历
     * 1.递归遍历左子树
     * 2.递归遍历右子树
     * 3.访问跟节点
     * @param node
     * @return
     */
    private List<TreeNode> postIterator(TreeNode node) {
        List<TreeNode> list = new ArrayList<>();
        // 递归遍历左树
        if(node.left!=null) {
            list.addAll(preIterator(node.left));
        }
        // 递归遍历右树
        if(node.right!=null) {
            list.addAll(preIterator(node.right));
        }
        // 处理跟节点
        list.add(node);
        return list;
    }
    
    /**
     * 树的遍历--广度优先
     * 广度优先是按照层遍历，每层迭代遍历
     * @return
     */
    public List<TreeNode> breadthFirst(){
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        if(root!=null) {
           // 将跟元素加入队列
           queue.offer(root);
        }
        while(!queue.isEmpty()) {
            // 将队列的队尾元素加入到list中
            list.add(queue.peek());
            // 从队列的队首获取元素
            TreeNode node = queue.poll();
            // 如果左子节点不为null,将它加入队列 
            if(node.left!=null) {
                queue.offer(node.left);
            }
            // 如果右子节点不为null,将它加入队列
            if(node.right!=null) {
                queue.offer(node.right);
            }
        }
        return list;
    }
}
