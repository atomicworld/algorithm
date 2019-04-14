package org.atomic.algorithm.HDAcm;

/**
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int len=0;
        String res=null;
        if(s!=null&&s.length()>0){
            len++;   //忘记“bbbb”这种情况啦
            for(int i=0;i<s.length()-1;i++){
                StringBuffer pattern=new StringBuffer(String.valueOf(s.charAt(i)));

                if(len>=(s.length()-i))
                    break;

                for(int j=i+1;j<s.length();j++){
                    String val=String.valueOf(String.valueOf(s.charAt(j)));
                    if(pattern.toString().contains(val)){
                        break;
                    }
                    pattern.append(val);
                    len=pattern.length()>len?pattern.length():len;
                    res=pattern.toString();
                }
            }
        }
        System.out.println(res);
        return len;
    }

    public static void main(String[] args) {
        String test="abcabcbb";
        int len=lengthOfLongestSubstring(test);
        System.out.println(len);
    }
}
