package org.atomic.algorithm.HDAcm;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *  nums1 = [1, 3]
 *  nums2 = [2]
 *
 * The median is 2.0
 *
 * Example 2:
 *  nums1 = [1, 2]
 *  nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 */
public class MedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int totalLen=len1+len2;
        int[] res = new int[totalLen];

        if(nums1==null || len1==0){
            if(totalLen%2==0) {
                return (nums2[totalLen/2]+nums2[totalLen/2 - 1]) / 2.0;
            }else{
                return nums2[totalLen/2];
            }
        }

        if(nums2==null || len2==0){
            if(totalLen%2==0) {
                return (nums1[totalLen/2]+nums1[totalLen/2 - 1]) / 2.0;
            }else{
                return nums1[totalLen/2];
            }
        }

        if(nums1!=null && nums2!=null && len1>0 && len2>0) {
            int currNum1 = nums1[0];
            int currNum2 = nums2[0];
            int j = 0;
            int k = 0;

            for (int i = 0; i < totalLen; i++) {
                if(j==len1 && i<totalLen){
                    res[i] = currNum2;
                    k++;
                    if(k<len2)
                        currNum2=nums2[k];
                    else
                        break;
                }
                if(k==len2 && i<totalLen){
                    res[i] = currNum1;
                    j++;
                    if(j<len1)
                        currNum1=nums1[j];
                    else
                        break;
                }
                if(currNum1<=currNum2){
                    if(j < len1) {
                        res[i] = currNum1;
                        j++;
                        currNum1 = j < len1 ? nums1[j] : 0;
                    }
                }else{
                    if(k<len2) {
                        res[i] = currNum2;
                        k++;
                        currNum2 = k < len2 ? nums2[k] : 0;
                    }
                }
            }

            if (totalLen % 2 == 0) {
                return (res[totalLen/2] + res[totalLen/2 - 1]) / 2.0;
            } else {
                return res[totalLen/2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
//        int[] nums1 = new int[0];
//        int[] nums1 = {1};
//        int[] nums2 = new int[0];
        int[] nums2 = {2};
//        int[] nums2 = {3,4};
        double res=findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
