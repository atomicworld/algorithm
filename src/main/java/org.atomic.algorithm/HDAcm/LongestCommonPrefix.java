package org.atomic.algorithm.HDAcm;

/**
 * 前缀
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int len=strs.length;
        if(len<1) return "";
        if(len==1) return strs[0];

        int minLen=Integer.MAX_VALUE;
        for(String item:strs)
        {
            if(minLen>item.length())
            {
                minLen=item.length();//找到最短子串
            }
        }

        char tmp;
        String longestPrefix="";
        boolean flag=true;
        for(int i=0;i<minLen;i++)
        {
            tmp=strs[0].charAt(i);
            for(int j=1;j<len;j++)
            {
                char c=strs[j].charAt(i);
                if(tmp==c)
                    continue;
                else
                    flag=false;
            }
            if(flag)
                longestPrefix=strs[0].substring(0,i+1);
        }

        return longestPrefix;
    }

    public static void main(String[] args) {
        String[] test={"c","c"};
        System.out.println(longestCommonPrefix(test));
    }
}
