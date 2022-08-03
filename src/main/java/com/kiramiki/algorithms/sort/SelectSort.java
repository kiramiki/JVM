package com.kiramiki.algorithms.sort;

/**
 * @ Author ：zyw.
 * @ Date ：Created in 16:19 2022/8/2
 * @ Description ：选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int arr[] = {3,2,5,8,4,7,6,9,1};
        SelectSort(arr);
        print(arr);
    }

    /**
     * 思想：
     * 每次遍历，记录最小值，然后将最小值放在最前面，然后遍历范围缩小，因为每次跃迁幅度相对较大，因此排序不稳定
     * @param arr
     */
    public static void SelectSort(int []arr){
        for (int i = 0 ; i < arr.length; i++){
          int min = i;
          for (int j = i+1; j < arr.length; j++){
              if (arr[min] > arr[j]){
                  min = j;
              }
          }
          //将数组首位和最小值进行交换,然后缩小范围
            int t = arr[i];
            arr[i] = arr[min];
            arr[min] = t;

            print(arr);
            System.out.println();
        }
    }

    public static void print(int []arr){
        for (int i = 0 ; i < arr.length; i++){
            System.out.printf( "%3d",arr[i]);
        }
    }
}
