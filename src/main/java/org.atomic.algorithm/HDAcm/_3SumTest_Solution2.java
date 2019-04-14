package org.atomic.algorithm.HDAcm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Atomic on 2017/5/18.
 */
public class _3SumTest_Solution2 {

    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<List<Integer>>();

        for(int i=0;i<len-2;i++) {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int startIndex=i+1;
            int endIndex=len-1;

            search(nums, startIndex, endIndex, nums[i], res);
        }

        return res;
    }

    public void search(int nums[], int startIndex, int endIndex, int target, List<List<Integer>> res){
        int start=startIndex, end=endIndex;
        while(start<end){
            if(target + nums[start] + nums[end] == 0){
                List<Integer> tmp=new ArrayList<Integer>();
                tmp.add(target);
                tmp.add(nums[start]);
                tmp.add(nums[end]);
                res.add(tmp);

                while(start<end && nums[start]==nums[start+1]){
                    start++;
                }
                while(start<end && nums[end]==nums[end-1]){
                    end--;
                }

                start++;
                end--;

            } else if(target + nums[start] + nums[end] < 0){
                start++;
            } else {
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] test={ -1, 0, 1, 2, -1, -4 };
        _3SumTest_Solution2 init=new _3SumTest_Solution2();
        System.out.println(init.threeSum(test));
    }

}
