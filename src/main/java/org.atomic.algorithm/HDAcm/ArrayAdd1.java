package org.atomic.algorithm.HDAcm;

/**
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *  You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *  Given nums = [2, 7, 11, 15], target = 9,
 *
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 */
public class ArrayAdd1 {

    public static int[] twoSum(int[] nums, int target) {

//        boolean flag=false;
//        int[] book=new int[nums.length];
//        for(int i=0;i<book.length;i++) book[i]=0;

        for(int j=0;j<nums.length;j++){
            int k=j+1;
//            while(k<nums.length || !flag){
            while(k<nums.length){
                int sum = nums[j]+nums[k];
                if(target==sum){
                    int[] res={j,k};
                    return res;
                }
                k++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,6,8,7};
        int target = 8;

        int[] res=twoSum(nums, target);
        for(int index:res){
            System.out.println(index);
        }
    }

}
