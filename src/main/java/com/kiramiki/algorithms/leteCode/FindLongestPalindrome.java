package com.kiramiki.algorithms.leteCode;

/**
 * @ Author ：zyw.
 * @ Date ：Created in 9:32 2022/8/1
 * @ Description ：最长回文子串
 */
public class FindLongestPalindrome {


    private static String str = "basdfdsasqwerrewq";

    private static String sub = "";

    public static void main(String[] args) {
        // 中心扩展
//        longestPalindrome(str);
        dpLongestPalindrome("cabaw");
        System.out.println(sub);
    }

    /**
     *  中心扩展
     * @param s str
     * @return
     */
    public static String longestPalindrome(String s){
        if (s.length() <= 1){
            return s;
        }
        for (int i = 0 ; i < s.length()-1; i++){
            findLongestPalindrome(str,i,i);//单核回文
            findLongestPalindrome(str,i,i+1);//双核回文
        }
        return sub;
    }

    public static void findLongestPalindrome (String s,int low ,int high){
        while(low >= 0 && high <= s.length()-1){
            if (s.charAt(low) == s.charAt(high)){
                if (high - low + 1 > sub.length()){
                    sub = s.substring(low,high+1);
                }
                low--;
                high++;
            } else {
                break;
            }
        }
    }

    /**
     *  str = "cabaw"
     *    c a b a w
     *  c
     *  a
     *  b
     *  a
     *  w
     *
     *  动态规划
     *   存储每次执行结果
     * @param s
     */
    public static String dpLongestPalindrome(String s){
        if ( s.length() <= 1){
            return s;
        }
        boolean [][]dp = new boolean[s.length()][s.length()];
        for (int i = s.length()-1 ; i >= 0; i--){
            for (int j = i ; j < s.length() ; j++){
                if (s.charAt(i) == s.charAt(j)){
                    if (j -i <= 1){
                        dp[i][j] = true;
                    } else if (dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && j-i + 1 > sub.length() ){
                    sub = s.substring(i,j+1);
                    System.out.println("i : " + i);
                    System.out.println("j : " + j);
                }
            }
        }
        for (int i = 0 ; i < s.length(); i ++){
            for (int j = 0 ; j < s.length() ; j++){
                System.out.printf("%6b",dp[i][j]);
            }
            System.out.println();
        }

        return sub;
    }

}
