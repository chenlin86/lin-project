package com.lin.data.structure.queue;

import java.util.Arrays;

/**
 * 队列是一种特殊的线性表，只允许在表的前段(队头head)进行删除操作,只允许在表的后段(队尾tail)进行插入元素。
 * 对于队列,每个元素总是从队尾进入，然后等待该元素之前的所有元素出队后，再从队首出队。
 * @author chenlin
 */
public class SequenceQueue<E> {
    
    // 默认容量
    private static final int DEFAULT_SIZE = 10;
    // 保存数组的容量
    private int capacity;
    // 保存顺序队列的元素
    private Object[] elementData;
    // 保存顺序队列中元素的个数
    private int head = 0;
    private int tail = 0;
    
    /**
     * 以默认数组长度创建空顺序队列
     */
    public SequenceQueue() {
        elementData = new Object[DEFAULT_SIZE];
        capacity = DEFAULT_SIZE;
    }
    
    /**
     * 以一个初始元素来创建顺序队列
     * @param element
     */
    public SequenceQueue(E element) {
        this();
        elementData[0] = element;
        tail++;
    }
    
    /**
     * 以指定数组长度来创建一个初始化的顺序队列
     * @param element
     * @param initSize
     */
    public SequenceQueue(E element,int initSize) {
        elementData = new Object[initSize];
        capacity = initSize;
        elementData[0] = element;
        tail++;
    }
    
    /**
     * 获取顺序队列的长度
     * @return
     */
    public int length() {
        return tail - head;
    }
    
    /**
     * 元素入队--插入队尾
     */
    public void add(E element) {
        if(tail>capacity-1) {
            throw new RuntimeException("队列已经满");
        }
        elementData[tail++] = element;
    }
    
    /**
     * 元素出队--删除队首
     * @return
     */
    @SuppressWarnings("unchecked")
    public E remove() {
        if(empty()) {
            throw new RuntimeException("队列为空");
        }
        // 暂存队首元素的值
        E oldValue = (E) elementData[head];
        // 重置队首元素的值为空
        elementData[head++] = null;
        return oldValue;
    }
    
    /**
     * 返回队首元素
     * @return
     */
    @SuppressWarnings("unchecked")
    public E element() {
        if(empty()) {
            throw new RuntimeException("队列为空");
        }
        return (E) elementData[head];
    }
    
    
    /**
     * 判断队列是否为空
     * @return
     */
    public boolean empty() {
       return tail==head; 
    }
    
    /**
     * 清空顺序队列
     */
    public void clear() {
        // 将底层数组的所有元素赋值为null
        Arrays.fill(elementData, null);
        head = 0;
        tail = 0;
    }
    
    /**
     * toString
     */
    public String toString() {
        if(empty()) {
            return "[]";
        }else {
            StringBuilder sb = new StringBuilder("[");
            for(int i=head;i<tail;i++) {
                sb.append(elementData[i]).append(",");
            }
            return sb.deleteCharAt(sb.lastIndexOf(",")).append("]").toString();
        }
    }
    
}