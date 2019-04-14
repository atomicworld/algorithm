package org.atomic.algorithm.HDAcm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4SumTest {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4)
            return result;

        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len-3;i++) {
            if(i>0 && nums[i]==nums[i-1])
                continue;

            for(int j=i+1;j<len-2;j++){
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;

                int start=j+1;
                int end=len-1;
                while(start<end){
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if(sum < target){
                        start++;
                    } else if(sum > target){
                        end--;
                    } else {
                        List<Integer> tmp=new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[start]);
                        tmp.add(nums[end]);
                        result.add(tmp);

                        while(start<end && nums[start]==nums[start+1])
                            start++;
                        while(start<end && nums[end]==nums[end-1])
                            end--;

                        start++;
                        end--;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] test={4,-9,-2,-2,-7,9,9,5,10,-10,4,5,2,-4,-2,4,-9,5};
        int target=-13;
        System.out.println(fourSum(test, target));
    }

}
