package com.kiramiki.algorithms.leteCode;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumPlus {


    public static int[] twoSum(int[] nums, int target) {
        int [] sums = new int[2] ;
        for(int i = 0 ; i < nums.length ; i++){
            for (int j = nums.length - 1 ; j > i; j--){
                if (nums[i] + nums[j] == target){
                    sums[0] = i;
                    sums[1] = j;
                    break;
                }
            }
        }
        return sums;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int x = target - nums[i];
            if (hash.containsKey(x)){
                return new int[] {hash.get(target - nums[i]),i};
            }
            System.out.println(nums[i] + "---" + i);
            hash.put(nums[i],i);
        }
        return new int [0];
    }

    public static void main(String[] args) {
        // 2,3,4,5,6,7,8,9
        int[] nums = {3,2,5,8,4,7,6,9};
        int target = 8;
        int[] ints = twoSum2(nums, target);
        System.out.println(ints[0] + "----" + ints[1]);

        Date date = DateUtil.parse("2017-03-31 22:33:23");
        DateTime time = DateUtil.offsetDay(date, 1);
        String endDate = time.toString();
        System.out.println(endDate);
    }
}
