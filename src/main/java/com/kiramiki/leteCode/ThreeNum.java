package com.kiramiki.leteCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNum {

    public static List<List<Integer>> threeNum(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3){
            return lists;
        }
        int[] num_0 = new int[nums.length];
        int[] num_1 = new int[nums.length];
        int x = 0;
        int y = 0;
        int count = -1;
        for (int i = 0 ; i < nums.length; i++){
            if (nums[i] < 0){
                num_0[x++] = nums[i];
            }
            if (nums[i] > 0){
                num_1[y++] = nums[i];
            }
            if (nums[i] == 0){
                count = 0;
            }
        }
        // num_0 = {-1,-1,-4}
        // num_1 = {1,2} count = 0
        for (int i = 0 ; i < x ; i++){
            for (int j = 0 ; j < y ; j++ ){
                int sum = num_0[i] + num_1[j];
                if (sum < 0){
                    for (int k = j+1; k < y; k++){
                        if (k == j){
                            continue;
                        }
                        int sums = sum + num_1[k];
                        if (sums == 0){
                            List<Integer> list = new ArrayList<>();
                            list.add(num_0[i]);
                            list.add(num_1[j]);
                            list.add(num_1[k]);
                            lists.add(list);
                        }
                    }
                }
                if (sum > 0){
                    for (int k = i+1; k < x; k++){
                        if (k == j){
                            continue;
                        }
                        int sums = sum + num_0[k];
                        if (sums == 0){
                            List<Integer> list = new ArrayList<>();
                            list.add(num_0[i]);
                            list.add(num_1[j]);
                            list.add(num_1[k]);
                            lists.add(list);
                        }
                    }
                }
                if (sum == 0 && count == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(num_0[i]);
                    list.add(num_1[j]);
                    list.add(0);
                    lists.add(list);
                }
            }
        }

        return lists;
    }


    public static List<List<Integer>> threeNum2(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3){
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i++){
            System.out.print(nums[i] + " ");
        }
        return null;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeNum2(nums);
//        System.out.println(lists);
    }
}
