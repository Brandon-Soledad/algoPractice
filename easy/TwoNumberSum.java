package easy;

/**
 * @author Brandon Soledad
 * 
 * Algorithms Practice
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
   You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.
 */
import java.util.*;

class TwoNumberSum {

    public static void main(String[] args) {
        int[] output;
        System.out.println(Arrays.toString(output = twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10))); // Expected output [-1, 11] or [11, -1]
        System.out.println(Arrays.toString(output = twoNumberSumOptimized(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10))); //Expected output [-1, 11] or [11, -1]
    }
    // Time: O(n^2) Space: (1) where n is the length of the input array.
    public static int[] twoNumberSum(int[] array, int targetSum) {
        for(int i = 0; i < array.length - 1;i++){
                    int firstNum = array[i];
                for(int j = i + 1; j< array.length;j++){
                    int secondNum = array[j];
                    if(firstNum+secondNum==targetSum){
                        return new int[]{firstNum,secondNum};
                    }
                    
                }
            }
        return new int[0];
    }
    // Time: O(n) Space: (n) where n is the length of the input array. (Used an auxiliary data structure to improve run time)
    public static int[] twoNumberSumOptimized(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();
        for (int num: array) {
            int match = targetSum - num;
            if(nums.contains(match)) {
                return new int[]{match,num};
            } else {
                nums.add(num);
            }
        }
        return new int[0];
    }
}