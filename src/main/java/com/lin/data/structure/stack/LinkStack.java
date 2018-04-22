package com.lin.data.structure.stack;

/**
 * 栈是一种特殊的线性表，通常提供在尾部插入和删除。
 * 链式栈是利用链表实现栈内元素的存放，在栈底操作，通常单独存储栈顶元素。
 * @author chenlin
 */
public class LinkStack<E> {

    private class Node{
        
        // 保存节点的数据
        private E data;
        // 指向下个节点的引用
        private Node next;
    
        /**
         * 初始化全部属性构造器
         * @param data
         * @param next
         */
        public Node(E data,Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
    // 保存链表栈的栈顶元素
    private Node top;
    // 保存链表栈中的节点数
    private int size;
    
    /**
     * 创建空栈
     */
    public LinkStack() {
        // 空链表
        this.top = null;
    }
    
    /**
     * 以指定数据元素来创建栈
     * @param element
     */
    public LinkStack(E element) {
        this.top = new Node(element,null);
        this.size++;
    }
    
    /**
     * 获取栈的长度
     * @return
     */
    public int length() {
        return size;
    }
    
    /**
     * 入栈
     * @param element
     */
    public void push(E element) {
        top = new Node(element,top);
        size++;
    }
    
    /**
     * 出栈
     * @return
     */
    public E pop() {
        // 获取原栈顶元素
        Node oldTop = top;
        // 新栈顶执行原栈顶的next
        this.top = top.next;
        // 原栈顶引用取消
        oldTop.next = null;
        // 长度减一
        size--;
        return oldTop.data;
    }
    
    /**
     * 获取栈顶元素
     * @return
     */
    public E peek() {
        return top.data;
    }
    
    /**
     * 判断栈是否为空
     * @return
     */
    public boolean empty() {
        return size==0;
    }
    
    /**
     * 清空栈
     */
    public void clear() {
        top = null;
        size = 0;
    }
    
    /**
     * toString
     */
    public String toString(){
        // 空链表
        if(empty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for(Node current = top;current!=null;current=current.next) {
            sb.append(current.data).append(",");
        }
        return sb.deleteCharAt(sb.lastIndexOf(",")).append("]").toString();
    }
}
