package com.kiramiki.algorithms.sort;

/**
 * @ Author ：kiramiki.
 * @ Date ：Created in 15:41 2022/8/3
 * @ Description ：快速排序.
 */
public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {3,2,5,8,4,7,6,9,1};
//        quickSort(arr,0,arr.length-1);
        qkSort(arr,0,arr.length-1);
        print(arr);
    }

    /**
     * 思想：
     * 取一个中间元素，将比当前元素小的元素全部放左边，比当前元素大的全部放右边
     * 然后左边元素集中再取一个中间元素，比中间元素小的放左边，大的放右边
     * 继续重复，直到数组只剩一个中间元素，然后全部返回即可
     * @param arr
     */
    public static void quickSort(int []arr,int left,int right){
        int pos = 0;
        if (left < right){
            // 计算中间位置
            pos = quick(arr, left, right);
            quickSort(arr,left,pos-1);
            quickSort(arr,pos+1,right);
        }
    }

    /**
     *  取 4为中间元素
     *  low = 0;high = 9
     * @param arr
     * @param left
     * @param right
     */
    public static int quick(int []arr, int left,int right){
        int temp = arr[left];
        int low = left;
        int high = right;
        while(low < high){
            //循环结束标识当前节点high < temp
            while(low < high && arr[high] >= temp){
                high--;
            }
            if (low < high){
                arr[low] = arr[high];
                low++;
            }
            //循环结束表示当前节点low > temp
            while(low < high && arr[low] <= temp){
                low++;
            }
            if (low <high){
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = temp;
        return low;
    }



    public static void qkSort(int arr[], int left,int right){
        int i = left,j = right, mid = (i+j)/2;
        int temp = arr[mid];
        do {
            while (arr[i] < temp) i++;//找到第一个大于中间值的左边的元素
            while (arr[j] > temp) j--;//找到第一个小于中间值的右边的元素
            if ( i < j ){
                swap(arr,i,j);
                i++;
                j--;
            }
        } while (i < j);
        // 循环结束后i > j,此时需要对 i - right 部分进行递归
        if (i < right){
            qkSort(arr,i+1,right);
        }
        // 循环结束后j < i,此时需要对 left - j 部分进行递归
        if (j > left){
            qkSort(arr,left,j-1);
        }
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
