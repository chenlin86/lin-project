package com.lin.data.structure.list;

import java.util.Arrays;

/**
 * 顺序线性表
 * @author chenlin
 * @param <T>
 */
public class SequenceList<T> {

    private final int DEFAULT_SIZE = 16;
    // 数组的容量
    private int capacity;
    // 数组用于存储顺序线性变的元素
    private Object[] elementData;
    // 数组元素的个数
    private int size;

    /**
     * 默认线性表的初始化
     */
    public SequenceList() {
        this.capacity = DEFAULT_SIZE;
        this.elementData = new Object[capacity];
        this.size = 0;
    }
    
    /**
     * 初始化一个元素的线性表
     * @param element
     */
    public SequenceList(T element) {
        this.capacity = DEFAULT_SIZE;
        this.elementData = new Object[capacity];
        elementData[0] = element;
        this.size = 1;
    }
    
    /**
     * 初始化一个元素并制定长度
     * @param element
     * @param initSize
     */
    public SequenceList(T element,int initSize) {
        this.capacity = 1;
        while(capacity<initSize) {
            capacity <<=1;
        }
        this.capacity = DEFAULT_SIZE;
        this.elementData = new Object[capacity];
        elementData[0] = element;
        this.size = 1;
    }
    
    /**
     * 获取线性表的长度
     * @return
     */
    public int length() {
        return size;
    }
    
    /**
     * 通过下标获取线性表的元素
     * @param i
     * @return
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if(index<0||index>size-1) {
            throw new RuntimeException("线性表下标越界");
        }
        return (T)elementData[index];
    }
    
    /**
     * 查询指定元素在线性表中的位置
     * @param element
     * @return
     */
    public int index(T element) {
        for(int i=0;i<size;i++) {
            if(elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 向线性表指定位置插入元素
     * @param element
     * @param index
     */
    public void insert(T element,int index) {
        if(index<0||index>size) {
            throw new RuntimeException("线性表下标越界");
        }
        // 判断数组扩容
        ensureCapacity(size+1);
        // 将制定索引处的所有元素向后移动一倍
        System.arraycopy(elementData, index, elementData, index+1, size-index);
        elementData[index] = element;
        size++;
    }
    
    /**
     * 判断数组是否需要扩容
     * @param minCapacity
     */
    private void ensureCapacity(int minCapacity) {
        // 如果数组的原长度小于目标最小长度，则需要扩容
        if(minCapacity>capacity) {
            // 直接直接扩容为原来的capacity的2倍
            capacity<<=1;
            //复制数组
            elementData = Arrays.copyOf(elementData, capacity);
        }
    }
    
    /**
     * 顺序表添加元素(在表最后一个元素后追加元素)
     * @param element
     */
    public void add(T element) {
        insert(element,size);
    }
    
    /**
     * 根据下标删除制定元素
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    public T delete(int index) {
        if(index<0||index>size-1) {
            throw new RuntimeException("线性表下标越界");
        }
        T oldValue = (T)elementData[index];
        // 需要移动元素为该下标之后的所有元素
        int numMoved = size - index -1 ;
        // 如果不是最后一个元素，需要移动删除之后的元素，前进一位
        if(numMoved>0) {
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        }
        // 最后一个元素重置为空并长度减一
        elementData[--size]=null;
        return oldValue;
    }
    
    /**
     * 删除最后一个元素
     * @return
     */
    public T remove() {
        return delete(size-1);
    }
    
    /**
     * 判断线性表是否为空
     * @return
     */
    public boolean empty() {
        return size==0;
    }
    
    /**
     * 清空线性表
     */
    public void clear() {
        Arrays.fill(elementData, null);
        size = 0;
    }
    
    public String toString() {
        if(size==0) {
            return "[]";
        }else {
            StringBuilder sb = new StringBuilder("[");
            Arrays.stream(elementData).filter(e->e!=null).forEach(e->sb.append(e).append(","));
            // 删除最后一个,号并追加上]
            return sb.deleteCharAt(sb.lastIndexOf(",")).append("]").toString();
        }
    }
}
