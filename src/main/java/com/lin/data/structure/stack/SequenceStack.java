package com.lin.data.structure.stack;

import java.util.Arrays;

/**
 * 栈是一种特殊的线性表，通常提供在尾部插入和删除。
 * 顺序栈是利用一组连续存储空间来依次存放从栈底到栈顶的数据元素，栈底位置不变，栈顶元素可以通过数组下标来访问。
 * @author chenlin
 */
public class SequenceStack<E> {

    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;
    // 保存数组的容量
    private int capacity;
    // 当底层数组容量不够时，程序每次增加的数组长度
    private int capacityIncrement;
    // 保存栈中元素的数组
    private Object[] elementData;
    // 保存栈中元素个数
    private int size;
    
    /**
     * 默认容量在创建空栈
     */
    public SequenceStack() {
        this.capacity = DEFAULT_CAPACITY;
        this.elementData = new Object[capacity];
    }
    
    /**
     * 以单个元素来创建栈
     * @param element
     */
    public SequenceStack(E element) {
        this.capacity = DEFAULT_CAPACITY;
        this.elementData = new Object[capacity];
        this.elementData[0] = element;
        size++;
    }
    
    /**
     * 以单个元素和固定长度来创建栈
     * @param element
     * @param initSize
     */
    public SequenceStack(E element,int initSize) {
        this.capacity = initSize;
        this.elementData = new Object[capacity];
        this.elementData[0] = element;
        size++;
    }
    
    /**
     * 以单个元素和固定长度及指定扩容长度来创建栈
     * @param element
     * @param initSize
     */
    public SequenceStack(E element,int initSize,int capacityIncrement) {
        this.capacity = initSize;
        this.elementData = new Object[capacity];
        this.elementData[0] = element;
        size++;
        this.capacityIncrement = capacityIncrement;
    }
    
    /**
     * 获取栈的大小
     * @return
     */
    public int length() {
        return size;
    }
    
    /**
     * 入栈
     */
    public void push(E element) {
        ensureCapacity(size+1);
        elementData[size++] = element;
    }
    
    /**
     * 确认数组的长度是否满足入栈后的长度
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity) {
        // 如果数组的原有容量小于入栈后的长度，则需要扩容
        if(minCapacity>this.capacity) {
            // 如果指定扩容长度大于0,则按照指定扩容长度扩容
            if(this.capacityIncrement>0) {
                // 按照指定扩容长度扩容
                this.capacity+=this.capacityIncrement;
            }else {
                // 按照原长度的2倍扩容
                this.capacity<<=1;
            }
            // 数组扩容
            elementData = Arrays.copyOf(elementData, capacity);
        }
    }
    
    /**
     * 出栈
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        // 获取栈顶元素
        E oldValue = (E)elementData[size-1];
        // 栈顶元素置为空
        elementData[--size] = null;
        return oldValue;
        
    }
    
    /**
     * 获取栈顶元素
     * @return
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        return (E)elementData[size-1];
    } 

    /**
     * 判断是否为空栈
     * @return
     */
    public boolean empty(){
        return size==0;
    }
    
    /**
     * 清空栈
     */
    public void clear() {
        Arrays.fill(elementData, null);
        size=0;
    }
    
    
    /**
     * toString
     */
    public String toString() {
        if(size==0) {
            return "[]";
        }else {
            StringBuilder sb = new StringBuilder("[");
            for(int i=0;i<size;i++) {
                sb.append(elementData[i]).append(","); 
            }
            // 删除最后一个,号并追加上]
            return sb.deleteCharAt(sb.lastIndexOf(",")).append("]").toString();
        }
    }
}
