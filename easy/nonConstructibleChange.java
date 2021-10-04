package easy;

/**
 * @author Brandon Soledad
 * 
 * Algorithms Practice
 * 
 * Given an array of positive integers representing the values of coins in your possession, write a function
 * that returns the minimum amount of change (the minimum sum of money) that you cannot create. The given coins
 * can have any positive integer value and aren't necessarily unique (ie., you can have multiole coints of the same value).
 * 
 * For example, if you're given coins = [1, 2, 5], the minimum amount of change that you can't create is 4. If you're given no 
 * coins, the minimum of change that you can't create is 1.
 */

import java.util.*;
public class nonConstructibleChange {
    public static void main(String[] args) {
        nonConstructibleChange one = new nonConstructibleChange();
        int[] input = new int[] {5, 7, 1, 1, 2, 3, 22};
        int expected = 20;
        var actual = one.nonConstructibleChange(input); 
        System.out.println("Expected: " + expected + " " + "Actual: " + actual);
    }
    // Time: O(nlogn) Space: O(1) where n is the number of coins.
    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
            int currentMinimum = 0;
            for(int num : coins){
                if(num > currentMinimum + 1){
                    return currentMinimum + 1;
                }
                currentMinimum += num;
            }
        return currentMinimum + 1;
      }
}
