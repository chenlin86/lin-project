package com.lin.data.structure.list;

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
    
    
}
