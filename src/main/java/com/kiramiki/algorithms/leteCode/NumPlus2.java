package com.kiramiki.algorithms.leteCode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 2006. 差的绝对值为 K 的数对数目
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 *
 * |x| 的值定义为：
 *
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumPlus2 {

    public static int countKDifference(int[] nums, int k) {
        int num = 0;
        for(int i = 0 ; i < nums.length; i++ ){
           for(int j = nums.length-1 ; j > i; j-- ){
               int count;
               count = nums[i] - nums[j];
               if (count < 0){
                   count = -count;
               }
               if (count == k){
                   num++;
               }
           }
        }
        return num;
    }

    // hash
    public static int countKDifference2(int[] nums, int k) {
        int num = 0;
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++ ){
            for(int j = nums.length-1 ; j > i; j-- ){
                int count;
                count = nums[i] - nums[j];
                if (count < 0){
                    count = nums[j] - nums[i];
                }
                if (hashMap.containsKey(count)){
                    hashMap.put(count,i);
                }
                if (count == k){
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        // 2,3,4,5,6,7,8,9
        int[] nums = {3,2,5,8,4,7,6,9};
        int target = 3;
        int ints = countKDifference(nums, target);
        System.out.println(ints);
    }
}
