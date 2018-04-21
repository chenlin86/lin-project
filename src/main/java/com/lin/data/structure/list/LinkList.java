package com.lin.data.structure.list;

/**
 * 单链表
 * 链表采用一组地址任意的存储单元存放线性表中的数据元素，其逻辑关系通过元素间的指针引用来实现。
 * 即每个节点元素都必须包含本身和一个引用(下一个元素)。
 * 为了便于实现在链表的尾部插入节点，可以单独用一个节点表示尾节点，这样在尾部插入的时候，时间复杂度为O(1)。
 * 如果没有尾节点的话，需要遍历查找尾节点，时间复杂度为O(n).
 * 由于单链表的元素插入在尾节点，删除在头节点。因此，链表有单独的头尾节点标识。
 * 优点：链表插入、删除比较快，内存空间可以充分利用，不需要预先分配。
 * 缺点：查找节点比较慢，需要迭代。另外，空间开销大。
 * @author chenlin
 */
public class LinkList<E> {

    private class Node {
        
        // 保存节点的值
        E data;
        
        // 指向下一个节点的引用
        Node next;
        
        public Node(E data,Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
    /**
     * 链表的头节点
     */
    private Node header;
    /**
     * 链表的尾节点
     */
    private Node tail;
    /**
     * 保存链表的节点个数
     */
    private int size;

    //构造空链表，首尾节点都是空的，长度为0
    public LinkList() {
        this.header = null;
        this.tail = null;
        this.size = 0;
    }
    
    // 构造含有一个元素的链表，首尾节点都指向同一个节点，长度为1
    public LinkList(E element) {
        this.header = new Node(element,null);
        this.tail = header;
        this.size = 1;
    }
   
    /**
     * 链表的长度
     * @return
     */
    public int length() {
        return size;
    }
    
    /**
     * 获取链表中索引为index处的元素
     * @param index
     * @return
     */
    public E get(int index) {
        Node node = getNodeByIndex(index);
        return node==null?null:node.data;
    }
    
    private Node getNodeByIndex(int index) {
        if(index<0||index>size-1) {
            throw new RuntimeException("链表的索引越界");
        }
        // 从header节点开始查找
        // 如果header为空直接返回空,如果索引等于迭代下标则直接返回,否则继续迭代下一个节点
        Node current = header;
        for(int i=0;i<size;i++) {
            if(current==null) {
                return null;
            }
            if(i==index) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    /**
     * 获取指定元素的下标
     * @param element
     * @return
     */
    public int index(E element) {
        // 从header开始迭代,如果头元素为空则返回-1,如果节点元素值等于查询值则返回迭代序号，否则继续迭代下一个节点
        Node current = header;
        for(int i=0;i<size&&current!=null;i++,current=current.next) {
            if(current.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }
    
    // 向线性表的指定位置插入一个元素
    public void insert(E element,int index) {
        if(index<0||index>size) {
            throw new RuntimeException("链表越界");
        }
        // 如果是空链表，直接插入
        if(header==null) {
            add(element);
        }else {
            // 当index为0时，即在链表头插入
            if(index==0) {
              addAtHeader(element);   
            }else {
                // 获取插入点的前一个节点
                Node prev = getNodeByIndex(index-1);
                prev.next = new Node(element,prev.next);
                size++;
            }
        }
        
    }

    // 尾插法：即在链表尾部插入元素
    public void add(E element) {
        //如果链表是空链表
        if(header==null) {
            this.header = new Node(element,null);
            this.tail = header;
        }else {
            //创建新节点
            Node node = new Node(element,null);
            tail.next = node;
            tail = node;
        }
        size++;
    }
    
    // 头插法：即在链表头插入元素
    private void addAtHeader(E element) {
        // 创建新节点,让新节点的next指向原来的header并以新节点作为header
        this.header = new Node(element,header);
        // 如果插入前是空链表
        if(tail==null) {
            tail = header;
        }
        size++;
    }
    
    /**
     * 删除链式线性表的指定元素
     * @param index
     * @return
     */
    public E delete(int index) {
        if(index<0||index>size-1) {
            throw new RuntimeException("链表越界");
        }
        Node del = null;
        // 如果被删除的是header节点
        if(index==0) {
            del = this.header;
            this.header = header.next;
        }else {
            // 获取删除节点的前一个节点
            Node prev = getNodeByIndex(index-1);
            // 获取将要删除的节点
            del = prev.next;
            // 让删除节点的next指向被删除节点的下一个节点
            prev.next = del.next;
            // 将被删除节点的next引用赋值为null
            del.next = null;
        }
        size--;
        return del.data;
    }
    
    /**
     * 删除链式线性表的最后一个元素
     * @return
     */
    public E remove() {
        return delete(size-1);
    }
    
    /**
     * 判断链式线性表是否为空
     * @return
     */
    public boolean empty() {
        return size==0;
    }
    
    /**
     * 清空线性表
     */
    public void clear() {
        // 将header、tail赋值为null，size=0
        this.header = null;
        this.tail = null;
        this.size = 0 ;
    }
    
    public String toString() {
        if(empty()) {
            return "[]";
        }else {
            StringBuilder sb = new StringBuilder("[");
            for(Node current=header;current!=null;current=current.next) {
                sb.append(current.data).append(",");
            }
            return sb.deleteCharAt(sb.lastIndexOf(",")).append("]").toString();
        }
    }
    
}
