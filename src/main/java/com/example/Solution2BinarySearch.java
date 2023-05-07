package com.example;

/**
 * The algorithm works by finding the median index of the two arrays and then using a
 * binary search approach to find the actual median. First, we make sure that nums1
 * is smaller than or equal to nums2. Then, we set up variables to track the range of
 * indices to search in nums1 (iMin and iMax) and the total number of elements to the
 * left of the median point (halfLen). We then perform a binary search, where we use
 * i to represent the index of the middle element of nums1 and j to represent the
 * corresponding index in nums2. We move i left or right depending on whether
 * nums2[j-1] > nums1[i] or nums1[i-1] > nums2[j], respectively, until we find
 * the median point. At that point, we calculate the median based on whether the
 * total number of elements is odd or even.
 */
public class Solution2BinarySearch {

    public static void main(String[] args){
        Application.println("Enter 2 rows of integers separated by spaces: ");

        int[] arr1 = Application.parseInput();
        int[] arr2 = Application.parseInput();

        Application.println(findMedianSortedArrays(arr1, arr2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            // Make sure that nums1 is smaller than or equal to nums2
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j-1];
                } else if (j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
