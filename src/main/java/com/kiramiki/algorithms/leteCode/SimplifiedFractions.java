package com.kiramiki.algorithms.leteCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1447. 最简分数
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 * 示例 4：
 *
 * 输入：n = 1
 * 输出：[]
 */
public class SimplifiedFractions {

    public static List<String> simplifiedFractions(int n) {
        // 1 [] , 2 [1/2] , 3 [1/2,1/3,2/3], 4 [1/2,1/3,2/3,1/4,3/4] ,5 [1/2,1/3,2/3,1/4,3/4,1/5,2/5,3/5,4/5]
        int zs[] = {2,3,5,7,9,11,13,17,23,29,31,34,37,41,43,47,53,59,61,67,71,73,79,83,89,91,97};
        List<String> list = new ArrayList<>();
        if ( n == 1){
            return list;
        }
        if (n == 2){
            list.add("1/2");
            return list;
        }
        for (int i = 2 ; i <= n ; i++){
            for (int k = 1; k < i ; k++){
                for (int j = 0 ; j < zs.length - 1 ; j++){
                    if ( n < zs[j+1] ){
                        if (zs[j]%k == 0 && zs[j]%i == 0){
                            continue;
                        }
                        list.add(i + "/" + j);
                    }
                    if (i > zs[j]){
                        break;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // 2,3,4,5,6,7,8,9
        int[] nums = {3,2,5,8,4,7,6,9};
        int target = 3;
//        List<String> ints = simplifiedFractions(target);
//        System.out.println(ints);
        float cent = (float)3/7;
        String handleRate = cent * 100 + "";
        System.out.println(handleRate);
        handleRate = handleRate.substring(0, 5);
        System.out.println(handleRate);
        handleRate = handleRate + "%";
        System.out.println(handleRate);
        System.out.println(handleRate);
    }
}
