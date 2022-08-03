package com.kiramiki.algorithms.sort;

/**
 * @ Author ：kiramiki.
 * @ Date ：Created in 9:08 2022/8/3
 * @ Description ：希尔排序
 */
public class ShellSort {


    public static void main(String[] args) {
        int arr[] = {3, 2, 5, 8, 4, 7, 6, 9, 1};
        ShellSort(arr);
        print(arr);
    }

    /**
     * 希尔排序就是对插入排序的优化，
     * 插入排序是步长为1的希尔排序
     * 优化的理念是尽量保证局部的数组是有序的，而插入排序对较有序数组排序效率是非常高的。
     * （刚开始时虽然每组有序度低，但其数据量小；随着每轮的增量逐渐压缩，虽然各组数据量逐渐变大，但其有序度逐渐增加。）
     * @param arr
     */
    public static void ShellSort(int[] arr) {
        // 设定步长为3;
        int k = 3;
        while(k > 0){
            for (int i = k; i < arr.length; i++){
                int temp = arr[i];
                for (int j = i; j > 0 && temp < arr[j - 1]; j--) {
                    int t = arr[j - k];
                    arr[j - k] = arr[j];
                    arr[j] = t;
                    print(arr);
                    System.out.println();
                }
            }
            k--;
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
    }
}
