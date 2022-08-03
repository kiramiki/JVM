package com.kiramiki.algorithms.sort;

/**
 *
 * @ Author ：zl.
 * @ Date ：Created in 15:57 2022/8/2
 * @ Description ：冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3,2,5,8,4,7,6,9,1};
        bubbleSort(arr);
        print(arr);
    }

    /**
     * 思想：
     * 每次遍历，遇到比当前小的则交换，如果当前循环没有发生过交换，则退出。
     * @param arr
     */
    public static void bubbleSort(int []arr){
        for (int i = 0 ; i < arr.length; i++){
            int cnt = 0;
            for (int j = 1 ; j < arr.length; j++){
                if (arr[j-1] > arr[j]){
                    int t = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = t;
                    cnt = 1;
                }
            }
            // 表示没有发生过交换
            if (cnt == 0){
                break;
            }
        }
    }

    public static void print(int []arr){
        for (int i = 0 ; i < arr.length; i++){
            System.out.printf( "%3d",arr[i]);
        }
    }

}
