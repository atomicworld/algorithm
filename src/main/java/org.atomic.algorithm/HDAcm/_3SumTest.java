package org.atomic.algorithm.HDAcm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Atomic on 2017/5/18.
 */
public class _3SumTest {

    public static List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int num_1,num_2,num_3;

        for(int i=0;i<len-2;i++){
            num_1=nums[i];
            for(int j=i+1;j<len-1;j++) {
                num_2 = nums[j];
                for(int k=j+1;k<len;k++) {
                    num_3 = nums[k];
                    if (num_1 + num_2 + num_3 == 0) {

                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num_1);
                        tmp.add(num_2);
                        tmp.add(num_3);
                        Collections.sort(tmp);//对3个元素进行排序，因为list是有序集合，所以需要排序来排除相同值
                        if(!res.contains(tmp))
                            res.add(tmp);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test={ -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(test));
    }

}
