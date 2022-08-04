package com.kiramiki.algorithms.sort;

/**
 * @ Author ：zl.
 * @ Date ：Created in 11:12 2022/8/4
 * @ Description ：归并排序
 */
public class MergeSort {


    public static void main(String[] args) {
        int arr[] = {3,2,5,8,4,7,6,9,1};
//        mergeSort(arr,0,arr.length-1);
        mergeSort(arr,0,arr.length-1);
        print(arr);
    }

    /**
     * 思想：归并排序是建立在归并操作上的一种有效的排序算法,该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，
     * 称为二路归并。
     * @param arr
     */
    public static void mergeSort(int []arr,int left,int right){
        int temp[] = new int[arr.length];
        if (right <= left) return;
        int p1 = left, mid = (left + right)/2, p2 = mid + 1, i = left;
        mergeSort(arr,p1,mid);
        mergeSort(arr,p2,right);
        while (p1 <= mid && p2 <= right ){
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            temp[i++] = arr[p1++];
        }
        while (p2 <= right){
            temp[i++] = arr[p2++];
        }
        for (i = left ; i <= right; i++){
            arr[i] = temp[i];
        }
        System.out.print("一轮");
        print(arr);
        System.out.println();
    }



    public static void swap(int []arr,int a,int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }



    public static void print(int []arr){
        for (int i = 0 ; i < arr.length; i++){
            System.out.printf( "%3d",arr[i]);
        }
    }
}
