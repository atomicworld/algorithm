package org.atomic.algorithm.HDAcm;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 *  Input: "babad"
 *  Output: "bab"
 *
 * Note: "aba" is also a valid answer.
 * Example:
 *  Input: "cbbd"
 *  Output: "bb"
 *
 */
// 穷举法的时间复杂度过高，接下来我们用DP进行优化。
// 对于母串s，我们用dp[i,j]=1，表示子串s[i..j]为回文子串，那么就有递推式
//      dp[i,j] = dp[i+1,j−1]  当 s[i]=s[j]
//                   0         当 s[i]≠s[j]
//  上述递推式的含义：
//      当s[i]=s[j]时，如果s[i+1..j-1]是回文子串，则s[i..j]也是回文子串；
//      当s[i+1..j-1]不是回文子串（或s[i]≠s[j]），则s[i..j]也不是。
//      特别地，对于这样的字符串——只包含单个字符、或者两个字符重复，其均为回文串：
//        dp[i,i] = 1
//        dp[i,i+1] = 1 当s[i] == s[i+1]
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s==null || s.length()<=1)
            return s;

        int len = s.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        String longest = null;
        for(int l=0; l<s.length(); l++){
            for(int i=0; i<len-l; i++){
                int j = i+l;
                //相邻的相等的两个字符也是 回文， 递推公式也是回文
                if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
                    dp[i][j]=true;

                    if(j-i+1>maxLen){
                        maxLen = j-i+1;
                        longest = s.substring(i, j+1);
                    }
                }
            }
        }
        if(maxLen==1){
            longest=String.valueOf(s.charAt(0));
        }
        return longest;
    }

    public static void main(String[] args) {
        String str="abcda";
        System.out.println(longestPalindrome(str));
    }

}
