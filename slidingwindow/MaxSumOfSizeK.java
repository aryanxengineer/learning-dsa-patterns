package slidingwindow;

public class MaxSumOfSizeK {
    public static int maxSumOfSizeK(int[] nums, int k) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int low = 0, high = k - 1;
        while (high < nums.length) {
            maxSum = Math.max(sum, maxSum);
            high++;
            low++;
            if (high != nums.length) {
                sum = sum + nums[high] - nums[low - 1];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
        int maxSum = maxSumOfSizeK(nums, 4);
        System.out.println("Maximum sum = " + maxSum);
    }
}
