package com.example;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * <pre>
 * Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example1:
 * Input:nums1 = [1,3], nums2 = [2]
 * Output:2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example2:
 * Input:nums1 = [1,2], nums2 = [3,4]
 * Output:2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 *
 *
 * nums1.length == m
 *
 * nums2.length == n
 *
 * 0 <= m <= 1000
 *
 * 0 <= n <= 1000
 *
 * 1 <= m + n <= 2000
 *
 * -106 <= nums1[i], nums2[i] <= 106
 * </pre>
 */
public class Application {
    public static void main(String[] args){
        println("Enter two rows of space separated numbers: ");

        int[] intArray1 = parseInput();

        int[] intArray2 = parseInput();

        println("The median of the two arrays is: ", findMedianOfTwoArrays(intArray1, intArray2));
    }

    private static double findMedianOfTwoArrays(int[] arr1, int[] arr2){

        // start with 2 sorted arrays

        // keep track of index of each array

        // for N, where n = a1 + a2 sizes, compare array values

            // add smallest of each array to output array

            // increment index of matched array by 1

            // check array bounds

                // fill in remaining values and break if bound is reached for one arrays

            // increment N by 1

        int total = arr1.length + arr2.length;
        int[] mergedArr = new int[total];


        int arr1Index = 0;
        int arr2Index  = 0;

        for( int i = 0; i < total; i ++){
            if (arr1[arr1Index] < arr2[arr2Index]){
                mergedArr[i] = arr1[arr1Index];
                arr1Index++;
                if (arr1Index == arr1.length){
                    for(int y = i+1; y < total; y++){
                        mergedArr[y] = arr2[arr2Index];
                        arr2Index++;
                    }
                    break;
                }
            } else {
                mergedArr[i] = arr2[arr2Index];
                arr2Index++;

                if (arr2Index == arr2.length){
                    for(int y = i+1; y < total; y++){
                        mergedArr[y] = arr1[arr1Index];
                        arr1Index++;
                    }
                    break;
                }
            }
        }

        if (total % 2 == 0){
            int maxIndex = total - 1;
            return ((mergedArr[(maxIndex/2)]) + (mergedArr[(maxIndex/2)+1])) / 2.0;
        } else {
            return mergedArr[total/2];
        }
    }

    public static int[] parseInput(){
        Scanner sc = new Scanner(System.in);

        String row = sc.nextLine();
        return Stream.of(row.split(" ")).mapToInt(Integer::valueOf).sorted().toArray();
    }
    public static void println(Object ...o){
        for( var q : o ){
            System.out.print(q);
        }
        System.out.println();
    }
}
