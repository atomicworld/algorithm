package org.atomic.algorithm.HDAcm;

/**
 *  Reverse digits of an integer.
 *
 *  Example1: x = 123, return 321
 *  Example2: x = -123, return -321
 */
public class ReverseInteger {
    public static int reverse(int x) {
        boolean flag=true;
        if(x<0){
            flag=false;
        }
        x=java.lang.Math.abs(x);
        StringBuffer sb = new StringBuffer();
        sb.append(x);

        long res = 0, tmp;
        for (int i = sb.length() - 1; i >= 0; i--) {
            tmp = res * 10;
            int add = Character.getNumericValue(sb.charAt(i));
            res = add + tmp;
        }
        res=flag?res:-res;
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE)
            return 0;
        return (int)res;

    }

    public static void main(String[] args) {
//        int test=123;
//        int test=-123;
//        int test=-1534236469;
//        int test=1534236469;
//        int test=10;
        int test=0;
        System.out.println(reverse(test));
    }
}
