package com.kiramiki.jvm3;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     *  给定一个数组nums和一个target ，返回数组中相加和为target 的元素数组下标
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums,int target){
        /**
         * 思路，将其放到一个哈希表中，每次判断是否在哈希表中含有这个元素，如果含有，表示已经算过一次。之后可以不用再次计算
         * K 值， V 下标，
         */
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length ; i++ ){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,13};
        int target = 9;
        int[] result=twoSum(nums,target);
        System.out.println(result[0] + " " +result[1]);
    }
}
