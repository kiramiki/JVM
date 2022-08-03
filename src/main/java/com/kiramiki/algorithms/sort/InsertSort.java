package com.kiramiki.algorithms.sort;

/**
 * @ Author ：zyw.
 * @ Date ：Created in 16:31 2022/8/2
 * @ Description ：插入排序
 */
public class InsertSort {


    public static void main(String[] args) {
        int arr[] = {3, 2, 5, 8, 4, 7, 6, 9, 1};
        InsertSort(arr);
        print(arr);
    }

    /**
     * 思想：
     * 类似于拿牌，每次拿牌后，在已有的数组中进行插入
     * 因此，当数组基本有序时候，插入排序效率很高
     * 举例数组 {3,2,5,8,4,7,6,9,1}
     * 已有数组为[3]
     * 插入2
     * 2和3比较，比三小，则交换
     * 有序数组为[2,3]
     * 插入5
     * 有序数组为[2,3,5]
     * 插入4
     * 4和5比较，比5小，则4和5交换
     * 有序数组为[2,3,4,5]
     * @param arr
     */
    public static void InsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j > 0 && temp < arr[j - 1]; j--) {
                int t = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = t;
                print(arr);
                System.out.println();
            }
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
    }
}
