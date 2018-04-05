package com.lin.data.structure.sort;
/**
 * 数组排序工具类
 * @author chenlin
 *
 */
public class ArraySortUtil {

    /**
     * 验证数组正确性
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static boolean validArray(int[] array, int start, int end) {
        if(array==null||array.length<=1||start<0||end>array.length||start>end) {
            return false;
        }
        return true;
    }
    
    /**
     * 数组中元素下标i和j的两个值交互
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        if(!validArray(array,i,j)) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
