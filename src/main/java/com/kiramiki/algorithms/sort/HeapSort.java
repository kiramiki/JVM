package com.kiramiki.algorithms.sort;

/**
 * @ Author ：kiramiki.
 * @ Date ：Created in 9:50 2022/8/3
 * @ Description ：堆排序
 */
public class HeapSort {


    /**
     * 构建大根堆
     * @param arr 原数组
     * @param i 当前元素
     */
    public static void heapTree(int [] arr,int length,int i){
        int temp = arr[i];
        int parent;
        int chird;
        System.out.print("调整前的堆");
        print(arr);
        for (parent = i,chird = parent * 2 + 1 ; chird < length ;parent = chird, chird = parent * 2 + 1){

            // 如果右儿子存在且右儿子更大，则放在节点右侧
            if (chird + 1 < length && arr[chird + 1] > arr[chird])
                chird++;
            if (temp < arr[chird]){
                arr[parent] = arr[chird];
            } else{
                break;
            }
        }
        arr[parent] = temp;
        System.out.print("调整后的堆");
        print(arr);
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 5, 8, 4, 7, 6, 9, 1};
        HeapSort(arr);
        print(arr);
    }

    public static void HeapSort(int[] arr) {
        //调整堆 (arr.length-2)/2 是确保 arr[2*parent+1]不会越界
        for (int i = (arr.length-2)/2;i >= 0 ; i--){
            heapTree(arr,arr.length,i);
        }
        System.out.println("调整完毕");
        // 从后往前
        for (int i = arr.length -1; i > -1; i--) {
            if (arr[0] > arr[i]){
                int t = arr[0];
                arr[0] = arr[i];
                arr[i] = t;
                // 每次从堆中弹出元素后，调整堆的结构
                heapTree(arr,i,0);
            }
        }
    }

    public void swap(int []arr , int i , int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
    }
}
