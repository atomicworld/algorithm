package org.atomic.algorithm.HDAcm;

import java.util.Arrays;

/**
 * Created by Atomic on 2017/5/18.
 */
public class _3SumClosestTest {

    public int threeSumClosest(int[] nums,  int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);

        int compareVal=Integer.MAX_VALUE;
        int res=0;
        int len=nums.length;
        for(int i=0;i<len-2;i++) {
            if(i>0 && nums[i]==nums[i-1])
                continue;

            int start=i+1;
            int end=len-1;
            while(start<end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum < target){
                    if (target-sum < compareVal) {
                        compareVal = target - sum;
                        res = sum;
                    }
                    start++;
                } else if(sum > target){
                    if (sum-target < compareVal) {
                        compareVal = sum - target;
                        res = sum;
                    }
                    end--;
                } else {
                    return sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] test = { -1, 2, 1, -4 };
//        int[] test = { -1, 0, 1 };
        int[] test = { -1, 1, 1 };
        int target = 0;
        _3SumClosestTest init=new _3SumClosestTest();
        System.out.println(init.threeSumClosest(test, target));
    }

}
