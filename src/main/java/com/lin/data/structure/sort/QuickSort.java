package com.lin.data.structure.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 核心思想：通过一趟排序将要排序的数组元素分割成独立的两部分，其中一部分的所有数据都比另一部分的所有数据要小，然后再按照此方法对这两部分数组分别进行快速排序，整个排序过程中采用递归进行。
 * @author chenlin
 */
public class QuickSort {

   public static void main(String[] args) {
       int[] array = new int[] {1,9,10,3,8,110,200};
       System.out.println("元素值:"+Arrays.toString(array));
       quickSortFun(array,0,array.length-1);
       System.out.println("排序后的数组元素值："+Arrays.toString(array));
   }
   
    /**
     * 
     * @param array
     * @param start
     * @param end
     */
    private static void quickSortFun(int[] array, int start, int end) {
        // 验证数组的非正确性
        if(!ArraySortUtil.validArray(array, start, end)) {
            return;
        }
        // 数组随机分成两个组,分布排序两则的数据
        int pivot = divide(array,start,end);
        if(start<end) {
            quickSortFun(array,start,pivot-1); 
            quickSortFun(array,pivot+1,end);
        }
    }
    
//    1, 9, 10, 3, 8, 110, 200
//    x  
//       x
//                          y
//                     y
//                 y
//               y
//          y
//       y
//    y
    
//  1, 9, 10, 3, 8, 110, 200 
//     x
//        x
//            x
//                        y
//                   y
//               y

//  1, 9, 10, 8, 3, 110, 200 

    private static int partition(int[] array, int left, int right) {
        // 将左侧值作为枢纽值
        int pivot = array[left];
        // 当左侧位置小于右侧位置时候进行排序处理
        while(left<right) {
            // 当左侧位置的值小于中枢值时，下标后移
            while(left<right&&array[left]<=pivot) {
                left++;
            }
            if(left<right) {
                ArraySortUtil.swap(array,left,right);
                right--;
            }
            // 当右侧位置的值大于中枢值时，下标左移
            while(left<right&&array[right]>pivot) {
                right--;
            }
            if(left<right) {
                ArraySortUtil.swap(array,left,right);
                left++;
            }
        }
        return right;
    }
    
    public static int divide(int[] a, int start, int end){  
        //每次都以最右边的元素作为基准值  
        int base = a[end];  
        //start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此轮循环。  
        while(start < end){  
            while(start < end && a[start] <= base)  
                //从左边开始遍历，如果比基准值小，就继续向右走  
                start++;  
            //上面的while循环结束时，就说明当前的a[start]的值比基准值大，应与基准值进行交换  
            if(start < end){  
                //交换  
                int temp = a[start];  
                a[start] = a[end];  
                a[end] = temp;  
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位  
                end--;  
            }     
            while(start < end && a[end] >= base)  
                //从右边开始遍历，如果比基准值大，就继续向左走  
                end--;  
            //上面的while循环结束时，就说明当前的a[end]的值比基准值小，应与基准值进行交换  
            if(start < end){  
                //交换  
                int temp = a[start];  
                a[start] = a[end];  
                a[end] = temp;  
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值左边)，因此左边也要同时向后移动一位  
                start++;  
            }     
              
        }  
        //这里返回start或者end皆可，此时的start和end都为基准值所在的位置  
        return end;  
    } 
    
}
