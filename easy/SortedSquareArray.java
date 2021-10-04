package easy;

/**
 * @author Brandon Soledad
 * 
 * Algorithms Practice
 * 
 * Write a function that takes a non-empty array of integers that are sorted in ascending order and returns a new array
 * of the same length with the squares of the original integers also sorted in ascending order.
 */

import java.util.*;

public class SortedSquareArray {
    public static void main(String[] args) {
        int[] array;
        System.out.println(Arrays.toString(array = sortedSquaredArray(new int[]{1, 2, 3, 5, 6, 8, 9}))); // output: [1, 4, 9, 25, 36, 64, 81] 
    }
    // Time: O(n) Space: O(n) where n is the length of the input array.
    public static int[] sortedSquaredArray(int[] array) {
        int[] newArr = new int[array.length];
            for(int i = 0; i< array.length; i++){
                newArr[i] = array[i] * array[i];
            }
            Arrays.sort(newArr);
        return newArr;
      }
}
