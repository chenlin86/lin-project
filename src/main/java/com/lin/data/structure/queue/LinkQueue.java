package com.lin.data.structure.queue;

public class LinkQueue<E> {

    private class Node{
        
        // 保存节点的值
        private E data;
        // 保存节点的下一个节点引用
        private Node next;
        
        /**
         * 全属性构造器
         * @param data
         * @param next
         */
        public Node(E data,Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
    // 保存链表队列的头节点
    private Node head;
    // 保存链表队列的尾节点
    private Node tail;
    // 保存链表队列的长度
    private int size;
    
    /**
     * 创建空链表队列
     */
    public LinkQueue() {
        // 空队列的头和尾都为空
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public LinkQueue(E element) {
        // 空队列的头和尾都为空
        this.head = new Node(element,null);
        // 只有一个节点,tail=head
        this.tail = this.head;
        size = 1;
    }
    
    /**
     * 链表队列的长度
     * @return
     */
    public int length() {
        return size;
    }
    
    
    /**
     * 入队--队尾加入元素
     * @param element
     */
    public void add(E element) {
        // 如果队尾空,即是空链表
        if(head==null) {
            head = new Node(element,null);
            tail = head ;
        }else {
            // 创建新节点
            Node node = new Node(element,null);
            // 将新节点赋给原尾节点的next
            tail.next = node;
            // 新节点赋给尾节点
            tail = node;
        }
        size++;
    }
    
    
    /**
     * 删除队列--队顶删除元素
     * @return
     */
    public E remove() {
        if(head==null) {
            throw new RuntimeException("队列为空，无法删除");
        }
        // 暂存原head节点
        Node oldHead = head;
        // 新head指向原head节点的next
        head = oldHead.next;
        // 原head的next指向null
        oldHead.next = null;
        size--;
        return oldHead.data;
    }
    
    /**
     * 获取队列队顶元素
     * @return
     */
    public E element() {
        return head.data;
    }
    
    /**
     * 判断链表队列是否为空队列
     * @return
     */
    public boolean empty() {
        return size==0;
    }
    
    /**
     * 清空队列
     */
    public void clear() {
        this.head = null;
        this.tail = null;
    }
    
    /**
     * toString
     */
    public String toString() {
        if(empty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for(Node current=head;current!=null;current=current.next) {
            sb.append(current.data).append(",");
        }
        return sb.deleteCharAt(sb.lastIndexOf(",")).append("]").toString();
    }
    
}