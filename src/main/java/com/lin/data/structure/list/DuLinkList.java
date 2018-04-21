package com.lin.data.structure.list;

/**
 * 双向链表
 * 每个节点都可以向前引用,向后引用。
 * 方便数据插入,删除操作。由于双向链表需要维护两个方向引用，因此添加和删除节点成本比较大。
 * 当操作指定索引处节点的搜索，删除比较快，只需要处理一半节点即可。
 * @author chenlin
 */
public class DuLinkList<E> {

    private class Node{
        
        // 节点的值
        E data;
        // 节点上一个节点引用
        Node prev;
        // 节点下一个节点引用
        Node next;
        
        /**
         * 初始化全部属性的节点构造器
         * @param data
         * @param prev
         * @param next
         */
        public Node(E data,Node prev,Node next){
            this.data = data;
            this.prev =  prev;
            this.next = next;
        }
    }
        
    // 保存双向链表的头节点
    private Node header;
    // 保存双向链表的尾节点
    private Node tail;
    // 保存双向链表的长度
    private int size;
    
    /**
     * 创建空链表
     */
    public DuLinkList() {
        this.header = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * 以指定数据元素创建链表
     * @param element
     */
    public DuLinkList(E element) {
        // 构造一个只有元素的node,赋值给header
        this.header = new Node(element,null,null);
        // 链表只有一个节点，header和tail都指向它
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
        return getNodeByIndex(index).data;
    }
    
    /**
     * 根据索引index获取指定位置的元素
     * 如果index小于size/2则从头节点开始查找,否则从尾节点查找
     * @param index
     * @return
     */
    public Node getNodeByIndex(int index) {
        if(index<0||index>size-1) {
            throw new RuntimeException("线性双向链表索引越界");
        }
        // 根据index与size/2的值比较，判断从头节点还是尾节点开始遍历
        if(index<=size/2) {
            // 从头部向next遍历
            Node current = this.header;
            for(int i=0;i<=size/2&&current!=null;i++,current=current.next) {
                if(i==index) {
                    return current;
                }
            }
        }else {
            // 从尾部向prev遍历
            Node current = this.tail;
            for(int i=size-1;i>size/2&&current!=null;i--,current=current.prev) {
                if(i==index) {
                    return current;
                }
            }
        }
        return null;
    }
    
    /**
     * 查找链表中指定元素的索引
     * @param element
     * @return
     */
    public int index(E element) {
        // 从头节点开始搜索
        Node current = this.header;
        for(int i=0;i<size&&current!=null;i++,current=current.next) {
            if(current.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 向线性双向链表的指定位置插入一个元素
     * @param element
     * @param index
     */
    public void insert(E element,int index) {
        if(index<0||index>size) {
            throw new RuntimeException("线性双向链表索引越界");
        }
        // 如果是空链表
        if(header==null) {
            add(element);
        }else {
            // 当index=0时，在链表的表头插入
            if(index==0) {
                addAtHeader(element);
            }else {
                // 获取插入节点的前一个节点
                Node prev = getNodeByIndex(index-1);
                // 获取插入节点的当前节点
                Node current = prev.next;
                // 创建新节点
                Node node = new Node(element,prev,current);
                // 构造节点的关系
                prev.next = node;
                current.prev = node;
                size++;
            }
        }
    }
    
    public void add(E element) {
        // 如果链表是空
        if(header==null) {
            this.header = new Node(element,null,null);
            // 只有一个节点,header和tail都指向该节点
            this.tail = header;
        }else {
            // 创建新节点,prev为tail,next为空
            Node node = new Node(element,tail,null);
            // 让原尾节点的next指向新节点
            tail.next = node;
            // 将新节点作为新的尾节点
            this.tail = node;
        }
        size++;
    }
    
    /**
     * 采用在头节点上插入新节点
     * @param element
     */
    public void addAtHeader(E element) {
        // 创建新节点，让新节点的next指向原来header,
        // 原header的prev指向新header,并将新节点作为新header
        // 源header节点
        Node source = this.header;
        this.header = new Node(element,null,source);
        source.prev = source;
        // 如果插入的为空链表
        if(tail==null) {
            this.tail = header;
        }
        size++;
    }
    
    public E delete(int index) {
        if(index<0||index>size-1) {
            throw new RuntimeException("线性双向链表索引越界");
        }
        Node del = null;
        // index ==0即删除头节点
        if(index==0) {
            // 待删除的节点
            del = header;
            // 将头节点移向元头的下一个元素
            header = header.next;
            // 并将原头节点置为空
            header.prev = null;
        }else {
            // 获取删除节点的前一个节点
            Node prev = getNodeByIndex(index-1);
            // 待删除的节点
            del = prev.next;
            prev.next = del.next;
            // 如果删除节点的next不为空，则需要将待删除节点prev指向prev
            if(del.next!=null) {
                del.next.prev = prev;
            }
            // 待删除节点的prev和next引用指向null
            del.next = null;
            del.prev = null;
        }
        size --;
        return del.data;
    }
    
    /**
     * 删除线性双向链表中删除最后一个元素
     * @return
     */
    public E remove() {
        return delete(size-1);
    }
    
    /**
     * 判断线性双向链表是否空表
     * @return
     */
    public boolean empty() {
        return size==0;
    }
    
    /**
     * toString
     */
    public String toString() {
        if(empty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for(Node current=header;current!=null;current=current.next) {
            sb.append(current.data).append(",");
        }
        return sb.deleteCharAt(sb.lastIndexOf(",")).append("]").toString();
    }
    
    /**
     * 倒序toString
     * @return
     */
    public String reverseToString() {
        if(empty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for(Node current=tail;current!=null;current=current.prev) {
            sb.append(current.data).append(",");
        }
        return sb.deleteCharAt(sb.lastIndexOf(",")).append("]").toString();
    }
    
}