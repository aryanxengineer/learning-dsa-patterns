package twopointerpatterns;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;
        int sum = 0;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left, right };
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int[] answerArr = twoSum(arr, 9);
        System.out.println(Arrays.toString(answerArr));
    }
}
